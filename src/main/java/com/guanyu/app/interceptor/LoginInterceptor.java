package com.guanyu.app.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录校验拦截器
 * @author v.duguanyu
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    private final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    private static final String PRIMARY_KEY = "4abef43d8ab28c737f2acfbf78efeb20";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String id = request.getParameter("id");
        System.out.printf("[Login Interceptor] preHandle %s%n", id);
        return true;
//        String clientKey = request.getHeader("primary-key");
//
//        if (StringUtils.isNotBlank(clientKey) && clientKey.equals(PRIMARY_KEY)) {
//            return true;
//        } else {
//            logger.info("LoginInterceptor -> proHandle | illegality request | clientKey: {}", clientKey);
//            String message = "{\"code\":%s, \"flag\":false, \"message\":\"%s\"}";
//
//            response.setCharacterEncoding("UTF-8");
//            response.setContentType("application/json; charset=UTF-8");
//            response.getWriter().write(String.format(message, ErrorCode.INVALID_REQUEST.code, ErrorCode.INVALID_REQUEST.msg));
//            return false;
//        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
