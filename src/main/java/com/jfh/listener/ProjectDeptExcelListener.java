package com.jfh.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.jfh.bean.ReviewInputBean;

import java.util.Map;

/**
 * @Author jiafenghua
 * @Date 2021/6/25 上午7:46
 * @Description 以"项目"为统计维度的处理类 处理"部室"
 */
public class ProjectDeptExcelListener extends AnalysisEventListener<ReviewInputBean> {
    public Map<String, Integer> deptSummaryMap ;    //已采纳





    public ProjectDeptExcelListener(Map<String, Integer> deptSummaryMap) {
        this.deptSummaryMap = deptSummaryMap;
    }

    //一行一行读取excel内容
    @Override
    public void invoke(ReviewInputBean reviewInputBean, AnalysisContext analysisContext) {
//        System.out.println("--->"+ reviewInputBean);
        String type = reviewInputBean.getType();
        String userName = reviewInputBean.getUserName();
        String result = reviewInputBean.getResult();

        if (deptSummaryMap.containsKey(result)) {
            deptSummaryMap.put(result, deptSummaryMap.get(result) + 1);
        } else {
            deptSummaryMap.put(result, 1);
        }

        if (deptSummaryMap.containsKey(type)) {
            deptSummaryMap.put(type, deptSummaryMap.get(type) + 1);
        } else {
            deptSummaryMap.put(type, 1);
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

