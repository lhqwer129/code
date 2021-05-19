package com.pattern.pattern.calculator.factory;

public interface Operation<T, R> {

    R apply(T a, T b);
}