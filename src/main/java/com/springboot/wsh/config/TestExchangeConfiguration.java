package com.springboot.wsh.config;

import com.springboot.wsh.constants.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Title: TestExchangeConfiguration
 * @ProjectName springboot_rabbitmq_fanout_exchange
 * @Description: RabbitMQ Fanout Exchange配置类
 * @Author WeiShiHuai
 * @Date 2018/9/23 21:34
 * <p>
 * 说明:
 * 1. fanout路由又称为广播路由，会将收到的消息广播到消息对列上。当使用fanout交换器时，它会将消息广播到与该交换器绑定的所有队列上，有利于对单条消息做不同的反应。
 * 2. fanout路由无需指定route key,即使指定了也会被忽略，只要队列与交换机绑定，那么发送到交换机上的消息就会被分发到消息接收者上。
 */
@Configuration
public class TestExchangeConfiguration {

    private static Logger logger = LoggerFactory.getLogger(TestExchangeConfiguration.class);

    /**
     * 创建广播形式的交换机
     *
     * @return 交换机实例
     */
    @Bean
    public FanoutExchange fanoutExchange() {
        logger.info("【【【交换机实例创建成功】】】");
        return new FanoutExchange(Constants.FANOUT_EXCHANGE_NAME);
    }

    /**
     * 测试队列一
     *
     * @return 队列实例
     */
    @Bean
    public Queue queue1() {
        logger.info("【【【测试队列一实例创建成功】】】");
        return new Queue(Constants.TEST_QUEUE1_NAME);
    }

    /**
     * 测试队列二
     *
     * @return 队列实例
     */
    @Bean
    public Queue queue2() {
        logger.info("【【【测试队列二实例创建成功】】】");
        return new Queue(Constants.TEST_QUEUE2_NAME);
    }

    /**
     * 绑定队列一到交换机
     *
     * @return 绑定对象
     */
    @Bean
    public Binding bingQueue1ToExchange() {
        logger.info("【【【绑定队列一到交换机成功】】】");
        return BindingBuilder.bind(queue1()).to(fanoutExchange());
    }

    /**
     * 绑定队列二到交换机
     *
     * @return 绑定对象
     */
    @Bean
    public Binding bingQueue2ToExchange() {
        logger.info("【【【绑定队列二到交换机成功】】】");
        return BindingBuilder.bind(queue2()).to(fanoutExchange());
    }

}
