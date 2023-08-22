package com.yhr.Mapper;

import com.yhr.pojo.Employee;
import com.yhr.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmployeeMapper {

    List<Employee> queryEmployeeList();
    Employee queryEmployeeListById(int id);
    Integer addEmployee(Employee employee);
    int updateEmployee(Employee employee);
    Integer deleteEmployee(int id);


}
