package com.pattern.pattern.responsibility;

/**
 * Description: Support子类
 *
 * @author lihui
 * @time 2021/6/2 7:46 下午
 */
public class LimitSupport extends Support {

    private int limit;

    public LimitSupport(String name, int limit) {
        super(name);
        this.limit = limit;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if (trouble.getNumber() < limit) {
            return true;
        }

        return false;
    }
}
