package com.pattern.pattern.responsibility;

/**
 * Description: 发生问题的类
 *
 * @author lihui
 * @time 2021/6/2 7:29 下午
 */
public class Trouble {
    private int number;

    public Trouble(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Trouble{" +
                "number=" + number +
                '}';
    }
}
