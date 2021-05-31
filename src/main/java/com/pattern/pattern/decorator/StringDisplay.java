package com.pattern.pattern.decorator;

import java.nio.charset.StandardCharsets;

/**
 * Description:
 *
 * @author lihui
 * @time 2021/5/31 8:42 下午
 */
public class StringDisplay extends Display {

    private String string;

    public StringDisplay(String string) {
        this.string = string;
    }

    @Override
    public int getColumns() {
        return string.getBytes(StandardCharsets.UTF_8).length;
    }

    @Override
    public int getRows() {
        return 1;
    }

    @Override
    public String getRowText(int row) {
        if (row == 0) {
            return string;
        } else {
            return null;
        }
    }
}
