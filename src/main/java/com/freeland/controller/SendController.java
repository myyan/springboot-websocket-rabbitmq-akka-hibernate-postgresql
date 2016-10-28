package com.freeland.controller;

import com.freeland.domain.json.RawMessage;
import com.freeland.domain.json.Result;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by chenhao on 2016/10/28.
 */
@Controller
public class SendController {


    @Value("${rabbitmq.routing_key.send}")
    public String sendRoutingKey;

    @Value("${rabbitmq.exchange}")
    public String exchangeName;

    @Autowired
    private RabbitTemplate template;

    @RequestMapping("/send")
    @ResponseBody
    public Result result() {
        RawMessage message = new RawMessage();
        message.setName("test");
        message.setAge(11);
        template.convertAndSend(exchangeName, sendRoutingKey, message);
        return Result.builder().message("success").code(200).build();
    }
}
