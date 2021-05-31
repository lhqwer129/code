package com.pattern.pattern.decorator;

/**
 * Description: 抽象类，声明display方法
 *
 * @author lihui
 * @time 2021/5/31 8:33 下午
 */
public abstract class Display {

    public abstract int getColumns();

    public abstract int getRows();

    public abstract String getRowText(int row);

    public final void show() {
        for (int i = 0; i < getRows(); i++) {
            System.out.println(getRowText(i));
        }
    }

}
