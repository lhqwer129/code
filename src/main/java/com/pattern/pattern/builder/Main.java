package com.pattern.pattern.builder;

/**
 * Description: 使用者，使用Director来建造实例
 *
 * @author lihui
 * @time 2021/5/24 8:26 下午
 */
public class Main {

    public static void main(String[] args) {
        TextBuilder textBuilder = new TextBuilder();
        textBuilder = new TextBuilder();
        Director director = new Director(textBuilder);
        director.construct();
        System.out.println(textBuilder.getResult());
    }

}
