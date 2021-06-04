package com.pattern.pattern.facade;

/**
 * Description: facade外观模式
 * 外观模式隐藏系统的复杂性，提供一个供客户端访问的高层接口，客户端只与该接口交互即可
 *
 * 缺点：不符合开闭原则
 *
 * @author lihui
 * @time 2021/6/2 8:12 下午
 */
public class Main {

    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();
        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
    }



}
