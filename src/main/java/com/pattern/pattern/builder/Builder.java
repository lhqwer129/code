package com.pattern.pattern.builder;

/**
 * Description: 建造者，定义生成实例的api
 *
 * @author lihui
 * @time 2021/5/24 8:09 下午
 */
public abstract class Builder {

    public abstract void makeTitle(String title);

    public abstract void makeString(String str);

    public abstract void makeItems(String[] items);

    public abstract void close();
}
