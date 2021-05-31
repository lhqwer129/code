package com.pattern.pattern.composite;

/**
 *
 * 组合模式
 * Description: 创造出一种递归结构，使容器与容器内容具有一致性，最典型的代表如文件夹，上下级关系, 树状结构
 *
 * 主要角色:
 *  leaf: 表示内容的角色
 *  Composite： 表示容器的角色
 *  Component： 是leaf和composite具有一致性的角色
 *  Client: 客户端（Main类）
 *
 * @author lihui
 * @time 2021/5/27 7:17 下午
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Directory rootDir = new Directory("root");
        Directory binDir = new Directory("bin");
        Directory tmpDir = new Directory("tmp");
        Directory usrDir = new Directory("usr");
        rootDir.add(binDir);
        rootDir.add(tmpDir);
        rootDir.add(usrDir);
        binDir.add(new File("vi", 10000));
        binDir.add(new File("latex", 10000));
        rootDir.printList("unix");

    }

}
