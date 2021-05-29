package com.pattern.pattern.strategy;

/**
 * Description:
 *
 * @author lihui
 * @time 2021/5/26 8:22 下午
 */
public class OperationSubtract implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        return  num1 - num2;
    }
}
