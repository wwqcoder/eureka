package cn.wwq.feign_consumer.controller;

import cn.wwq.feign_consumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/hello")
    public String feign(String name) {
        return helloService.hello(name);
    }

    @PostMapping("/hello2/{name}")
    public String feignPost(@PathVariable("name") String name){
        return helloService.hello2(name);
    }
}
