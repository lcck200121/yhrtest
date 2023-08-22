package com.yhr.pojo;

public class leaveApprove {
    private int id;
    private String content;
    private String create_User;
    private String approve_User;
    private String status;
    private String firstTime;
    private String secondTime;

    public leaveApprove() {
    }

    public leaveApprove(int id, String content, String create_User, String approve_User, String status, String firstTime, String secondTime) {
        this.id = id;
        this.content = content;
        this.create_User = create_User;
        this.approve_User = approve_User;
        this.status = status;
        this.firstTime = firstTime;
        this.secondTime = secondTime;
    }

    public String getFirstTime() {
        return firstTime;
    }

    public void setFirstTime(String firstTime) {
        this.firstTime = firstTime;
    }

    public String getSecondTime() {
        return secondTime;
    }

    public void setSecondTime(String secondTime) {
        this.secondTime = secondTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreate_User() {
        return create_User;
    }

    public void setCreate_User(String create_User) {
        this.create_User = create_User;
    }

    public String getApprove_User() {
        return approve_User;
    }

    public void setApprove_User(String approve_User) {
        this.approve_User = approve_User;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "leaveApprove{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", create_User='" + create_User + '\'' +
                ", approve_User='" + approve_User + '\'' +
                ", status='" + status + '\'' +
                ", firstTime='" + firstTime + '\'' +
                ", secondTime='" + secondTime + '\'' +
                '}';
    }
}
