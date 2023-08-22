package com.example.mybatisps.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component   //不要忘了把这个处理器加入ioc
public class MyHandlerDate implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        //插入时的填充策略
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
//        //更新时的填充策略
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }
}
