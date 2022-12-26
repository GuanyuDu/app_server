package com.guanyu.app.web.interceptor;

import com.github.benmanes.caffeine.cache.Cache;
import com.guanyu.app.util.UserContext;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录逻辑处理拦截器
 *
 * @author Guanyu
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Resource
    private Cache<String, String> userCache;

    @Override
    public boolean preHandle(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) {
        // 初始化用户信息
//        String token = request.getHeader("token");
//        UserContext.init(userCache.getIfPresent(token));
        return true;
    }

    @Override
    public void postHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response,
                           @NotNull Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response,
                                @NotNull Object handler, Exception ex) throws Exception {
        UserContext.destroy();
    }
}
