package cn.wwq.feign_consumer.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("provider")
public interface HelloService {

    @GetMapping("/hello")
    String hello(@RequestParam("name") String name);

    @PostMapping("/hello2/{name}")
    String hello2(@PathVariable("name") String name);
}
