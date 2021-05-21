package com.pattern.pattern.prototype;

import sun.plugin2.message.Message;

/**
 * Description:
 *
 * @author lihui
 * @time 2021/5/20 7:42 下午
 */
public class Main {

    public static void main(String[] args) {
        Manager manager = new Manager();
        UnderlinePen underlinePen = new UnderlinePen('~');
        MessageBox messageBox = new MessageBox('*');
        MessageBox sBox = new MessageBox('/');
        manager.register("strong message", underlinePen);
        manager.register("* box", messageBox);
        manager.register("/ box", sBox);

        System.out.println(manager.create("strong message") == manager.create("strong message"));

        Product p1 = manager.create("strong message");
        Product p2 = manager.create("strong message");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p1 == p2);
        System.out.println(manager.getClass());
    }


}
