package com.baymax724.study.rxjava.hystrix.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * Created by sunao on 2016/12/6.
 */
public class CommandHelloUniverse extends HystrixCommand<String> {

    private final String name;

    public CommandHelloUniverse(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("CommandHelloUniverse"));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        return "HelloUniverse-" + name;
    }
}
