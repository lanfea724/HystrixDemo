package com.baymax724.study.rxjava.controller;

import com.baymax724.study.rxjava.hystrix.command.CommandHelloMultiverse;
import com.baymax724.study.rxjava.hystrix.command.CommandHelloUniverse;
import com.baymax724.study.rxjava.hystrix.command.CommandHelloWorld;
import com.google.common.collect.ImmutableList;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by sunao on 2016/12/6.
 */
@Controller
public class HelloWorldController {

    @ResponseBody
    @RequestMapping(value = {"/helloWorld/{name}"})
    public String helloWorld(@PathVariable String name) throws ExecutionException, InterruptedException {
        Future<String> futureStr1 = new CommandHelloWorld(name).queue();
        Future<String> futureStr2 = new CommandHelloUniverse(name).queue();
        Future<String> futureStr3 = new CommandHelloMultiverse(name).queue();
        String str1 = futureStr1.get();
        String str2 = futureStr2.get();
        String str3 = futureStr3.get();
        return StringUtils.join(ImmutableList.of(str1, str2, str3), ",");
    }
}
