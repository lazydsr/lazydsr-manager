package com.lazydsr.manager.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * ControllerAspect
 * PROJECT_NAME: lazydsr-manager
 * PACKAGE_NAME: com.lazydsr.manager.aspect
 * Created by Lazy on 2018/1/21 15:53
 * Version: 0.1
 * Info: @TODO:...
 */
@Aspect
@Component
public class ControllerAspect {
    @Around("execution(* com.lazydsr.manager.controller.*.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {

        Long start = new Date().getTime();
        String methodName = pjp.getSignature().getName();
        Object obj = pjp.proceed();
        Long end = new Date().getTime();
        System.out.println("耗时记录：" + methodName + " 耗时  " + (end - start));
        return obj;
    }
}
