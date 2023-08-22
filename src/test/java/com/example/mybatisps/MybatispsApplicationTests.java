package com.example.mybatisps;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisps.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.mybatisps.mapper.userMapper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;



@SpringBootTest
class MybatispsApplicationTests {

    @Autowired
    private userMapper userMapper;
    @Test
    void contextLoads() {
        List list = userMapper.selectList(null);
        list.forEach(System.out::println);
    }

    @Test
    void test(){
        User user = new User();
        user.setUserName("花姑娘某");
        user.setUserPwd("1234567");
        userMapper.insert(user);
    }

    @Test
    void test2(){
        User user = new User();
        user.setUserId(114);
        user.setUserName("杨洪瑞");
        user.setUserPwd("1234567");
        userMapper.updateById(user);
    }

    @Test
//    乐观锁成功
    void  test3(){
        User user = userMapper.selectById(114);
        user.setUserName("杨洪瑞222");
        user.setUserPwd("16666667");
        userMapper.updateById(user);
    }

//    失败的
    @Test
    void  test4(){
//        线程1
        User user = userMapper.selectById(114);
        user.setUserName("杨洪瑞222");
        user.setUserPwd("16666667");
        //模拟！！2线程先执行
        User user2 = userMapper.selectById(114);
        user2.setUserName("杨洪瑞3333333333333");
        user2.setUserPwd("16666667");
        userMapper.updateById(user2);//线程2先更新了

        userMapper.updateById(user);//没有乐观锁会覆盖插队线程的值
}
@Test
    void test5(){
        //查询多个用户
//    List<User> users = userMapper.selectBatchIds(Arrays.asList(114, 115));
    userMapper.selectList(null).forEach(System.out::println);
//    users.forEach(System.out::println);
}


@Test
    void test6(){
        //条件查询 map
    HashMap<String, Object> map = new HashMap<>();
    map.put("user_name", "花姑娘某");//map里面放查询的条件
    map.put("user_pwd", "1234567");//map里面放查询的条件
    userMapper.selectByMap(map);
}
@Test
    void test7(){
//        参数1：当前页  参数2：页面大小
    Page<User> page = new Page<>(2,5);
    userMapper.selectPage(page, null);
    page.getRecords().forEach(System.out::println);
}

@Test
    void test8(){
        userMapper.deleteById("102");//通过id删除
//        userMapper.deleteBatchIds(Arrays.asList(114, 115));//通过id批量删除
//    HashMap<String, Object> map = new HashMap<>();
//    map.put("user_name", "花姑娘某");//map里面放查询的条件
//    map.put("user_pwd", "1234567");//map里面放查询的条件
//    userMapper.deleteByMap(map);//根据map删除

    }

    @Test
    void test9(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name","yhr");
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }
}
