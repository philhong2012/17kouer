package com.seventeenkouer.designpatten.visitor;

/**
 * Created by xubing.hong on 3/28/2017.
 */
public class ConcreteElementA extends BaseElement {
    @Override
    public void accept(IVisitor visitor) {
        visitor.visitConcreteElementA(this);
    }
}
