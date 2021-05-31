package com.pattern.pattern.composite;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Description:
 *
 * @author lihui
 * @time 2021/5/31 8:12 下午
 */
public class Directory extends Entry {

    private String name;
    private ArrayList<Entry> directory = new ArrayList();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size = 0;
        Iterator iterator = directory.iterator();
        while(iterator.hasNext()) {
            Entry entry = (Entry) iterator.next();
            size += entry.getSize();
        }
        return 0;
    }

    @Override
    public Entry add(Entry entry) throws Exception {
        directory.add(entry);
        return this;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        Iterator iterator = directory.iterator();
        while(iterator.hasNext()) {
            Entry entry = (Entry) iterator.next();
            entry.printList(prefix + "/" + name);
        }
    }
}


