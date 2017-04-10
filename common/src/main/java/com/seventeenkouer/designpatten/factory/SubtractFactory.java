package com.seventeenkouer.designpatten.factory;

/**
 * Created by wind on 17/4/10.
 * 工厂方法子类
 */
public class SubtractFactory extends Factory{
    Operator getOperator() {
        return new SubtractOperator();
    }
}
