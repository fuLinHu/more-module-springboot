package com.spring.demo.controller;

import com.spring.core.properties.SecurityProperties;
import com.spring.demo.entity.User;
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
        System.out.println("user is info：："+loginPage+"--lll--");
        return "user is info"+loginPage+" pppp ";
    }



}
