package com.pattern.pattern.builder;

/**
 * Description: director使用builder类中声明的方法来编写(build)一个文档
 *
 * @author lihui
 * @time 2021/5/24 8:08 下午
 */
public class Director {

    private final Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct() {
        builder.makeTitle("Greeting");
        builder.makeString("从早上到下午");
        builder.makeItems(new String[] {
                "早上好",
                "中午好",
                "下午好"
        });
        builder.makeString("晚上");
        builder.makeItems(new String[]{
                "晚上好",
                "晚安",
                "再见"
        });
        builder.close();
    }


}
