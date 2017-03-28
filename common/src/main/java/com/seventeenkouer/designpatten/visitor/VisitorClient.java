package com.seventeenkouer.designpatten.visitor;

/**
 * Created by xubing.hong on 3/28/2017.
 * 演示访问者模式
 * 不变因子：数据结构必须是稳定的即BaseElement的子类是确定的
 * 变化因子：访问者，例如访问者是一个状态 ，1，2，3，4，对应1，2，3，4 去实现数据结构在4个状态下的行为逻辑
 * 将数据结构与算法剥离
 * 适用于数据结构稳定，而算法又多变的系统，访问者模式使得增加算法操作变得容易，缺点就是数据结构不能随意变动，数据结构变化，那么访问者的接口是不稳定的
 * 访问着模式适用于数据结构（一个只有属性的类）稳定的系统
 *
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
