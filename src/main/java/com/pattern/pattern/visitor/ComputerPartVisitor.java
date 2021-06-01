package com.pattern.pattern.visitor;

/**
 * Description: 访问者接口或抽象类，用于定义访问方法，具体访问细节在其实现类或子类实现
 *
 * @author lihui
 * @time 2021/6/1 8:20 下午
 */
public interface ComputerPartVisitor {

    public void visit(Keyboard keyboard);

    public void visit(Mouse mouse);

}
