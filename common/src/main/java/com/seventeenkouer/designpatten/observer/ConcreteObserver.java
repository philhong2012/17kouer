package com.seventeenkouer.designpatten.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by wind on 17/4/10.
 * 观察者
 */
public class ConcreteObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        ConcreteObserable o1 = (ConcreteObserable)o;
        System.out.println("观察者:ConcreteObserver的状态是:" + o1.getState());
    }
}
