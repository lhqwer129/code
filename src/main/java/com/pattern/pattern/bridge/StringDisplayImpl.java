package com.pattern.pattern.bridge;

import java.nio.charset.StandardCharsets;

/**
 * Description:
 *
 * @author lihui
 * @time 2021/5/25 8:44 下午
 */
public class StringDisplayImpl extends DisplayImpl {

    private String string;
    private int width;

    public StringDisplayImpl(String string) {
        this.string = string;
        this.width = string.getBytes(StandardCharsets.UTF_8).length;
    }


    @Override
    public void rawOpen() {
        printLine();
    }

    @Override
    public void rawPrint() {
        System.out.println("|" + string + "|");

    }

    @Override
    public void rawClose() {
        printLine();
    }

    private void printLine() {
        System.out.print("+");
        for (int i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}
