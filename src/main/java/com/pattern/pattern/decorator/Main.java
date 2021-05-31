package com.pattern.pattern.decorator;

/**
 * Description: decorator装饰者模式： 为对象不断装饰的模式
 *
 * 主要角色：
 *  component：接口或抽象类
 *  concreteComponent: 实现或继承了component的实体类
 *  decorator: 抽象装饰类
 *  concreteDecorator： 具体装饰类
 *
 * 装饰类和被装饰类可以独立发展，不会相互耦合，装饰模式是继承的一个替代模式，装饰模式可以动态扩展一个实现类的功能。
 *
 * @author lihui
 * @time 2021/5/31 8:28 下午
 */
public class Main {

    public static void main(String[] args) {
        Display display = new StringDisplay("Hello World");
        display.show();
        SlideBorder border = new SlideBorder(display, '|');
        System.out.println(border.getRowText(0));
    }



}
