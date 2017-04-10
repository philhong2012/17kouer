package com.seventeenkouer.designpatten.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by wind on 17/4/10.
 * 客户端程序
 */
public class ObserverClient {

    public static void main(String[] args) {

        ConcreteObserable observable = new ConcreteObserable();
        Observer observer = new ConcreteObserver();
        //增加观察者
        observable.addObserver(observer);
        observable.setState("状态改变啦");
        //通知观察者
        observable.notifyObservers(observable);

    }

}
