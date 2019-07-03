package com.jd.consumer.controller;

import com.jd.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/user")
    public User hello7() {
        List<ServiceInstance> list = discoveryClient.getInstances("provider");
        ServiceInstance instance = list.get(0);
        String host = instance.getHost();
        int port = instance.getPort();
        String url = "http://" + host + ":" + port + "/user";
        User u1 = new User();
        u1.setUsername("牧码小子");
        u1.setAddress("深圳");
        ResponseEntity<User> responseEntity = restTemplate.postForEntity(url, u1, User.class);
        return responseEntity.getBody();
    }

    @GetMapping("/login")
    public String hello8() {
        List<ServiceInstance> list = discoveryClient.getInstances("provider");
        ServiceInstance instance = list.get(0);
        String host = instance.getHost();
        int port = instance.getPort();
        String url = "http://" + host + ":" + port + "/register";
        MultiValueMap map = new LinkedMultiValueMap();
        map.add("username", "牧码小子");
        map.add("address", "深圳");
        URI uri = restTemplate.postForLocation(url, map);
        String s = restTemplate.getForObject(uri, String.class);
        return s;
    }

    @GetMapping("/update")
    public void hello9() {
        List<ServiceInstance> list = discoveryClient.getInstances("provider");
        ServiceInstance instance = list.get(0);
        String host = instance.getHost();
        int port = instance.getPort();
        String url1 = "http://" + host + ":" + port + "/user/name";
        String url2 = "http://" + host + ":" + port + "/user/address";
        MultiValueMap map = new LinkedMultiValueMap();
        map.add("username", "牧码小子");
        map.add("address", "深圳");
        restTemplate.put(url1, map);
        User u1 = new User();
        u1.setAddress("广州");
        u1.setUsername("江南一点雨");
        restTemplate.put(url2, u1);
    }

    @GetMapping("/delete")
    public void hello10() {
        List<ServiceInstance> list = discoveryClient.getInstances("provider");
        ServiceInstance instance = list.get(0);
        String host = instance.getHost();
        int port = instance.getPort();
        String url1 = "http://" + host + ":" + port + "/user/{1}";
        String url2 = "http://" + host + ":" + port + "/user/?username={username}";
        Map<String,String> map = new HashMap<>();
        map.put("username", "牧码小子");
        restTemplate.delete(url1, 99);
        restTemplate.delete(url2, map);
    }
}
