package com.seventeenkouer.designpatten.visitor;

/**
 * Created by xubing.hong on 3/28/2017.
 */
public class ConcreteVisitorA implements IVisitor {
    @Override
    public void visitConcreteElementA(ConcreteElementA concreteElementA) {

    }

    @Override
    public void visitConcreteElementB(ConcreteElementB concreteElementB) {

    }

    @Override
    public void visitElement(BaseElement baseElement) {
        if(baseElement instanceof ConcreteElementA) {
            //baseElement.accept();

        } else if(baseElement instanceof  ConcreteElementB) {

        }
    }
}
