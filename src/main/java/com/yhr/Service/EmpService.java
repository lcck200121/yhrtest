package com.yhr.Service;

import com.yhr.Mapper.EmployeeMapper;
import com.yhr.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {
    @Autowired
    private EmployeeMapper employeeMapper;

    public Integer addEmployee(Employee employee){
            return employeeMapper.addEmployee(employee);

    }

    public Integer deleteEmployee(Integer id){

        return employeeMapper.deleteEmployee(id);
    }
}
