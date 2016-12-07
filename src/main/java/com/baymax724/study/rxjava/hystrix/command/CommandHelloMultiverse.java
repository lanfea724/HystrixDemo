package com.baymax724.study.rxjava.hystrix.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by sunao on 2016/12/6.
 */
public class CommandHelloMultiverse extends HystrixCommand<String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommandHelloMultiverse.class);
    private final String name;

    public CommandHelloMultiverse(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("CommandHelloMultiverse"));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        return "HelloMultiverse-" + name;
    }
}
