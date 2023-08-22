package com.yhr.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notice {
    private String notice_name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date notice_data;
    private String notice_value;

    public String getNotice_name() {
        return notice_name;
    }

    public void setNotice_name(String notice_name) {
        this.notice_name = notice_name;
    }

    public Date getNotice_data() {
        return notice_data;
    }

    public void setNotice_data(Date notice_data) {
        this.notice_data = notice_data;
    }

    public String getNotice_value() {
        return notice_value;
    }

    public void setNotice_value(String notice_value) {
        this.notice_value = notice_value;
    }
}
