package com.pattern.pattern.responsibility;

/**
 * Description: chain of responsibility责任链模式
 * 为请求者创建一系列处理请求对象的责任链，如果一个对象无法处理请求，则转给下一个对象处理
 * 1、将请求者与接受者解耦，请求者无需关注处理细节
 * 2、可以动态的修改责任链，改变责任链中对象的顺序
 *
 * 缺点: 会对请求性能造成一定的影响
 *
 *
 * 主要角色:
 * 1、处理者，定义处理请求的接口，特别是指定"下一个处理者"的方法
 * 2、具体的处理者，实现具体的处理方法
 * 3、请求者（Main扮演）
 *
 * @author lihui
 * @time 2021/6/2 7:25 下午
 */
public class Main {

    public static void main(String[] args) {
        Support alice = new NoSupport("Alice");
        Support tom = new LimitSupport("Tom", 100);
        Support jerry = new LimitSupport("Jerry", 200);
        Support dog = new OddSupport("Dog");

        alice.setNext(tom).setNext(jerry).setNext(dog);

        for(int i =0; i < 300; i++) {
            alice.support(new Trouble(i));
        }
    }


}
