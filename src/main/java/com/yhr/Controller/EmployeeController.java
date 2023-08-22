package com.yhr.Controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.yhr.Service.DepartmentService;
import com.yhr.Service.EmpService;
import com.yhr.dao.DepartmentDao;
import com.yhr.dao.EmployeeDao;
import com.yhr.pojo.Department;
import com.yhr.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentService departmentService;
//    DepartmentDao departmentDao;
    @Autowired
    EmpService empService;
    @RequestMapping("/emps")
    public String list(Model model){
//        Collection<Employee> employees = employeeDao.getEmployee();
        List employeeList = employeeDao.queryEmployeeList();
        //保存起来
        model.addAttribute("emps",employeeList);

        return "/basic_table";
    }

    @GetMapping("/emp")
    public String toAdding(Model model){
        Collection<Department> departments = departmentService.getDepartments();
        model.addAttribute("departments",departments);
        return "/addemp";
    }

//   @PostMapping("/emp")
//    public String addEmp(Employee employee){
////employeeDao.save(employee);
//        return "redirect:/emps";
//    }

    @PostMapping("/add")
    public String addEmployee(Employee employee){
         empService.addEmployee(employee);

        System.out.println(employee);
        return "redirect:/emps ";
    }

    @GetMapping("/delemp/{id}")
    public String deleteEmployee(@PathVariable("id") int id){
        empService.deleteEmployee(id);

        return "redirect:/emps";
    }



}
