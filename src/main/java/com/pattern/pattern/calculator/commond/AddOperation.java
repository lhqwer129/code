package com.pattern.pattern.calculator.commond;

public class AddOperation implements Operation{

    int a;

    int b;

    public AddOperation(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int apply() {
        return a + b;
    }
}
