package com.pattern.pattern.responsibility;

/**
 * Description: Support子类
 *
 * @author lihui
 * @time 2021/6/2 7:48 下午
 */
public class OddSupport extends Support {

    public OddSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return trouble.getNumber() % 2 == 1;
    }

}
