package com.example.mybatisps.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisps.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface userMapper extends BaseMapper<User> {
    //只需要在mapper里继承baseMapper接口即可。
}
