package com.pattern.pattern.bridge;

/**
 * Description: 桥接模式将"类的功能层次结构"与"类的实现层次结构"分离开
 * 1、有利于功能层次与实现层次独立的扩展
 * 2、抽象与实现解耦
 *
 * 角色：抽象化，改善后的抽象画，实现抽象类，具体的实现类
 * 抽象化类与实现抽象类是组合关系，代替实现关系，降低耦合度
 *
 * @author lihui
 * @time 2021/5/25 8:47 下午
 */
public class Main {

    public static void main(String[] args) {
        Display display1 = new Display(new StringDisplayImpl("Hello, China,"));
        Display display2 = new CountDisplay(new StringDisplayImpl("Hello, World,"));
        CountDisplay display3 = new CountDisplay(new StringDisplayImpl("Hello, Universe,"));
        display1.display();
        display2.display();
        display3.display();
        display3.multiDisplay(5);
    }

}
