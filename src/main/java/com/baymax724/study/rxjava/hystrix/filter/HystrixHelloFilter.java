package com.baymax724.study.rxjava.hystrix.filter;

import com.netflix.hystrix.HystrixRequestLog;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by sunao on 2016/12/6.
 */
public class HystrixHelloFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
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
                    System.out.println(requestURL.toString() + " " + log.getExecutedCommandsAsString());
                }
            } catch (Exception e) {
                System.out.println("Unable to append HystrixRequestLog");
            }
        }
    }

    @Override
    public void destroy() {

    }
}
