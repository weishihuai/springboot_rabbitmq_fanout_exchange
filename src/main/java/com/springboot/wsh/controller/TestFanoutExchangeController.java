package com.springboot.wsh.controller;

import com.springboot.wsh.sender.TestSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Title: TestFanoutExchangeConstroller
 * @ProjectName springboot_rabbitmq_fanout_exchange
 * @Description: 测试Controller
 * @Author WeiShiHuai
 * @Date 2018/9/23 21:25
 */
@RestController
public class TestFanoutExchangeController {


    @Autowired
    private TestSender testSender;

    @GetMapping("/testFanoutExchange")
    public String testFanoutExchange() {
        //测试消息发送
        String message = UUID.randomUUID().toString();
        testSender.sendMessage(message);
        return "success";
    }

}
