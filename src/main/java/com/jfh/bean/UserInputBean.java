package com.jfh.bean;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * @Author jiafenghua
 * @Date 2021/6/25 上午7:42
 * @Description TODO
 */

public class UserInputBean {
    //设置excel表头名称
    @ExcelProperty(value = "序号",index = 0)
    private String id;
    @ExcelProperty(value = "姓名",index = 1)
    private String userName;
    @ExcelProperty(value = "部室",index = 2)
    private String dept;
    @ExcelProperty(value = "角色",index = 3)
    private String role;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "UserInputBean{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", dept='" + dept + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
