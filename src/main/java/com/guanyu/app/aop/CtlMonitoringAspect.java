package com.guanyu.app.aop;

import com.guanyu.app.model.base.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 请求监控日志
 * @author v.duguanyu
 */
@Aspect
@Component
public class CtlMonitoringAspect {

    @Pointcut("execution(public * com.guanyu.app.controller.*.*(..))")
    private void monitoringMethod() {}

    @Around("monitoringMethod()")
    public Object writeLog(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceed = joinPoint.proceed(joinPoint.getArgs());
        Result result = (Result) proceed;
        String declaringTypeName = joinPoint.getSignature().getDeclaringTypeName();
        String name = joinPoint.getSignature().getName();
        System.out.println(name + "-" + declaringTypeName + "-" + result.getCode() + "-" + result.getMessage());
        return proceed;
    }
}
