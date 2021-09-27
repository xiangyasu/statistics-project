package com.jfh.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.jfh.bean.ReviewInputBean;
import com.jfh.bean.UserSummaryBean;

import java.security.CryptoPrimitive;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

/**
 * @Author jiafenghua
 * @Date 2021/6/25 上午7:46
 * @Description 以"项目"为统计维度的处理类 处理"中心"
 */
public class UserCenterExcelListener extends AnalysisEventListener<ReviewInputBean> {
    public  HashMap<String, UserSummaryBean> userSummaryMap ;
    public String projectName ;




    public UserCenterExcelListener(HashMap<String, UserSummaryBean> userSummaryMap, String projectName) {
        this.userSummaryMap = userSummaryMap;
        this.projectName = projectName;
    }

    //一行一行读取excel内容
    @Override
    public void invoke(ReviewInputBean reviewInputBean, AnalysisContext analysisContext) {
//        System.out.println("--->"+ reviewInputBean);
        String type = reviewInputBean.getType();
        String userName = reviewInputBean.getUserName();
        String result = reviewInputBean.getResult();

        if (userSummaryMap.containsKey(userName)) {
            UserSummaryBean bean = userSummaryMap.get(userName);
            HashSet projectSet = bean.getProject();
            projectSet.add(projectName);
        } else {
            UserSummaryBean bean = new UserSummaryBean(userName, projectName);
            userSummaryMap.put(userName, bean);
        }

        UserSummaryBean bean = userSummaryMap.get(userName);

        if (!Objects.isNull(result)) {
            if ("采纳".equals(result)) {
                bean.setAccept(bean.getAccept() + 1);
            } else if ("部分采纳".equals(result)) {
                bean.setPartAccept(bean.getPartAccept() + 1);
            } else if ("不采纳".equals(result)) {
                bean.setNotAccept(bean.getNotAccept() + 1);
            } else if ("未反馈".equals(result)) {
                bean.setNoFeedback(bean.getNoFeedback() + 1);
            }
        }

        if (!Objects.isNull(type)) {
            if ("编写规范".equals(type)) {
                bean.setType1_bianxieguifan(bean.getType1_bianxieguifan() + 1);
            } else if ("需求分析".equals(type)) {
                bean.setType2_xuqiufenxi(bean.getType2_xuqiufenxi() + 1);
            } else if ("需求设计".equals(type)) {
                bean.setType3_xuqiusheji(bean.getType3_xuqiusheji() + 1);
            } else if ("需求整合".equals(type)) {
                bean.setType4_xuqiuzhenghe(bean.getType4_xuqiuzhenghe() + 1);
            } else if ("架构分析".equals(type)) {
                bean.setType5_jaigoufenxi(bean.getType5_jaigoufenxi() +1);
            } else if ("落地成效".equals(type)) {
                bean.setType6_luodichegnxiao(bean.getType6_luodichegnxiao() + 1);
            } else if ("用户体验".equals(type)) {
                bean.setType7_yonghutiyan(bean.getType7_yonghutiyan() + 1);
            } else if ("安全".equals(type)) {
                bean.setType8_anquan(bean.getType8_anquan() +1);
            } else if ("大数据".equals(type)) {
                bean.setType9_dashuju(bean.getType9_dashuju() + 1);
            } else if ("技术".equals(type)) {
                bean.setType10_jishu(bean.getType10_jishu() + 1);
            }
        }

    }
    //读取表头内容
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("表头："+headMap);
    }
    //读取完成之后
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) { }
}

