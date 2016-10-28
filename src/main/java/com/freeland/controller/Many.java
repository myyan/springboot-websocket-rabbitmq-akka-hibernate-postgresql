package com.freeland.controller;

import com.freeland.model.user.App;
import com.freeland.model.user.Device;
import com.freeland.repository.AppRepository;
import com.freeland.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by chenhao on 2016/10/21.
 */
@Controller
public class Many {

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private AppRepository appRepository;

    @RequestMapping("/device/getting")
    @ResponseBody
    public Device getDevice() {
        return deviceRepository.findOne(1l);
    }

    @RequestMapping("/app/getting")
    @ResponseBody
    public App getApp() {
        return appRepository.findOne(1l);
    }
}
