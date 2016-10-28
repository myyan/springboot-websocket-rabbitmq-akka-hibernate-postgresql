package com.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by chenhao on 2016/9/20.
 */
@Aspect
@Component
public class LogoutAspect {

    private final Logger logger = LoggerFactory.getLogger(LogoutAspect.class);

    @Pointcut("execution(* com.example.controller.UserController.doLogOut(..))")
    public void logOut(){

    }

//    @Before("logOut()")
//    public void beforeLogOut(){
//        logger.info("before log out");
//    }
//
//    @After("logOut()")
//    public void afterLogOut(){
//        logger.info("after log out");
//    }

    @Around("logOut()")
    public void aoundLogOut(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("before logout");
        joinPoint.proceed();
        logger.info("after logout");
    }


}
