package cn.wwq.mq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
 
/**
 *消费者
 */
@Component
public class OrderConsumer {
 
    //实时监听器监听order.queue这个消息队列
    @JmsListener(destination = "order.queue")
    public void receiveQueue(String text){
        System.out.println("OrderConsumer收到的消息为:"+text);
    }

    //实时监听器监听common.queue这个消息队列
    @JmsListener(destination = "common.queue")
    public void receiveQueue1(String text){
        System.out.println("OrderConsumer收到的消息为:"+text);
    }
}