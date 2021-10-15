package com.guanyu.app.aop;

import com.guanyu.app.constant.ErrorCode;
import com.guanyu.app.model.dto.base.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 请求监控日志
 * @author v.duguanyu
 */
@Aspect
@Component
public class CtlMonitoringAspect {

    private final Logger logger = LoggerFactory.getLogger(CtlMonitoringAspect.class);

    @Pointcut("execution(public * com.guanyu.app.controller.*.*(..))")
    private void monitoringMethod() {}

    @Around("monitoringMethod()")
    public Object writeLog(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            Object proceed = joinPoint.proceed(joinPoint.getArgs());
            Result<?> result = (Result<?>) proceed;
            String name = joinPoint.getSignature().getName();
            if (result.getCode() != 0) {
                logger.error("CtlMonitoringAspect | Call {} error! code: {}, message: {}",
                        name, result.getCode(), result.getMessage());
            }
            return proceed;
        } catch (Exception e) {
            logger.error("CtlMonitoringAspect | oops meeting a error!", e);
            return Result.fail(ErrorCode.UNKNOWN_ERROR);
        }
    }
}
