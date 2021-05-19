package com.pattern.pattern.factory.simple;

/**
 * Description:
 *
 * @author lihui
 * @time 2021/5/18 7:25 下午
 */
public class Main {

    public static void main(String[] args) {
        Shape shape = ShapeFactory.create("circle");
        shape.sayHello();
    }

}
