package com.pattern.pattern.bridge;

/**
 * Description:
 *
 * @author lihui
 * @time 2021/5/25 8:42 下午
 */
public class CountDisplay extends Display {

    public CountDisplay(DisplayImpl impl) {
        super(impl);
    }

    public void multiDisplay(int times) {
        open();
        for (int i = 0; i < times; i++) {
            print();
        }
        close();
    }
}
