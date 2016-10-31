package com.freeland.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by chenhao on 2016/10/28.
 */
@Component
public class RedisReceiver {

    private static final Logger logger = LoggerFactory.getLogger(RedisReceiver.class);

    public void messageHandler(String message) {
        logger.info("Receiver> " + message);
    }


}
