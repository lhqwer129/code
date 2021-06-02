package com.pattern.pattern.responsibility;

/**
 * Description: 具体解决问题的类，Support的子类
 *
 * @author lihui
 * @time 2021/6/2 7:45 下午
 */
public class NoSupport extends Support {

    public NoSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        return false;
    }
}
