package cn.wwq.feign_consumer;

import feign.Logger;
import feign.Retryer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class FeignConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignConsumerApplication.class, args);
    }

    /**
     *日志配置
     * 1.NONE:不开启日志记录
     * 2.BASIC：记录请求方法，URL，响应的状态码，执行时间
     * 3.HEADERS:第2点基础上，加上请求头和响应头
     * 4.FULL:第2点基础上，加上body和元数据
     */
    @Bean
    Logger.Level loggerLevel() {
        return Logger.Level.FULL;
    }

    /**
     * 实现请求重试
     * @return
     */
    @Bean
    public Retryer feignRetryer() {
        Retryer.Default retryer = new Retryer.Default();
        return retryer;
    }

}
