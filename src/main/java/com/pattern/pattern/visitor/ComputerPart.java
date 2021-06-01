package com.pattern.pattern.visitor;

/**
 * Description: 用于接收访问者的类
 *
 * @author lihui
 * @time 2021/6/1 8:21 下午
 */
public interface ComputerPart {

    public void accept(ComputerPartVisitor computerPartVisitor);

}
