package com.yhr.Service;

import com.yhr.Mapper.DepartmentMapper;
import com.yhr.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    public Collection<Department> getDepartments(){
        return departmentMapper.getDepartments();
    }
    public Department getDepartmentsById(Integer id){
        return departmentMapper.getDepartmentsById(id);
    }
}
