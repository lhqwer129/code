package com.pattern.pattern.adapter.extend;

/**
 * Description:
 *
 * @author lihui
 * @time 2021/5/14 5:13 下午
 */
public class Main {

    public static void main(String[] args) {
        Print p = new PrintBanner("Hello World");
        p.printStrong();
        p.printWeak();
    }

}
