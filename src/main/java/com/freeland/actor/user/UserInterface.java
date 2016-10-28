package com.freeland.actor.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.servlet.http.HttpSession;

/**
 * Created by chenhao on 2016/9/14.
 */
public interface UserInterface {
    @Data
    @AllArgsConstructor
    class Login{
        String username;
        String password;
        HttpSession session;
    }

    @Data
    @AllArgsConstructor
    class LogOut{
        HttpSession session;
    }
}
