package com.jfh.bean;

import com.alibaba.excel.annotation.ExcelProperty;


/**
 * @Author jiafenghua
 * @Date 2021/6/25 上午7:42
 * @Description TODO
 */

public class ProjectOutputBean {
    //设置excel表头名称
    @ExcelProperty(value = "项目编号",index = 0)
    private String projectNo;
    @ExcelProperty(value = "项目名称",index = 1)
    private String projectName;
    @ExcelProperty(value = "负责部室",index = 2)
    private String dept;
    @ExcelProperty(value = "评审人数",index = 3)
    private Integer reviewerCnt;


    @ExcelProperty(value = "评审日期(中心)",index = 4)
    private String dateCenter;
    @ExcelProperty(value = "评审意见",index = 5)
    private Integer centerOpinionCnt;
    @ExcelProperty(value = "采纳",index = 6)
    private Integer centerAccept;
    @ExcelProperty(value = "部分采纳",index = 7)
    private Integer centerPartAccept;
    @ExcelProperty(value = "不采纳",index = 8)
    private Integer centerNotAccept;
    @ExcelProperty(value = "未反馈",index = 9)
    private Integer centerNoFeedback;
    /** 编写规范	需求分析	需求设计	需求整合	架构分析	落地成效	用户体验	安全	大数据	技术*/
    @ExcelProperty(value = "编写规范",index = 10)
    private Integer centerType1;
    @ExcelProperty(value = "需求分析",index = 11)
    private Integer centerType2;
    @ExcelProperty(value = "需求设计",index = 12)
    private Integer centerType3;
    @ExcelProperty(value = "需求整合",index = 13)
    private Integer centerType4;
    @ExcelProperty(value = "架构分析",index = 14)
    private Integer centerType5;
    @ExcelProperty(value = "落地成效",index = 15)
    private Integer centerType6;
    @ExcelProperty(value = "用户体验",index = 16)
    private Integer centerType7;
    @ExcelProperty(value = "安全",index = 17)
    private Integer centerType8;
    @ExcelProperty(value = "大数据",index = 18)
    private Integer centerType9;
    @ExcelProperty(value = "技术",index = 19)
    private Integer centerType10;

    /**************************/

    @ExcelProperty(value = "评审日期(部室)",index = 20)
    private String dateDept;
    @ExcelProperty(value = "评审意见",index = 21)
    private Integer deptOpinionCnt;
    @ExcelProperty(value = "采纳",index = 22)
    private Integer deptAccept;
    @ExcelProperty(value = "部分采纳",index = 23)
    private Integer deptPartAccept;
    @ExcelProperty(value = "不采纳",index = 24)
    private Integer deptNotAccept;
    @ExcelProperty(value = "未反馈",index = 25)
    private Integer deptNoFeedback;
    /** 编写规范	需求分析	需求设计	需求整合	架构分析	落地成效	用户体验	安全	大数据	技术*/
    @ExcelProperty(value = "编写规范",index = 26)
    private Integer deptType1;
    @ExcelProperty(value = "需求分析",index = 27)
    private Integer deptType2;
    @ExcelProperty(value = "需求设计",index = 28)
    private Integer  deptType3;
    @ExcelProperty(value = "需求整合",index = 29)
    private Integer deptType4;
    @ExcelProperty(value = "架构分析",index = 30)
    private Integer deptType5;
    @ExcelProperty(value = "落地成效",index = 31)
    private Integer deptType6;
    @ExcelProperty(value = "用户体验",index = 32)
    private Integer deptType7;
    @ExcelProperty(value = "安全",index = 33)
    private Integer deptType8;
    @ExcelProperty(value = "大数据",index = 34)
    private Integer deptType9;
    @ExcelProperty(value = "技术",index = 35)
    private Integer deptType10;


}
