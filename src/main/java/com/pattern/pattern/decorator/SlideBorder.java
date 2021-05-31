package com.pattern.pattern.decorator;

/**
 * Description:
 *
 * @author lihui
 * @time 2021/5/31 8:44 下午
 */
public class SlideBorder extends Border {

    private char borderChar;

    protected SlideBorder(Display display, char ch) {
        super(display);
        this.borderChar = ch;
    }

    public int getColumns() {
        return 1 + display.getColumns() + 1;
    }

    public int getRows() {
        return display.getRows();
    }

    public String getRowText(int row) {
        return  borderChar + display.getRowText(row) + borderChar;
    }
}
