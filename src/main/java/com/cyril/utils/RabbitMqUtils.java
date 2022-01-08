package com.cyril.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author jiaxiao.
 * @date 2021/12/23.
 * @time 0:25
 */
public class RabbitMqUtils {
    //得到一个连接的 channel
    public static Channel getChannel(){
        try {
        //创建一个连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("112.74.106.34");
        factory.setUsername("admin");
        factory.setPassword("admin");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        return channel;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    //关闭通道和关闭连接工具方法
    public static void closeConnectionAndChannel(Channel channel, Connection conn){
        try {
            if(channel !=null) {
                channel.close();
            }
            if(conn != null) {
                conn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
