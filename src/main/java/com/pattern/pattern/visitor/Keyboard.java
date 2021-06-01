package com.pattern.pattern.visitor;

/**
 * Description:待访问类
 *
 * @author lihui
 * @time 2021/6/1 8:22 下午
 */
public class Keyboard implements ComputerPart{


    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
