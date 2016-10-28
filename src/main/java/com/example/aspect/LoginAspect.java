package com.example.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by chenhao on 2016/9/20.
 */
@Aspect
@Component
public class LoginAspect {
    private Logger logger = LoggerFactory.getLogger(LoginAspect.class);


    @Pointcut("execution(* com.example.actor.user.UserWatchActor.onReceive(..))")
    public void user(){

    }

    @Before("user()")
    public void beforeLogin(){
        logger.info("before login");
    }

    @After("user()")
    public void afterLogin(){
        logger.info("after login");
    }


}
