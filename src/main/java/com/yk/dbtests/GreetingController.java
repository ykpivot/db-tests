package com.yk.dbtests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/hello")
    public String hello() {
        String name = (String) redisTemplate.opsForValue().get("name");
        return String.join(" ",  name, "World!");
    }

    @GetMapping("/name/{name}")
    public String name(@PathVariable String name) {
        ValueOperations<String, String> values = redisTemplate.opsForValue();
        values.set("name", name);
        return String.join(" ", "Saved: ", name);
    }

}