package com.baymax724.study.rxjava.hystrix.storage;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestVariableDefault;

/**
 * Created by sunao on 2016/12/8.
 */
public class HystrixRequestVariables {

    private static HystrixRequestVariableDefault<String> requestVariable = new HystrixRequestVariableDefault<String>();

    public static String getRequestVariable() {
        return requestVariable.get();
    }

    public static void setRequestVariable(String variable) {
        requestVariable.set(variable);
    }
}
