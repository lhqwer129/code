package com.pattern.pattern.calculator;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lihui
 */
public class Calculator {

    public static final Map<String, MultipleParamFunction<Integer, Integer, Integer>> FUNCTION_MAP = new HashMap<>();

    static {
        FUNCTION_MAP.put("add", Integer::sum);
        FUNCTION_MAP.put("multiply", (x, y) -> x * y);
    }

    public int ifCalculate(int a, int b, String operator) {
        int result = Integer.MIN_VALUE;
        if ("add".equals(operator)) {
            result = a + b;
        } else if ("multiply".equals(operator)) {
            result = a * b;
        } else if ("divide".equals(operator)) {
            result = a / b;
        } else if ("subtract".equals(operator)) {
            result = a - b;
        } else {
            throw new IllegalArgumentException("illegal operator");
        }

        return result;
    }

    public int switchCalculate(int a, int b, String operator) {
        int result = Integer.MIN_VALUE;
        switch (operator) {
            case "add":
                result = a + b;
                break;
            default:
                throw new IllegalArgumentException("illegal operator");
        }
        return result;
    }

    public int functionCalculate(int a, int b, String operator) {
        return FUNCTION_MAP.get(operator).apply(a, b);
    }

    /**
     * 卫语句
     */
    public int calculate(int a, int b, String operator) {
        if ("add".equals(operator)) {
            return a + b;
        }
        if ("multiply".equals(operator)) {
            return a - b;
        }

        throw new IllegalArgumentException("illegal operator");
    }



}
