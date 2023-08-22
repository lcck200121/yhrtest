package com.yhr.Controller;

import com.yhr.Service.approveService;
import com.yhr.pojo.leaveApprove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ApproveController {
    @Autowired
    approveService approveService;

    //进入请假页面
    @RequestMapping("/toLeave")
    public String list(Model model){
        List List = approveService.queryLeaveList();
        //保存起来
        model.addAttribute("leaves",List);

        return "/leaveNotice_table.html";
    }

    @GetMapping("/addLeave")
    public String toAdding(Model model){
        return "/addLeave";
    }

    @RequestMapping("/addLeaveOk")
    public String addEmployee(leaveApprove leaveApprove, HttpServletRequest request){
//        SessionUser sessionUser= SessionUser.getUser(request);
//        leaveApprove.setCreate_User(sessionUser.getEmpName());
        leaveApprove.setCreate_User("yanghognrui");
        leaveApprove.setStatus("1");
        approveService.addLeave(leaveApprove);

        System.out.println(leaveApprove);
        return "redirect:/toLeave ";
    }
}
