package com.yhr.Service;

import com.yhr.Mapper.NoticeMapper;
import com.yhr.pojo.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {
    @Autowired
    NoticeMapper noticeMapper;
    public List queryNoticeList(){
        List<Notice> notices = noticeMapper.queryNoticeList();
        return notices;
    }
}
