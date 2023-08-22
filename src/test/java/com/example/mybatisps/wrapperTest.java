package com.example.mybatisps;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisps.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.mybatisps.mapper.userMapper;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
public class wrapperTest {

    @Autowired
    private userMapper userMapper2;
    @Test
    void test1(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.isNotNull("power");    //字段不为空
        userMapper2.selectList(wrapper).forEach(System.out::println);
    }

    @Test
    void test2(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name","yhr");   //字段=yhr
        User user = userMapper2.selectOne(wrapper);
        System.out.println(user);
    }

    @Test
    void test3(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(date));
        System.out.println(date);
    }
}
