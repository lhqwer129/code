package com.pattern.pattern.visitor;

/**
 * Description: visitor访问者模式，目的是将数据结构与数据操作分离，可以简单的扩展对数据操作的方法
 *
 * 主要角色:
 * 1、访问者
 * 2、具体的访问者
 * 3、元素element，定义接收访问者的方法
 * 4、具体element，实现接收访问者的方法
 * 5、数据结构
 *
 * 访问者模式对修改关闭，对扩展开放
 * @author lihui
 * @time 2021/6/1 7:44 下午
 */
public class Main {

    public static void main(String[] args) {
        Keyboard keyboard = new Keyboard();
        keyboard.accept(new ComputerPartDisplayVisitor());
    }






}
