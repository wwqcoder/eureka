package com.jd.consumer;

import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Service
@Retry(name = "retryBackendA")
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    public String hello(@PathVariable("name") String name) {
        return restTemplate.getForObject("http://provider/hello123?name={1}", String.class, name);
    }
}