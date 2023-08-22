package com.yhr.Service;

import com.yhr.Mapper.UserMapper;
import com.yhr.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public Integer addUser(User user){
        return userMapper.addUser(user);
    }

    public Integer UpdateUser(User user){
        return userMapper.UpdateUser(user);
    }
    public User findUserById(int userId){
        return userMapper.findUserById(userId);
    }
    public User findUserByName(String userName){
        return userMapper.findUserByName(userName);
    }
}
