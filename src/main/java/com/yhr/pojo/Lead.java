package com.yhr.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Data
public class Lead {
    private String Lead_name;
    private int Lead_id;
    private String Lead_dep;
    private String Lead_age;
    private String Lead_Gender;
    private String Lead_email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date Lead_birth;

    public Lead() {
    }

    public Lead(String lead_name, int lead_id, String lead_dep) {
        Lead_name = lead_name;
        Lead_id = lead_id;
        Lead_dep = lead_dep;
    }

    public Date getLead_birth() {
        return Lead_birth;
    }

    public void setLead_birth(Date lead_birth) {
        Lead_birth = lead_birth;
    }

}
