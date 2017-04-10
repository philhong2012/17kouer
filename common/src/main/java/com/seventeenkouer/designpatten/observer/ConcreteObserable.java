package com.seventeenkouer.designpatten.observer;

import java.util.Observable;

/**
 * Created by wind on 17/4/10.
 * 主题对象
 */
public class ConcreteObserable extends Observable {
    private String state;


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        super.setChanged();
    }
}
