package com.jd.privider.controller;

import com.jd.service.HelloService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController implements HelloService {

    @Value("${server.port}")
    private Integer port;

    @Override
    @GetMapping("/hello")
    public String hello(String name){
        return "hello"+name+"!!!" + port;
    }

    @Override
    @PostMapping("/hello2/{name}")
    public String hello2(@PathVariable("name") String name){
        return "hello"+name+"!!!" + port;
    }
}
