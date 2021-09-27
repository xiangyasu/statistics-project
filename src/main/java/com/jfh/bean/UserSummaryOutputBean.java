package com.jfh.bean;

import com.alibaba.excel.annotation.ExcelProperty;

import java.util.HashSet;

/**
 * @Author jiafenghua
 * @Date 2021/8/29 下午4:20
 * @Description TODO
 */
public class UserSummaryOutputBean {
    @ExcelProperty(value = "姓名",index = 0)
    private String userName;

    //参加评审过的项目
    @ExcelProperty(value = "评审项目数量",index = 1)
    private Integer projectCnt ;
    @ExcelProperty(value = "评审意见",index = 2)
    private Integer opinion ;
    @ExcelProperty(value = "采纳",index = 3)
    private Integer accept;
    @ExcelProperty(value = "部分采纳",index = 4)
    private Integer partAccept;
    @ExcelProperty(value = "不采纳",index = 5)
    private Integer notAccept;
    @ExcelProperty(value = "未反馈",index = 6)
    private Integer noFeedback;

    /** 编写规范	需求分析	需求设计	需求整合	架构分析	落地成效	用户体验	安全	大数据	技术*/
    @ExcelProperty(value = "编写规范",index = 7)
    private Integer type1_bianxieguifan;
    /** 需求分析 */
    @ExcelProperty(value = "需求分析",index = 8)
    private Integer type2_xuqiufenxi = 0;
    /** 需求设计*/
    @ExcelProperty(value = "需求设计",index = 9)
    private Integer type3_xuqiusheji;
    /** 需求整合 */
    @ExcelProperty(value = "需求整合",index = 10)
    private Integer type4_xuqiuzhenghe;
    /** 架构分析*/
    @ExcelProperty(value = "架构分析",index = 11)
    private Integer type5_jaigoufenxi;
    /** 落地成效*/
    @ExcelProperty(value = "落地成效",index = 12)
    private Integer type6_luodichegnxiao ;
    /** 用户体验 */
    @ExcelProperty(value = "用户体验",index = 13)
    private Integer type7_yonghutiyan;
    /** 安全*/
    @ExcelProperty(value = "安全",index = 14)
    private Integer type8_anquan;
    /** 大数据 */
    @ExcelProperty(value = "大数据",index = 15)
    private Integer type9_dashuju;
    /** 技术*/
    @ExcelProperty(value = "技术",index = 16)
    private Integer type10_jishu;

}
