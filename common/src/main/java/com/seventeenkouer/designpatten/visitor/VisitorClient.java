package com.seventeenkouer.designpatten.visitor;

/**
 * Created by xubing.hong on 3/28/2017.
 * 演示访问者模式
 * 不变因子：数据结构必须是稳定的即BaseElement的子类是确定的
 * 变化因子：访问者，例如访问者是一个状态 ，1，2，3，4，对应1，2，3，4 去实现数据结构在4个状态下的行为逻辑
 */
public class VisitorClient {
    public static void main(String[] args) {

        ConcreteStructure concreteStructure = new ConcreteStructure();
        ConcreteElementA a = new ConcreteElementA();
        ConcreteElementB b = new ConcreteElementB();
        concreteStructure.attach(a);
        concreteStructure.attach(b);

        ConcreteVisitorA va = new ConcreteVisitorA();

        concreteStructure.accept(va);
    }
}
