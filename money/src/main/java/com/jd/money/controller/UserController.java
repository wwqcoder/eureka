package com.jd.money.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

//    @PostMapping("showUser")
    @GetMapping("showUser")
    public String showUser(Long id){
        return "id:" + id;
    }
}
