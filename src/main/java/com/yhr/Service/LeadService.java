package com.yhr.Service;

import com.yhr.Mapper.LeadMapper;
import com.yhr.pojo.Lead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeadService {
    @Autowired
    LeadMapper leadMapper;
    public List<Lead> queryLeadList(){
        List<Lead> leads = leadMapper.queryLeadList();
        return leads;
    }
}
