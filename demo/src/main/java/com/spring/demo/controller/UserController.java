package com.spring.demo.controller;

import com.spring.core.properties.SecurityProperties1;
import com.spring.demo.entity.User;
import com.spring.demo.propert.SecurityProperties;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private SecurityProperties securityProperties;
    @Autowired
    private SecurityProperties1 SecurityProperties;

    @RequestMapping("/user")
    @ApiOperation("查询用户信息")
    public String getInfo(User user){
        System.out.println("user is info");
        return "user is infowww";
    }

    @RequestMapping("/user/{id}")
    @ApiOperation("查询用户信息id")
    public String getUserById(@ApiParam("用户主键") @PathVariable("id")String  id){
        System.out.println("user is info：："+id);
        return "user is info"+id;
    }

    @RequestMapping("/user/test")
    public String getUser(){
        String loginPage = securityProperties.getBrowser().getSignUpUrl();
        String signUpUrl = SecurityProperties.getBrowser().getSignUpUrl();
        System.out.println("user is info：："+loginPage+"lll"+signUpUrl);
        return "user is info"+loginPage+" pppp "+signUpUrl;
    }



}
