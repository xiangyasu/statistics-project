package com.jfh.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.jfh.bean.UserInputBean;
import com.jfh.bean.UserSummaryBean;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Author jiafenghua
 * @Date 2021/6/25 上午7:46
 * @Description
 */
public class UserSummaryExcelListener extends AnalysisEventListener<UserInputBean> {
    public HashMap<String, UserSummaryBean> userSummaryMap ;    // 用户人数统计
    public String projectName;





    public UserSummaryExcelListener(HashMap<String, UserSummaryBean> userSummaryMap, String projectName) {
        this.userSummaryMap = userSummaryMap;
        this.projectName = projectName;
    }

    //一行一行读取excel内容
    @Override
    public void invoke(UserInputBean reviewInputBean, AnalysisContext analysisContext) {
//        System.out.println("--->"+ reviewInputBean);
        String userName = reviewInputBean.getUserName();
        if (userName == null || userName.trim().length() == 0) {
            return;
        }

        if (userSummaryMap.containsKey(userName)) {
            UserSummaryBean bean = userSummaryMap.get(userName);
            HashSet projectSet = bean.getProject();
            projectSet.add(projectName);
        } else {
            UserSummaryBean bean = new UserSummaryBean(userName, projectName);
            userSummaryMap.put(userName, bean);
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

