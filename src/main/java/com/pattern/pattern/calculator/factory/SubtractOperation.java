package com.pattern.pattern.calculator.factory;

/**
 * @author lihui
 */
public class SubtractOperation implements Operation<Integer, Integer> {

    @Override
    public Integer apply(Integer a, Integer b) {
        return a - b;
    }
}
