package cn.wwq.mq.producter;


import javax.jms.Destination;

/**
 * 消息生产
 */
public interface ProducerService {
    //指定消息队列，还有消息
    public void sendMessage(Destination destination, final String msg);
 
    //使用默认消息队列， 发送消息
    public void sendMessage(final String msg);
 
}