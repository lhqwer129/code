### 迭代器模式
#### 迭代器模式角色
* Iterator(迭代器) </br>
该角色定义遍历集合元素的方法。如示例程序中`hasNext()`和`next()`
* ConcreteIterator(具体迭代器) </br>
该角色实现`Iterator`中所定义的方法。
* Aggregate(集合)</br>
该角色定义创建`Iterator`的方法 
* ConcreteAggregate(具体集合)</br>
该角色实现`Aggregate`定义的方法
  
#### 迭代器模式介绍
**意图**：遍历集合元素 </br>
**优势**: 
* 修改或新增集合类，原有的遍历逻辑不会改变，只需要修改底层遍历逻辑即可
* 对客户端隐藏了遍历逻辑，尤其是复查对象，有利于增加安全性
* 增加了代码的复用性
