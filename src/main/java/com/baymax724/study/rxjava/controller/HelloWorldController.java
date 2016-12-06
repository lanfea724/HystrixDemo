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

/**
 * Created by sunao on 2016/12/6.
 */
@Controller
public class HelloWorldController {

    @ResponseBody
    @RequestMapping(value = {"/helloWorld/{name}"})
    public String helloWorld(@PathVariable String name) {
        String str1 = new CommandHelloWorld(name).execute();
        String str2 = new CommandHelloUniverse(name).execute();
        String str3 = new CommandHelloMultiverse(name).execute();
        return StringUtils.join(ImmutableList.of(str1, str2, str3), ",");
    }
}
