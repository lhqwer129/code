package com.pattern.pattern.adapter.extend;

/**
 * Description:
 *
 * @author lihui
 * @time 2021/5/14 5:08 下午
 */
public class Banner {
    public String string;

    public Banner(String string) {
        this.string = string;
    }

    public void showWithParen() {
        System.out.println("(" + string + ")");
    }

    public void showWithAster() {
        System.out.println("*" + string + "*");
    }

}
