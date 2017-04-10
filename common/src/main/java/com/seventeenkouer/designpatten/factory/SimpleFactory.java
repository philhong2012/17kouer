package com.seventeenkouer.designpatten.factory;

import com.seventeenkouer.common.utils.StringUtils;

/**
 * Created by wind on 17/4/10.
 * 简单工厂
 */
public class SimpleFactory {
    public Operator getOperator(Character op) {
//        if(StringUtils.equals(op,"+")) {
//
//        }
        switch (op) {
            case  '+' :
                return new AddOperator();
            case '-':
                return new SubtractOperator();
            case '*':
                return new MultiplyOperator();
            case '/':
                return new DivideOperator();
            default:
                return null;
        }
    }
}
