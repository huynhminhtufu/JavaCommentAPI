package com.mrhmt.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class APIsController {
    @RequestMapping("/")
    public String index() {
        return "Java Spring Boot Server Started!";
    }

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "Hello " + name + ", have a nice day!";
    }

    @RequestMapping("/say-hi")
    public String sayHi(@RequestBody Map<String, String> body) {
        String id = body.get("id");
        String name = body.get("name");
        String email = body.get("email");

        return "You are = " + id + " -- " + name + " -- " + email;
    }
}
