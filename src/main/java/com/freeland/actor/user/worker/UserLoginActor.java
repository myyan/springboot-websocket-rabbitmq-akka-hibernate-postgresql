package com.freeland.actor.user.worker;

import akka.actor.UntypedActor;
import com.freeland.actor.user.UserInterface;
import com.freeland.domain.json.user.LoginResult;
import com.freeland.model.user.User;
import com.freeland.service.UserService;
import com.freeland.tool.SpringBeanUtil;


import javax.servlet.http.HttpSession;

/**
 * Created by chenhao on 2016/9/13.
 */

public class UserLoginActor extends UntypedActor {


    private UserService userService;

    @Override
    public void onReceive(Object message) throws Throwable {

        if (userService == null) {
            userService = (UserService) SpringBeanUtil.getBean("userService");
        }
        if (message instanceof UserInterface.Login) {
            UserInterface.Login msg = (UserInterface.Login) message;
            String username = msg.getUsername();
            String password = msg.getPassword();
            HttpSession session = msg.getSession();
            User user = userService.getUserByUsernameAndPassword(username, password);
            LoginResult result = new LoginResult();
            if (user == null) {
                result.setMessage("login failed");
                result.setCode("400");
                result.setAuthority(0);
                getSender().tell(result, getSelf());
            } else {
                result.setAuthority(user.getRoleId().getAuthority());
                result.setCode("200");
                result.setMessage("login success");
                session.setAttribute("userInfo",user);
                getSender().tell(result, getSelf());
            }

        } else {
            unhandled(message);
        }

    }
}
