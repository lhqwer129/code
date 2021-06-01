package com.pattern.pattern.visitor;

/**
 * Description:
 *
 * @author lihui
 * @time 2021/6/1 8:25 下午
 */
public class ComputerPartDisplayVisitor implements ComputerPartVisitor {

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("displaying keyboard");
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("displaying mouse");
    }
}
