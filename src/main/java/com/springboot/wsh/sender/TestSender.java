package com.springboot.wsh.sender;

import com.springboot.wsh.constants.Constants;
import com.springboot.wsh.controller.TestFanoutExchangeController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Title: TestSender
 * @ProjectName springboot_rabbitmq_fanout_exchange
 * @Description: 消息发送者
 * @Author WeiShiHuai
 * @Date 2018/9/23 21:45
 */
@Component
public class TestSender {
    private static Logger logger = LoggerFactory.getLogger(TestFanoutExchangeController.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送消息
     *
     * @param message 消息内容
     * 说明: routingKey可以指定也可以不指定，这里我们给一个空字符串""
     */
    public void sendMessage(Object message) {
        logger.info("【消息发送者】发送消息到fanout交换机，消息内容为: {}", message);
        rabbitTemplate.convertAndSend(Constants.FANOUT_EXCHANGE_NAME, "", message);
    }

}
