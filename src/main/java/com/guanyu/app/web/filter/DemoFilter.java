package com.guanyu.app.web.filter;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * 过滤器
 *
 * @author Guanyu
 */
public class DemoFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // do something...
        chain.doFilter(request, response);
    }
}
