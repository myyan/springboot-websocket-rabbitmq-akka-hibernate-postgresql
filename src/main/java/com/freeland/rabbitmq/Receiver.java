package com.freeland.rabbitmq;


import com.freeland.domain.json.RawMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by chenhao on 2016/10/28.
 */

@Component
public class Receiver implements MessageListener {

    Logger logger = LoggerFactory.getLogger(Receiver.class);

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void onMessage(Message message) {
        try {
            RawMessage rawMessage = mapper.readValue(message.getBody(), RawMessage.class);
            logger.info("raw message:{}",rawMessage.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}