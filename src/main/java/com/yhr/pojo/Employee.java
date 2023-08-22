package com.yhr.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data

@NoArgsConstructor

public class Employee {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private String email;
    private String department;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;

    public Employee(Integer id, String name, Integer age, String gender, String email, String department, Date birth) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.department = department;
        this.birth = birth;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
