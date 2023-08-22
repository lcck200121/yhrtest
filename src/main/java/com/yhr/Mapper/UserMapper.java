package com.yhr.Mapper;

import com.yhr.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    User userLogin(String user_name,String user_pwd);
    Integer addUser(User user);
    Integer UpdateUser(User user);
    User findUserById(int userId);

    User findUserByName(String userName);
}
