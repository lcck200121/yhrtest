package com.yhr.Service;

import com.yhr.Mapper.approveMapper;
import com.yhr.pojo.Lead;
import com.yhr.pojo.leaveApprove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class approveService {
    @Autowired
    approveMapper approveMapper;

    public List<leaveApprove> queryLeaveList(){
        List<leaveApprove> leaveApproves = approveMapper.queryLeaveList();
        return leaveApproves;
    }

    public void addLeave(leaveApprove leaveApprove) {
        approveMapper.addLeave(leaveApprove);
    }
}
