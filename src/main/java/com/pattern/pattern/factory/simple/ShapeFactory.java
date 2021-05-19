package com.pattern.pattern.factory.simple;

/**
 * Description:
 *
 * @author lihui
 * @time 2021/5/18 7:23 下午
 */
public class ShapeFactory {

    public static Shape create(String name) {
        if (name == null) {
            return null;
        }

        if ("circle".equals(name)) {
            return new Circle();
        }

        if ("rectabgle".equals(name)) {
            return new Rectangle();
        }

        return null;

    }

}
