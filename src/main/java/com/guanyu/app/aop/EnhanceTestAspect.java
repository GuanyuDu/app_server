package com.guanyu.app.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author v.duguanyu
 */
@Aspect
@Component
public class EnhanceTestAspect {

    @Pointcut("execution(public * com.guanyu.app.utils.TestRunner.testFunction(..))")
    public void testRunner() {}

    @Around("testRunner()")
    public Object handleTest(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("[Attention] before advice output");
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println("[Param] " + arg);
        }
        Object proceed = joinPoint.proceed(args);
        System.out.println(proceed.toString());
        return proceed;
    }
}
