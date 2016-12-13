package com.example.config;

import akka.actor.ActorSystem;
import akka.dispatch.PriorityGenerator;
import akka.dispatch.UnboundedStablePriorityMailbox;
import com.typesafe.config.Config;

/**
 * Created by chenhao on 2016/12/9.
 */
public class MyPrioMailbox extends UnboundedStablePriorityMailbox {

    public MyPrioMailbox(ActorSystem.Settings settings, Config config) {
        super(new PriorityGenerator() {
            @Override
            public int gen(Object message) {
                if (message instanceof String)
                    return 10;
                else
                    return 20;
            }
        });
    }
}