package com.jfh.bean;

import java.util.HashSet;

/**
 * @Author jiafenghua
 * @Date 2021/8/29 下午4:20
 * @Description TODO
 */
public class UserSummaryBean {

    private String userName;

    //参加评审过的项目
    private HashSet project ;

    private Integer opinion = 0;

    private Integer accept = 0;

    private Integer partAccept = 0;

    private Integer notAccept = 0;

    private Integer noFeedback = 0;

    /** 编写规范	需求分析	需求设计	需求整合	架构分析	落地成效	用户体验	安全	大数据	技术*/
    private Integer type1_bianxieguifan = 0;
    /** 需求分析 */
    private Integer type2_xuqiufenxi = 0;
    /** 需求设计*/
    private Integer type3_xuqiusheji = 0;
    /** 需求整合 */
    private Integer type4_xuqiuzhenghe = 0;
    /** 架构分析*/
    private Integer type5_jaigoufenxi = 0;
    /** 落地成效*/
    private Integer type6_luodichegnxiao = 0;
    /** 用户体验 */
    private Integer type7_yonghutiyan = 0;
    /** 安全*/
    private Integer type8_anquan = 0;
    /** 大数据 */
    private Integer type9_dashuju = 0;
    /** 技术*/
    private Integer type10_jishu = 0;

    /***** 构造方法 *****/
    public UserSummaryBean(String userName) {
        this.userName = userName;
    }

    public UserSummaryBean(String userName, String projectName) {
        this.userName = userName;
        HashSet<Object> set = new HashSet<>();
        set.add(projectName);
        this.project = set;
    }


    /*******getter和setter方法*********/
    public HashSet getProject() {
        return project;
    }

    public void setProject(HashSet project) {
        this.project = project;
    }

    public Integer getOpinion() {
        return opinion;
    }

    public void setOpinion(Integer opinion) {
        this.opinion = opinion;
    }

    public Integer getAccept() {
        return accept;
    }

    public void setAccept(Integer accept) {
        this.accept = accept;
    }

    public Integer getPartAccept() {
        return partAccept;
    }

    public void setPartAccept(Integer partAccept) {
        this.partAccept = partAccept;
    }

    public Integer getNotAccept() {
        return notAccept;
    }

    public void setNotAccept(Integer notAccept) {
        this.notAccept = notAccept;
    }

    public Integer getType1_bianxieguifan() {
        return type1_bianxieguifan;
    }

    public void setType1_bianxieguifan(Integer type1_bianxieguifan) {
        this.type1_bianxieguifan = type1_bianxieguifan;
    }

    public Integer getType2_xuqiufenxi() {
        return type2_xuqiufenxi;
    }

    public void setType2_xuqiufenxi(Integer type2_xuqiufenxi) {
        this.type2_xuqiufenxi = type2_xuqiufenxi;
    }

    public Integer getType3_xuqiusheji() {
        return type3_xuqiusheji;
    }

    public void setType3_xuqiusheji(Integer type3_xuqiusheji) {
        this.type3_xuqiusheji = type3_xuqiusheji;
    }

    public Integer getType4_xuqiuzhenghe() {
        return type4_xuqiuzhenghe;
    }

    public void setType4_xuqiuzhenghe(Integer type4_xuqiuzhenghe) {
        this.type4_xuqiuzhenghe = type4_xuqiuzhenghe;
    }

    public Integer getType5_jaigoufenxi() {
        return type5_jaigoufenxi;
    }

    public void setType5_jaigoufenxi(Integer type5_jaigoufenxi) {
        this.type5_jaigoufenxi = type5_jaigoufenxi;
    }

    public Integer getType6_luodichegnxiao() {
        return type6_luodichegnxiao;
    }

    public void setType6_luodichegnxiao(Integer type6_luodichegnxiao) {
        this.type6_luodichegnxiao = type6_luodichegnxiao;
    }

    public Integer getType7_yonghutiyan() {
        return type7_yonghutiyan;
    }

    public void setType7_yonghutiyan(Integer type7_yonghutiyan) {
        this.type7_yonghutiyan = type7_yonghutiyan;
    }

    public Integer getType8_anquan() {
        return type8_anquan;
    }

    public void setType8_anquan(Integer type8_anquan) {
        this.type8_anquan = type8_anquan;
    }

    public Integer getType9_dashuju() {
        return type9_dashuju;
    }

    public void setType9_dashuju(Integer type9_dashuju) {
        this.type9_dashuju = type9_dashuju;
    }

    public Integer getType10_jishu() {
        return type10_jishu;
    }

    public void setType10_jishu(Integer type10_jishu) {
        this.type10_jishu = type10_jishu;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getNoFeedback() {
        return noFeedback;
    }

    public void setNoFeedback(Integer noFeedback) {
        this.noFeedback = noFeedback;
    }
}
