package com.yhr.Controller;

import com.yhr.Service.LeadService;
import com.yhr.pojo.Lead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/lead")
public class LeadController {

    @Autowired
    LeadService leadService;

    @RequestMapping("/list")
    public String LeadList(Model model){
        List<Lead> leads = leadService.queryLeadList();
        model.addAttribute("leads",leads);
        return "lead_table";
    }


}
