package com.ltq.demo.controller;


import com.ltq.demo.entity.User;
import com.ltq.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findUser")
    public List<User> findUserList(){
        return userService.getUserList();
    }
}
