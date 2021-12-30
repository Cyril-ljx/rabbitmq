package com.cyril.three;

import com.cyril.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.util.concurrent.TimeUnit;

/**
 * @author jiaxiao.
 * @date 2021/12/26.
 * @time 0:05
 */
public class Work04 {
    /**
     * 队列名称
     */
    public static final String TASK_ACK_NAME = "ack_queue";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();
        System.out.println("C2等待消息处理时间较长");

        TimeUnit.SECONDS.sleep(10);
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            System.out.println("接接收到的消息：" + new String(message.getBody(), "UTF-8"));
            //手动应答
            /**
             * 1.消息的标记 tag,即为一个key
             * 2.是否批量应答 false 不批量应答信道中的消息
             */
            channel.basicAck(message.getEnvelope().getDeliveryTag(), false);
        };
        boolean autoAck = false;
        channel.basicConsume(TASK_ACK_NAME, autoAck, deliverCallback, (consumerTag -> {
            System.out.println(consumerTag + "消费者取消消费接口回调逻辑");
        }));
    }
}
