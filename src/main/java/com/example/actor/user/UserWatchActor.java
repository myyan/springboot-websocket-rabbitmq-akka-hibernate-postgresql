package com.example.actor.user;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

import com.example.actor.user.worker.UserLoginActor;
import com.example.actor.user.worker.UserLogoutActor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

import javax.inject.Named;

/**
 * Created by chenhao on 2016/9/14.
 */
@Named("userWatchActor")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserWatchActor extends UntypedActor {

    private ActorRef userLoginActor;

    private ActorRef userLogoutActor;

    public UserWatchActor() {
        userLoginActor = getContext().actorOf(Props.create(UserLoginActor.class), "userLogin");
        userLogoutActor = getContext().actorOf(Props.create(UserLogoutActor.class), "userLogout");
    }

    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof UserInterface.Login) {
            userLoginActor.forward(message, getContext());
        } else if (message instanceof UserInterface.LogOut) {
            userLogoutActor.forward(message, getContext());
        } else {
            unhandled(message);
        }
    }
}
