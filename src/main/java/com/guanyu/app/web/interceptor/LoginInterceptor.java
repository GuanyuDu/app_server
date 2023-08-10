package com.guanyu.app.web.interceptor;

import com.github.benmanes.caffeine.cache.Cache;
import com.guanyu.app.util.UserContext;
import com.guanyu.app.util.log.Logs;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

/**
 * 登录逻辑处理拦截器
 *
 * @author Guanyu
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Resource
    private Cache<String, String> userCache;

    @PostConstruct
    private void init() {
        ApplicationContext context = new AnnotationConfigApplicationContext();
        String[] profiles = context.getEnvironment().getActiveProfiles();
        Logs.detail.info("profiles is " + Arrays.toString(profiles));
    }

    @Override
    public boolean preHandle(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) {
        // 获取用户 token
        String token = request.getHeader("token");
        // dev 环境下不校验用户 token 信息
//        if ("dev".equals(env) && StringUtils.isBlank(token)) {
//            return true;
//        }
        // 初始化用户信息
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
        // 销毁用户信息
        UserContext.destroy();
    }
}
