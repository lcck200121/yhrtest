package com.yhr.Controller;

import com.yhr.Service.testService;
import com.yhr.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

    @Autowired
    testService service;

    @RequestMapping("/test")//传的参数
    public void test01(@RequestParam("user_name")String user_name, @RequestParam("user_pwd")String user_pwd) {
        System.out.println(user_name);
        System.out.println(user_pwd);

    }

    @RequestMapping("/test01")
    public void test01(@RequestBody User user){//传JSON
        System.out.println(user.getUser_name());
        System.out.println(user.getUser_pwd());
        System.out.println(user);

    }
    @RequestMapping("/test02")//直接传的参数
    public User test02(User user){
        System.out.println(user);
        return user;
    }

}
