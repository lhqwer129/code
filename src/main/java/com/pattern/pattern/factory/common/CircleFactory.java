package com.pattern.pattern.factory.common;

import com.pattern.pattern.factory.simple.Circle;
import com.pattern.pattern.factory.simple.Shape;

/**
 * Description:
 *
 * @author lihui
 * @time 2021/5/18 7:28 下午
 */
public class CircleFactory implements ShapeFactory {

    @Override
    public Shape create() {
        return new Circle();
    }
}
