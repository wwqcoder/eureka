package com.jd.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface HelloService {
    @GetMapping("/hello")
    public String hello(@RequestParam("name") String name);


    @PostMapping("/hello2/{name}")
    public String hello2(@PathVariable("name") String name);
}
