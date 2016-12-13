package com.example.actor;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 * Created by chenhao on 2016/12/9.
 */
public class Listener  extends UntypedActor{

    public static Props props(ActorRef receiver){
        return Props.create(Listener.class,receiver);
    }

    ActorRef receiver;
    public Listener(ActorRef receiver){
        this.receiver = receiver;
    }
    LoggingAdapter log = Logging.getLogger(getContext().system(), this);
    {
        for (Object obj:new Object[]{1,2,3,"haozi",4,"yanzi"}) {
            getSelf().tell(obj,getSelf());
        }
    }
    @Override
    public void onReceive(Object message) throws Throwable {
        log.info(message.toString());
        receiver.tell(message,self());
        context().system().eventStream().publish(message);

    }
}
