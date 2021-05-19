package com.pattern.pattern.adapter.extend;

/**
 * Description:
 *
 * @author lihui
 * @time 2021/5/14 5:10 下午
 */
public class PrintBanner extends Banner implements Print {

    public PrintBanner(String string) {
        super(string);
    }

    @Override
    public void printWeak() {
        this.showWithParen();
    }

    @Override
    public void printStrong() {
        this.showWithAster();
    }
}
