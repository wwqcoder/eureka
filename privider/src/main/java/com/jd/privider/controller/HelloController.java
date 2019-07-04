package com.jd.privider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/hello")
    public String hello(String name){
        return "hello"+name+"!!!" + port;
    }

    @PostMapping("/hello2/{name}")
    public String hello2(@PathVariable("name") String name){
        return "hello"+name+"!!!" + port;
    }
}
