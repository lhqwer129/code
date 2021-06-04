### flink

一、flink是啥？

> Apache Flink is a framework and distributed processing engine for stateful computations over *unbounded and bounded* data streams. Flink has been designed to run in *all common cluster environments*, perform computations at *in-memory speed* and at *any scale*

- 分布式处理引擎

- 通过`状态计算`来处理`有界`和`无界`数据流

- `内存速度`和`任意规模`进行计算

1.1 数据流

![Bounded and unbounded streams](https://ci.apache.org/projects/flink/flink-docs-release-1.11/fig/bounded-unbounded.png "")

1.2 状态计算

> Flink’s operations can be stateful. This means that how one event is handled can depend on the accumulated effect of all the events that came before it。example:  such as counting events per minute to display on a dashboard, or for something more complex, such as computing features for a fraud detection model.

1、每分钟event次数展示:

- countState去统计event出现次数

2、欺诈检测: 对于一个账户，如果出现小于 $1 美元的交易后紧跟着一个大于 $500 的交易，报警。

- 添加一个flagState，类型为boolean

- 小于$1 -> flagState = false

- 大于$2 -> flagState = true, 报警

flink支持通过`keyBy()`来对对event进行分类

1.3 内存速度( *in-memory speed*)和任意规模(*any scala*)

- 内存速度：flink的任务通过访问内存或者高速磁盘进行计算

- 任意规模：flink任务可以并行

二、处理流程

![A DataStream program, and its dataflow.](https://ci.apache.org/projects/flink/flink-docs-release-1.11/fig/program_dataflow.svg "")

- source: date stream  `kafka message` -> `DataStream`    
- Transformation: 通过flink api对流数据进行处理 `table event record` -> `map`
- sink：持久化存储。`map` -> `tidb`



### Ei-Data-Engine

```java
environment.addSource(new KafkaMsgConfig()).keyBy((eventRecord) -> {
    if (eventRecord == null) {
        return DEFAULT_TABLE_KEY;
    }
    EventHeader eventHeader = eventRecord.getHeader();

    if (eventHeader == null) {
        return DEFAULT_TABLE_KEY;
    }
    return eventHeader.getTableName();
}).filter(new TopicFilter())
  .map(new VKDataMapper())
  .addSink(tidbSink);
```



#### keyBy

flink job启动时会开启多个task节点去并行处理data stream, keyBy保证相同的key的消息在同一个task节点中处理，防止消费顺序出错。

#### source

* poll()方法不断拉取vkdatabus数据，而不是通过注解
* 通过Thread.sleep()动态控制拉取速率，防止服务压力过大
* 根据时间戳设置消费的offset，避免消息漏消费



#### filter

过滤无用消息

####map

1. 获取kafka msg。 EventRecord
2. EventRecord -> source table Column Modification Map<String, Object>
3. Map<String, Object> ----读取配置文件映射关系-------> Map<String, Object>

#### sink

```java
void insertMap(@Param("table") String table, @Param("columns") Map<String, Object> columns);

@Retryable
Integer updateMap(@Param("table") String table, @Param("id") String id, @Param("columns") Map<String, Object> columns);


void deleteById(@Param("table") String table, @Param("id") String id);
```



* 针对小概率时间: update语句在insert语句未执行完之前执行的情况

通过BolckingQuene去收集failed update record，进行重试





### 坑

针对数据库操作存在replace into语句的情况，无法正在处理这类数据

原因: replace into

* 存在记录 delete -> insert
  * 针对这种情况，vkdatabus读取binlog发送的kafka消息是类似 update table set id = 2 where id = 1的语句  
* 不存在记录 insert

