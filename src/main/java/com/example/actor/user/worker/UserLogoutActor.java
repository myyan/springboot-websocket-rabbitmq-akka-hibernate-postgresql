package com.example.actor.user.worker;

import akka.actor.UntypedActor;
import com.example.actor.user.UserInterface;
import com.example.domain.json.user.LogoutResult;
import com.example.service.UserService;
import com.example.tool.SpringBeanUtil;


import javax.servlet.http.HttpSession;

/**
 * Created by chenhao on 2016/9/14.
 */

public class UserLogoutActor extends UntypedActor {

    private UserService userService;

    @Override
    public void onReceive(Object message) throws Throwable {

        if (userService == null) {
            userService = (UserService) SpringBeanUtil.getBean("userService");
        }

        if (message instanceof UserInterface.LogOut) {
            HttpSession session = ((UserInterface.LogOut) message).getSession();
            session.invalidate();
            LogoutResult result = new LogoutResult();
            result.setMessage("logout success");
            result.setCode("200");
            getSender().tell(result, getSelf());
        } else {
            unhandled(message);
        }
    }
}
