package cn.wwq.feign_consumer.service;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("provider")
public interface HelloService extends com.jd.service.HelloService {
}
