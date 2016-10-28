package com.freeland.config.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.typesafe.config.ConfigFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jiaoew on 16/8/16.
 */
@Configuration
public class AppConfiguration {

    // the application context is needed to initialize the Akka Spring Extension
    @Autowired
    private ApplicationContext applicationContext;

    /**
     * Actor system singleton for this application.
     */
    @Bean
    public ActorSystem actorSystem() {
        ActorSystem system = ActorSystem.create("device_manage", ConfigFactory.load());
        // initialize the application context in the Akka Spring Extension
        SpringExtension.SpringExtProvider.get(system).initialize(applicationContext);
        return system;
    }


    @Bean(name = "userWatcher")
    public ActorRef userWatcher() {
        return actorSystem().actorOf(SpringExtension.SpringExtProvider.get(actorSystem()).props("userWatchActor"), "userWatcher");
    }




}

