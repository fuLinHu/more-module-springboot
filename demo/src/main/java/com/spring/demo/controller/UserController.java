package com.spring.demo.controller;

import com.spring.demo.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("/user")
    public String getInfo(User user){
        System.out.println("user is info");
        return "user is info";
    }

}
