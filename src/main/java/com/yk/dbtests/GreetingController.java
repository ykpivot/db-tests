package com.yk.dbtests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/hello")
    public String hello() {
        String name = redisTemplate.hasKey("hello").toString();
        return String.join(" ",  name, "World!");
    }

}