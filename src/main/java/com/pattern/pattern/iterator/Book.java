package com.pattern.pattern.iterator;

/**
 * Description:
 *
 * @author lihui
 * @time 2021/5/14 3:38 下午
 */
public class Book {
    String name;

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                '}';
    }
}
