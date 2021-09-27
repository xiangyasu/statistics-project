package com.jfh.bean;

import com.alibaba.excel.annotation.ExcelProperty;


/**
 * @Author jiafenghua
 * @Date 2021/6/25 上午7:42
 * @Description TODO
 */

public class UserOutputBean {
    //设置excel表头名称
    @ExcelProperty(value = "参评人",index = 0)
    private String type;
    @ExcelProperty(value = "部室",index = 1)
    private Integer dept;
    @ExcelProperty(value = "合计",index = 2)
    private Integer sumCount;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getDept() {
        return dept;
    }

    public void setDept(Integer dept) {
        this.dept = dept;
    }

    public Integer getSumCount() {
        return sumCount;
    }

    public void setSumCount(Integer sumCount) {
        this.sumCount = sumCount;
    }
}
