package com.jfh.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.jfh.bean.ReviewInputBean;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author jiafenghua
 * @Date 2021/6/25 上午7:46
 * @Description 以"项目"为统计维度的处理类 处理"中心"
 */
public class ProjectCenterExcelListener extends AnalysisEventListener<ReviewInputBean> {
    public Map<String, Integer> centerSummaryMap ;    //已采纳





    public ProjectCenterExcelListener(Map<String, Integer> centerSummaryMap) {
        this.centerSummaryMap = centerSummaryMap;
    }

    //一行一行读取excel内容
    @Override
    public void invoke(ReviewInputBean reviewInputBean, AnalysisContext analysisContext) {
//        System.out.println("--->"+ reviewInputBean);
        String type = reviewInputBean.getType();
        String userName = reviewInputBean.getUserName();
        String result = reviewInputBean.getResult();

        if (centerSummaryMap.containsKey(result)) {
            centerSummaryMap.put(result, centerSummaryMap.get(result) + 1);
        } else {
            centerSummaryMap.put(result, 1);
        }

        if (centerSummaryMap.containsKey(type)) {
            centerSummaryMap.put(type, centerSummaryMap.get(type) + 1);
        } else {
            centerSummaryMap.put(type, 1);
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

