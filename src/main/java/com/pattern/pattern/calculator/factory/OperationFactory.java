package com.pattern.pattern.calculator.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lihui
 */
public class OperationFactory {

    private static final Map<String, Operation<Integer, Integer>> operationHashMap = new HashMap<>();

    static {
        operationHashMap.put("add", new AddOperation());
        operationHashMap.put("subtract", new SubtractOperation());
    }

    public Operation<Integer, Integer> getOperation(String operator) {
        return operationHashMap.get(operator);
    }

}
