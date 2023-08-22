package com.yhr.Service;

import com.yhr.Mapper.testMapper;
import com.yhr.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class testService {
    @Autowired
    private testMapper testMapper1;
    public String test01(User user){
        if(user.getUser_pwd().equals(null)){
            return "0";
        }
        if (user.getUser_name().equals(null)){
            return "2";
        }
        return "1";
    }

}
