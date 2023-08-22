package com.yhr.Mapper;

import com.yhr.pojo.Lead;
import com.yhr.pojo.leaveApprove;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface approveMapper {
        List<leaveApprove>  queryLeaveList();

    void addLeave(leaveApprove leaveApprove);
}
