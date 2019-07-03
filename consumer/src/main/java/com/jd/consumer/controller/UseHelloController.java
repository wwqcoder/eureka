package com.jd.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.List;
import java.util.Set;

@RestController
public class UseHelloController {

    @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    RestTemplate restTemplate;
    int count = 0;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name){

        List<ServiceInstance> instances = discoveryClient.getInstances("provider");
        ServiceInstance serviceInstance = instances.get(count % instances.size());
        count++;
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();

        String responseStr = restTemplate.getForObject("http://" + host + ":" + port + "/hello?name={1}", String.class, name);

        return responseStr;
    }

    /**
     * restTemplate详解
     * @param name
     * @return
     * @throws UnsupportedEncodingException
     */
    @GetMapping("/hello")
    public String helloOne(String name) throws Exception {
        List<ServiceInstance> list = discoveryClient.getInstances("provider");
        ServiceInstance instance = list.get(0);
        String host = instance.getHost();
        int port = instance.getPort();
        //第一种方式
        /*String url = "http://" + host + ":" + port + "/hello?name={1}";
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class, name);*/
        //第二种方式
        /*Map<String, Object> map = new HashMap<>();
        String url = "http://" + host + ":" + port + "/hello?name={name}";
        map.put("name", name);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class, map);*/
        //第三种方式
        String url = "http://" + host + ":" + port + "/hello?name="+ URLEncoder.encode(name,"UTF-8");
        URI uri = new URI(url);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
        StringBuffer sb = new StringBuffer();
        HttpStatus statusCode = responseEntity.getStatusCode();
        String body = responseEntity.getBody();
        sb.append("statusCode：")
                .append(statusCode)
                .append("</br>")
                .append("body：")
                .append(body)
                .append("</br>");
        HttpHeaders headers = responseEntity.getHeaders();
        Set<String> keySet = headers.keySet();
        for (String s : keySet) {
            sb.append(s)
                    .append(":")
                    .append(headers.get(s))
                    .append("</br>");
        }
        return sb.toString();
    }

    @GetMapping("/hello2")
    public String hello5(String name) {
        List<ServiceInstance> list = discoveryClient.getInstances("provider");
        ServiceInstance instance = list.get(0);
        String host = instance.getHost();
        int port = instance.getPort();
        String url = "http://" + host + ":" + port + "/hello2";
        MultiValueMap map = new LinkedMultiValueMap();
        map.add("name", name);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, map, String.class);
        return responseEntity.getBody();
    }


}

