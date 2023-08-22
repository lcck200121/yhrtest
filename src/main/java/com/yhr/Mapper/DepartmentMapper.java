package com.yhr.Mapper;

import com.yhr.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Mapper
@Repository
public interface DepartmentMapper {
    public Collection<Department> getDepartments();
    public Department getDepartmentsById(Integer id);
}
