package com.baymax724.study.rxjava.hystrix.filter;

import com.baymax724.study.rxjava.hystrix.storage.HystrixRequestVariables;
import com.netflix.hystrix.HystrixRequestLog;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Random;

/**
 * Created by sunao on 2016/12/6.
 */
public class HystrixHelloFilter implements Filter {

    private final static Logger LOGGER = LoggerFactory.getLogger(HystrixHelloFilter.class);
    private final static Random RANDOM = new Random(100);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        HystrixRequestVariables.setRequestVariable("traceID-" + RANDOM.nextInt());
        StringBuilder requestURL = new StringBuilder();
        try {
            if (request instanceof HttpServletRequest) {
                HttpServletRequest httpServletRequest = (HttpServletRequest) request;
                String uri = httpServletRequest.getRequestURI();
                String queryString = httpServletRequest.getQueryString();
                String method = httpServletRequest.getMethod();
                requestURL.append(method).append(" ").append(uri);
                if (queryString != null) {
                    requestURL.append("?").append(queryString);
                }
            }
            chain.doFilter(request, response);
        } finally {
            try {
                if (HystrixRequestContext.isCurrentThreadInitialized()) {
                    HystrixRequestLog log = HystrixRequestLog.getCurrentRequest();
                    LOGGER.info("requestURL is : {}, command is : {}", requestURL.toString(), log.getExecutedCommandsAsString());
                }
            } catch (Exception e) {
                LOGGER.error("Unable to append HystrixRequestLog, Exception is : {}", e.getMessage());
            }
        }
    }

    @Override
    public void destroy() {

    }
}
