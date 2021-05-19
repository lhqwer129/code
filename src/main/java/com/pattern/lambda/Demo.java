package com.pattern.lambda;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author lihui
 * @time 2020/10/13 8:59 下午
 */
public class Demo {

    public static void main(String[] args){
        // Predicate 用于判断真假
        Predicate<Integer> predicate = x -> x > 185;
        boolean isGreaterThan185 = predicate.test(190);
        System.out.println("Predicate judge is " + Objects.equals(true, isGreaterThan185));

        // Consumer 消费消息
        Consumer<Integer> consumer = System.out::println;
        Consumer<Integer> integerConsumer = x -> System.out.println(x + 1);
        consumer.andThen(integerConsumer).accept(1);

        // Function 将T映射成R
        Function<Integer, String> integerStringFunction =
            i -> "将Integer映射成String:" + i;

        System.out.println(integerStringFunction.apply(1));
    }




}
