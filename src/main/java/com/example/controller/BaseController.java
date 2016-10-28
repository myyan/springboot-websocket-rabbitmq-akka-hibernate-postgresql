package com.example.controller;

import akka.actor.ActorRef;
import akka.pattern.Patterns;
import akka.util.Timeout;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

/**
 * Created by hanxiao on 2016/9/18.
 */
public abstract class BaseController {

    protected static final Timeout TIME_OUT = new Timeout(Duration.create(10, "seconds"));

    protected abstract ActorRef getActor();

    protected  <T,R> R request(T t) throws Exception {
        Future<Object> future = Patterns.ask(getActor(), t, TIME_OUT);
        Object result = Await.result(future, TIME_OUT.duration());
        if (result instanceof Exception)
            throw (Exception) result;
        return (R) result;
    }

}
