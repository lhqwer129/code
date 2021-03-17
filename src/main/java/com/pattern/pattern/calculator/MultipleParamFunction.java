package com.pattern.pattern.calculator;

/**
 * Description:
 *
 * @author lihui
 * @time 2021/3/15 8:45 下午
 */
@FunctionalInterface
public interface MutipleParamFunction<T, C, R> {

    R apply(T t, C c);

}
