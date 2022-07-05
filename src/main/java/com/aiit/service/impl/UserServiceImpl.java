package com.aiit.service.impl;

import com.aiit.entity.User;
import com.aiit.mapper.UserMapper;
import com.aiit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    public String SelectUser(String userId){
        List<User> users = userMapper.SelectUser(userId);
        User user = users.get(0);
        return user.getUserName();
    }
}
