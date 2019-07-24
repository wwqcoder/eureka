package com.jd.privider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class Resilience4JController {

    @GetMapping("/res/{name}")
    public String hello(@PathVariable("name") String name){

        StringBuilder sb = new StringBuilder();
        String str = "hello" + name + ".....";
        sb.append(str);
        String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        sb.append("-----");
        sb.append(dateStr);
        return sb.toString();
    }

    @GetMapping("/hello123")
    public String hello2(String name) {
        String s = "hello " + name + " !";
        System.out.println(s+">>>>>"+new Date());
        int i = 1 / 0;
        return s;
    }
}
