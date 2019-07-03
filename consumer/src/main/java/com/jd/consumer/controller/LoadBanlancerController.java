package com.jd.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("loadBalancer")
public class LoadBanlancerController {

    @Autowired
    @Qualifier("loadBalancer")
    RestTemplate loadBalancer;

    @GetMapping("hello/{name}")
    public String load(@PathVariable("name") String name){
        return loadBalancer.getForObject("http://provider/hello?name={1}",String.class,name);
    }
}
