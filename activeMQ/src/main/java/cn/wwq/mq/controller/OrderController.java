package cn.wwq.mq.controller;

import cn.wwq.mq.producter.ProducerService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;

@RestController
@RequestMapping("/mq")
public class OrderController {
 
 
    @Autowired  //注入消息生产者
    private ProducerService service;
    /**
     * 微信支付回调接口
     */
    @GetMapping("order")
    public Object order(String msg){
 
        //目的地:生成消息队列地址
        Destination destination =new ActiveMQQueue("order.queue");
        //调用方法
        service.sendMessage(destination,msg);
        return "发送成功";
    }
 
    @GetMapping("comm")
    public Object comm(String msg) {
        //调用方法
        service.sendMessage(msg);
        return "发送成功";
    }
 
}