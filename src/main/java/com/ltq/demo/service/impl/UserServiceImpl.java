package com.ltq.demo.service.impl;

import com.ltq.demo.dao.UserMapper;
import com.ltq.demo.entity.User;
import com.ltq.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserList() {
        return userMapper.selectList();
    }
}
