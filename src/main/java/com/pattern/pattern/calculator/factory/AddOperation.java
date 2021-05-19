package com.pattern.pattern.calculator.factory;

public class AddOperation implements Operation<Integer, Integer> {

    @Override
    public Integer apply(Integer a, Integer b) {
        return a + b;
    }
}
