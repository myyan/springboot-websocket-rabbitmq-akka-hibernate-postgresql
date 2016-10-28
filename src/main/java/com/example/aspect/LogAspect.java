package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by chenhao on 2016/9/20.
 */
@Aspect
@Component
public class LogAspect {

    Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(* com.example.service..*.*(..))")
    public void servicePointcut(){

    }

    @Before("servicePointcut()")
    public void beforeService(JoinPoint joinPoint){
        logger.info("service start : {} {}", joinPoint.getTarget().getClass(), joinPoint.getSignature().getName());
        logger.info("arg(s) : {}", Arrays.asList(joinPoint.getArgs()));
    }

    @After("servicePointcut()")
    public void afterService(JoinPoint joinPoint) {
        logger.info("service end : {} {}", joinPoint.getTarget().getClass(), joinPoint.getSignature().getName());
    }
}
