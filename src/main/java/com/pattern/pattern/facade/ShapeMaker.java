package com.pattern.pattern.facade;

/**
 * Description:
 *
 * @author lihui
 * @time 2021/6/4 8:30 下午
 */
public class ShapeMaker {
    private Circle circle;
    private Rectangle rectangle;

    public ShapeMaker() {
        this.circle = new Circle();
        this.rectangle = new Rectangle();
    }

    public void drawCircle() {
        circle.draw();
    }

    public void drawRectangle() {
        rectangle.draw();
    }

}
