package com.freeland.controller;

import akka.actor.ActorRef;
import akka.pattern.Patterns;
import akka.util.Timeout;

import com.freeland.actor.user.UserInterface;
import com.freeland.domain.json.user.Error;
import com.freeland.domain.json.user.LoginResult;
import com.freeland.domain.json.user.LogoutResult;
import com.freeland.model.user.Haozi;
import com.freeland.repository.HaoziRepository;
import com.freeland.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

/**
 * Created by chenhao on 2016/9/13.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private HaoziRepository haoziRepository;

    @Autowired
    @Qualifier("userWatcher")
    private ActorRef userActor;


    private static final Timeout TIME_OUT = new Timeout(Duration.create(1, "minute"));


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public LoginResult doLogin(@RequestParam(name = "username") String username,
                               @RequestParam(name = "password") String password,
                               HttpSession session) throws Exception {
        logger.info("username : {} , password : {}", username, password);
        Future<Object> future = Patterns.ask(userActor, new UserInterface.Login(username.trim(), password.trim(), session), TIME_OUT);
        Object result = Await.result(future, TIME_OUT.duration());
        logger.info("result :" + result);
        if (result instanceof LoginResult) {
            return (LoginResult) result;
        } else {
            return new LoginResult("400", "login failed", 0);
        }
    }

    @RequestMapping("/test")
    @ResponseBody
    public List<Object> dotest(@RequestParam(name = "device_id") String deviceId){
        Haozi haozi = haoziRepository.findByDeviceId(deviceId);
        Haozi haozi1 = haoziRepository.findOne(deviceId);
        List<Object> list = new ArrayList<>();
        list.add(haozi);
        list.add(haozi1);
        return list;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseBody
    public LogoutResult doLogOut(HttpSession session) throws Exception {
        //TODO
        logger.info("accept logout command");
        Future<Object> future = Patterns.ask(userActor, new UserInterface.LogOut(session), TIME_OUT);
        Object result = Await.result(future, TIME_OUT.duration());
        if (result instanceof LogoutResult) {
            return (LogoutResult) result;
        }
        return LogoutResult.builder().code("400").message("logout failed").build();
    }

    @RequestMapping(value = "/online",method = RequestMethod.GET)
    public Map<Integer,Date> online(@RequestParam(value = "start",required = true) String start,
                                    @RequestParam(value = "end",required = true) String end,
                                    @RequestParam(value = "province",required = false) String province,
                                    @RequestParam(value = "city",required = false) String city){

        Map<Integer,Date> dateMap = new HashMap<>();
        dateMap.put(1,new Date());
        return dateMap;
    }



    @ExceptionHandler(value = IOException.class)
    public ResponseEntity<Error> handleIOException(IOException ex) {
        logger.debug(ex.getMessage());
        Error error = new Error();
        error.setCode(500);
        error.setField("");
        error.setMessage(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
