package com.pattern.pattern.composite;

/**
 * Description: 抽象类，目的是使容器以及其内容具有一致性(通过继承的但是实现)
 *
 * @author lihui
 * @time 2021/5/31 7:53 下午
 */
public abstract class Entry {

    public abstract String getName();

    public abstract int getSize();

    public Entry add(Entry entry) throws Exception {
        throw new Exception();
    }

    protected abstract void printList(String prefix);

    @Override
    public String toString() {
        return getName() + "(" + getSize() + ")";
    }
}
