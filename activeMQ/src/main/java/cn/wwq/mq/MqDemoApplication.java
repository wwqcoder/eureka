package cn.wwq.mq;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import javax.jms.Queue;
 
@SpringBootApplication
@EnableJms  //启用JMS
public class MqDemoApplication {
 
    @Bean  //交给spring来管理，注入哦!
    public Queue queue(){
        return new ActiveMQQueue("common.queue");
    }
    public static void main(String[] args) {
        SpringApplication.run(MqDemoApplication.class, args);
    }
 
}