package com.pattern.pattern.calculator;

/**
 * Description:
 *
 * @author lihui
 * @time 2021/3/15 8:45 下午
 */
@FunctionalInterface
interface MultipleParamFunction<T, C, R> {

    R apply(T t, C c);

}
