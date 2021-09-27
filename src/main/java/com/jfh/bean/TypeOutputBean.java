package com.jfh.bean;

import com.alibaba.excel.annotation.ExcelProperty;


/**
 * @Author jiafenghua
 * @Date 2021/6/25 上午7:42
 * @Description TODO
 */

public class TypeOutputBean {
    //设置excel表头名称
    @ExcelProperty(value = "类别",index = 0)
    private String type;
    @ExcelProperty(value = "已采纳",index = 1)
    private Integer completeAcceptCount;
    @ExcelProperty(value = "部分采纳",index = 2)
    private Integer partAcceptCount;
    @ExcelProperty(value = "不采纳",index = 3)
    private Integer notAcceptCount;
    @ExcelProperty(value = "合计",index = 4)
    private Integer sumCount;

    public Integer getSumCount() {
        return sumCount;
    }

    public void setSumCount(Integer sumCount) {
        this.sumCount = sumCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCompleteAcceptCount() {
        return completeAcceptCount;
    }

    public void setCompleteAcceptCount(Integer completeAcceptCount) {
        this.completeAcceptCount = completeAcceptCount;
    }

    public Integer getPartAcceptCount() {
        return partAcceptCount;
    }

    public void setPartAcceptCount(Integer partAcceptCount) {
        this.partAcceptCount = partAcceptCount;
    }

    public Integer getNotAcceptCount() {
        return notAcceptCount;
    }

    public void setNotAcceptCount(Integer notAcceptCount) {
        this.notAcceptCount = notAcceptCount;
    }
}
