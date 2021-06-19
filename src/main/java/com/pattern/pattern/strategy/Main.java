package com.pattern.pattern.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 策略模式
 * 策略在编程中可以理解为算法，针对同一个问题，策略模式的目的是实现整体策略部分的替换，已不同的策略（算法）来解决问题
 *
 * 角色:
 *  1、策略: 定义实现策略需要的接口
 *  2、具体策略：通过不同方法实现策略类定义的方法
 *  3、context上下文：负责使用策略的类
 *s
 *  context与strategy是组合的关系，
 *
 *
 * @author lihui
 * @time 2021/5/26 8:25 下午
 */
public class Main {

    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println("10 + 5 = " + context.excuteStrategy(10, 5));

        context = new Context(new OperationSubtract());
        System.out.println("10 - 5 = " + context.excuteStrategy(10, 5));
    }

}
