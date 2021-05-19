package com.pattern.pattern.prototype;

/**
 * Description:
 *
 * @author lihui
 * @time 2021/5/18 8:43 下午
 */
public interface Product extends Cloneable {

    void use(String s);

    Product createClone();
}
