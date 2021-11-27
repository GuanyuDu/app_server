package com.guanyu.app.aop;

import com.guanyu.app.constant.ErrorCode;
import com.guanyu.app.model.dto.base.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @author Guanyu
 */
@Aspect
@Component
public class SignAspect {

    @Pointcut("@annotation(com.guanyu.app.aop.annotation.CheckSign)")
    private void checkSign() {

    }

    @Around("checkSign()")
    public Object joinPoint(ProceedingJoinPoint joinPoint) {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String[] parameterNames = signature.getParameterNames();
        Object[] args = joinPoint.getArgs();

        try {
            return joinPoint.proceed();

        } catch (Throwable t) {
            t.printStackTrace();
        }
        return Result.fail(ErrorCode.UNKNOWN_ERROR);
    }

}
