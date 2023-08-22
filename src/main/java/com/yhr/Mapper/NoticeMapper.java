package com.yhr.Mapper;

import com.yhr.pojo.Employee;
import com.yhr.pojo.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NoticeMapper {
    List<Notice> queryNoticeList();
    Integer addNotice(Notice notice);
}
