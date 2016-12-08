package com.baymax724.study.rxjava.hystrix.command;

import com.baymax724.study.rxjava.hystrix.storage.HystrixRequestVariables;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * Created by sunao on 2016/12/6.
 */
public class CommandHelloWorld extends HystrixCommand<String>{

    private final String name;

    public CommandHelloWorld(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("CommandHelloWorld"));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        String traceId = HystrixRequestVariables.getRequestVariable();
        return "HelloWorld-" + name + " traceId-" + traceId;
    }
}
