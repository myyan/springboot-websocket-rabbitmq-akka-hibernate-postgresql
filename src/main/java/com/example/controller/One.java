package com.example.controller;

import com.example.model.user.KeyBoard;
import com.example.model.user.Mouse;
import com.example.repository.KeyBoardRepository;
import com.example.repository.MouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by chenhao on 2016/10/21.
 */
@Controller
public class One {

    @Autowired
    private KeyBoardRepository keyBoardRepository;

    @Autowired
    private MouseRepository mouseRepository;

    @RequestMapping("/keyboard/getting")
    @ResponseBody
    private KeyBoard gettingKeyBoard(){
        return keyBoardRepository.findOne(1l);
    }

    @RequestMapping("/mouse/getting")
    @ResponseBody
    private Mouse gettingMouse(){
        return mouseRepository.findOne(1l);
    }
}
