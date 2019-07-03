package com.jd.privider.controller;

import com.jd.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@ResponseBody
public class UserController {
    @PostMapping("/user")
    public User hello(@RequestBody User user) {
        return user;
    }

    @RequestMapping("/register")
    public String register(User user, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setHeader("Location","http://localhost:4001/loginPage?username=" + URLEncoder.encode(user.getUsername(),"UTF-8") + "&address=" + URLEncoder.encode(user.getAddress(),"UTF-8"));
        return "redirect:/loginPage?username=" + URLEncoder.encode(user.getUsername(),"UTF-8") + "&address=" + URLEncoder.encode(user.getAddress(),"UTF-8");
    }

    @GetMapping("/loginPage")
    @ResponseBody
    public String loginPage(User user) {
        return "loginPage:" + user.getUsername() + ":" + user.getAddress();
    }

    @PutMapping("/user/name")
    @ResponseBody
    public void updateUserByUsername(User User) {
        System.out.println(User);
    }
    @PutMapping("/user/address")
    @ResponseBody
    public void updateUserByAddress(@RequestBody User User) {
        System.out.println(User);
    }

    @DeleteMapping("/user/{id}")
    @ResponseBody
    public void deleteUserById(@PathVariable Integer id) {
        System.out.println(id);
    }
    @DeleteMapping("/user/")
    @ResponseBody
    public void deleteUserByUsername(String username) {
        System.out.println(username);
    }
}