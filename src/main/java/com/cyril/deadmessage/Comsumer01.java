package com.cyril.deadmessage;

import com.cyril.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;

/**
 * @author jiaxiao.
 * @date 2022/1/14.
 * @time 0:23
 */
public class Comsumer01 {
    //普通交换机名称
    private static final String NORMAL_EXCHANGE = "normal_exchange";
    //死信交换机名称
    private static final String DEAD_EXCHANGE = "dead_exchange";

    public static void main(String[] args) {
        Channel channel = RabbitMqUtils.getChannel();
    }
}
