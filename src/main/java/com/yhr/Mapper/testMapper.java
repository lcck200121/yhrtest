package com.yhr.Mapper;

import com.yhr.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface testMapper {
    String test01(User user);
}
