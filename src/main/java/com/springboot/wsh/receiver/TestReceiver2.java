package com.springboot.wsh.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Title: TestReceiver2
 * @ProjectName springboot_rabbitmq_fanout_exchange
 * @Description: 消息接收者2
 * @Author WeiShiHuai
 * @Date 2018/9/23 21:55
 */

@Component
@RabbitListener(queues = "test.queue2.name")
public class TestReceiver2 {

    private static Logger logger = LoggerFactory.getLogger(TestReceiver2.class);

    @RabbitHandler
    public void receiveMessage(Object message) {
        logger.info("消息接收者接收到来自【队列二】的消息，消息内容: {}", message);
    }

}
