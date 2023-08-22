package com.yhr.dao;


import com.yhr.Mapper.EmployeeMapper;
import com.yhr.pojo.Department;
import com.yhr.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.ParameterResolutionDelegate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeDao {

    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private EmployeeMapper employeeMapper;
//
//    static {
//        employees=new HashMap<Integer,Employee>();
//
//        employees.put(101,new Employee(101,"yy",12,1,"12269@qq",new Department(101,"学习部")));
//        employees.put(102,new Employee(102,"mm",12,0,"12269@qq",new Department(102,"看书部")));
//
//    }

//    private static Integer initid=102;
//    //查看所有员工
//    public Collection<Employee> getEmployee(){
//        return employees.values();
//    }

    //增加员工
//    public void save(Employee employee){
//        if(employee.getId()==null)
//            employee.setId(initid++);  //自加
//
//        employee.setDepartment(departmentDao.getDepartmentsById(employee.getDepartment().getId()));
//
//        employees.put(employee.getId(),employee);
//
//    }

//    //通过id查询
//    public Employee findEmployeeByid(Integer id){
//        return employees.get(id);
//    }
//
//    //删除员工
//    public void remove(int id){
//        employees.remove(id);
//    }

    public List queryEmployeeList(){
        List<Employee> employees = employeeMapper.queryEmployeeList();
        return employees;
    }

}


