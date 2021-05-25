package com.pattern.pattern.builder;

/**
 * Description: 建造者模式
 * 1、使用多个简单的对象一步一步构建成一个复杂的对象
 * 2、将一个复杂对象的**构建与其表示分离**，使得同样的构建过程可以创建不同的表示。builder pattern通过抽象建造类定义建造方法，具体的表示在子类中实现
 *
 *
 * @author lihui
 * @time 2021/5/24 8:26 下午
 */
public class Main {

    public static void main(String[] args) {
        TextBuilder textBuilder = new TextBuilder();
        textBuilder = new TextBuilder();
        Director director = new Director(textBuilder);
        director.construct();
        System.out.println(textBuilder.getResult());
    }

}
