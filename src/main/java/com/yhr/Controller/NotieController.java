package com.yhr.Controller;

import com.yhr.Mapper.NoticeMapper;
import com.yhr.Service.NoticeService;
import com.yhr.pojo.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class NotieController {

    @Autowired
    NoticeService noticeService;


    @RequestMapping("/notice")
    public String Noticelist(Model model){

        List noticeList = noticeService.queryNoticeList();
        model.addAttribute("nots",noticeList);
        return "/notice_table";
    }

    @RequestMapping("/calender")
    public String Calender(){
        return "/calendar.html";
    }
}
