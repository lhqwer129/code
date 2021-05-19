package com.pattern.pattern.factory.common;

import com.pattern.pattern.factory.simple.Shape;

/**
 * Description:
 *
 * @author lihui
 * @time 2021/5/18 7:28 下午
 */
public class Main {

    public static void main(String[] args) {
        CircleFactory circleFactory = new CircleFactory();
        Shape shape = circleFactory.create();
        shape.sayHello();
    }

}
