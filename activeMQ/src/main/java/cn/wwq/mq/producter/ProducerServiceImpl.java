package cn.wwq.mq.producter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.Queue;

/**
 * 实现消息信息类
 */
@Service
public class ProducerServiceImpl  implements ProducerService {
//    用来发送消息到broker的对象
    @Autowired
    private JmsMessagingTemplate jmsTemplate;
 
 
    //注入指定消息队列  (在启动类中有注入哦！)
    @Autowired
    private Queue queue;
 
 
    public void sendMessage(Destination destination, String msg) {
       // System.out.println("jmsTemplate="+jmsTemplate+"\t"+destination+"\t"+msg);
        jmsTemplate.convertAndSend(destination, msg);
        System.out.println("发送信息指定目标："+msg);
    }
 
    public void sendMessage(String msg) {
        jmsTemplate.convertAndSend(this.queue,msg);   //指定消息队列哦！！！
        System.out.println("发送信息默认目标："+msg);
    }
}