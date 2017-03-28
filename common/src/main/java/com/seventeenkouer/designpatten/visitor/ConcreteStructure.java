package com.seventeenkouer.designpatten.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xubing.hong on 3/28/2017.
 * 提供一个更高层的类，供访问者客户端调用
 */
public class ConcreteStructure {
    private List<BaseElement> elementList = new ArrayList<BaseElement>();
    public void attach(BaseElement element) {
        elementList.add(element);
    }

    public void detach(BaseElement element) {
        elementList.remove(element);
    }

    public void accept(IVisitor visitor) {
        for(BaseElement e : elementList) {
            e.accept(visitor);
        }
    }

}
