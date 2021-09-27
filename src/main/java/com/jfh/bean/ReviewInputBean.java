package com.jfh.bean;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * @Author jiafenghua
 * @Date 2021/6/25 上午7:42
 * @Description TODO
 * 该类的字段，与“评审记录-中心”和“评审记录-部室”的excel的表头一一对应
 */

public class ReviewInputBean {
    //设置excel表头名称
    @ExcelProperty(value = "序号",index = 0)
    private Integer id;
    @ExcelProperty(value = "类别",index = 1)
    private String type;
    @ExcelProperty(value = "评审意见",index = 2)
    private String comment;
    @ExcelProperty(value = "提出人",index = 3)
    private String userName;
    @ExcelProperty(value = "采纳结果",index = 4)
    private String result;
    @ExcelProperty(value = "备注",index = 5)
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "ReviewInputBean{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", comment='" + comment + '\'' +
                ", userName='" + userName + '\'' +
                ", result='" + result + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
