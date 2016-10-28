package com.freeland.actor.user.worker;

import akka.actor.UntypedActor;
import com.freeland.actor.user.UserInterface;
import com.freeland.domain.json.user.LogoutResult;
import com.freeland.service.UserService;
import com.freeland.tool.SpringBeanUtil;


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
