package com.pattern.pattern.calculator.commond;

/**
 * @author lihui
 */
public class SubstractOperation implements Operation {

    int a;

    int b;

    public SubstractOperation(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int apply() {
        return a - b;
    }
}
