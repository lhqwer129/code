package com.pattern.pattern.strategy;

/**
 * Description:
 *
 * @author lihui
 * @time 2021/5/26 8:24 下午
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int excuteStrategy(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}
