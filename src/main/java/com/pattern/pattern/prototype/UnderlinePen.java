package com.pattern.pattern.prototype;

import java.nio.charset.StandardCharsets;

/**
 * Description:
 *
 * @author lihui
 * @time 2021/5/20 7:36 下午
 */
public class UnderlinePen implements Product {

    private char ulchar;

    public UnderlinePen(char ulchar) {
        this.ulchar = ulchar;
    }

    @Override
    public void use(String s) {
        int length = s.getBytes(StandardCharsets.UTF_8).length;
        System.out.println("\"" + s + "\"");
        for (int i = 0; i < length + 4; i++) {
            System.out.print(ulchar);
        }
        System.out.println(" ");
    }

    @Override
    public Product createClone() {
        Product product = null;
        try {
            product = (Product) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return product;
    }
}
