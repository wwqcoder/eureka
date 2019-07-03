package com.jd.money.controller;

import com.jd.money.config.LimitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("config")
public class ConfigController {

   /* @Value("${limit.minMoney}")
    private BigDecimal minMoney;
    @Value("${limit.description}")
    private String description;*/

    @Autowired
    LimitConfig limitConfig;

    @GetMapping("getValue")
    public String print(){
        return "结果为："+ limitConfig.getDescription();
    }



}
