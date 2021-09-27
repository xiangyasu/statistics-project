package com.jfh.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.jfh.bean.ReviewInputBean;
import com.jfh.bean.UserInputBean;

import java.util.Map;

/**
 * @Author jiafenghua
 * @Date 2021/6/25 上午7:46
 * @Description
 */
public class UserCountExcelListener extends AnalysisEventListener<UserInputBean> {
    public Map<String, Integer> userSummaryMap ;    // 用户人数统计





    public UserCountExcelListener(Map<String, Integer> userSummaryMap) {
        this.userSummaryMap = userSummaryMap;
    }

    //一行一行读取excel内容
    @Override
    public void invoke(UserInputBean reviewInputBean, AnalysisContext analysisContext) {
//        System.out.println("--->"+ reviewInputBean);
        if (userSummaryMap.containsKey("评审人数")) {
            userSummaryMap.put("评审人数", userSummaryMap.get("评审人数") + 1);
        } else {
            userSummaryMap.put("评审人数", 1);
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

