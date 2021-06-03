package com.pattern.pattern.decorator;

/**
 * Description:
 *
 * @author lihui
 * @time 2021/5/31 8:43 下午
 */
public abstract class Border {

    protected Display display;

    protected Border(Display display) {
        this.display = display;
    }
}
