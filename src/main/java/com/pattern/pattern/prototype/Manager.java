package com.pattern.pattern.prototype;

import java.util.HashMap;

/**
 * Description:
 *
 * @author lihui
 * @time 2021/5/20 7:40 下午
 */
public class Manager {

    private HashMap<String, Product> showcase = new HashMap();
    public void register(String name, Product product) {
        showcase.put(name, product);
    }

    public Product create(String protoName) {
        Product product = showcase.get(protoName);
        return product.createClone();
    }

}
