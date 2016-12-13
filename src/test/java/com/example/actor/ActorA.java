package com.example.actor;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 * Created by chenhao on 2016/12/9.
 */
public class ActorA extends UntypedActor{

    LoggingAdapter log = Logging.getLogger(getContext().system(),this);
    @Override
    public void preStart(){
        context().system().eventStream().subscribe(self(),String.class);
    }


    @Override
    public void postStop(){
        context().system().eventStream().unsubscribe(self());
    }
    @Override
    public void onReceive(Object message) throws Throwable {
        log.info("{} receive message :{} from {}",self(),message,sender());
    }
}
