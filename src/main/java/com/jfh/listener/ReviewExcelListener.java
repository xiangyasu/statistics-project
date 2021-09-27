package com.jfh.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.jfh.bean.ReviewInputBean;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author jiafenghua
 * @Date 2021/6/25 上午7:46
 * @Description TODO
 */
public class ReviewExcelListener extends AnalysisEventListener<ReviewInputBean> {
    public Map<String, Integer> completeAcceptMap ;    //已采纳
    public Map<String, Integer> partAcceptMap ;        //部分采纳
    public Map<String, Integer> notAcceptMap ;         //不采纳
    HashMap<String, Integer> typeCompleteAcceptMap ;         //类型-已采纳
    HashMap<String, Integer> typePartAcceptMap ;         //类型-部分采纳
    HashMap<String, Integer> typeNotAcceptMap ;         //类型-不采纳



    public ReviewExcelListener(Map<String, Integer> completeAcceptMap, Map<String, Integer> partAcceptMap, Map<String, Integer> notAcceptMap,
                               HashMap<String, Integer> typeCompleteAcceptMap, HashMap<String, Integer> typePartAcceptMap, HashMap<String, Integer> typeNotAcceptMap) {
        this.completeAcceptMap = completeAcceptMap;
        this.partAcceptMap = partAcceptMap;
        this.notAcceptMap = notAcceptMap;
        this.typeCompleteAcceptMap = typeCompleteAcceptMap;
        this.typePartAcceptMap = typePartAcceptMap;
        this.typeNotAcceptMap = typeNotAcceptMap;
    }

    //一行一行读取excel内容
    @Override
    public void invoke(ReviewInputBean reviewInputBean, AnalysisContext analysisContext) {
        System.out.println("--->"+ reviewInputBean);
        String type = reviewInputBean.getType();
        String userName = reviewInputBean.getUserName();
        String result = reviewInputBean.getResult();


        switch (result) {
            case "采纳":
                /**处理意见人的数据*/
                if (completeAcceptMap.containsKey(userName)) {
                    completeAcceptMap.put(userName, completeAcceptMap.get(userName) + 1);
                } else {
                    completeAcceptMap.put(userName, 1);
                }

                /**处理类别的数据*/
                if (typeCompleteAcceptMap.containsKey(type)) {
                    typeCompleteAcceptMap.put(type, typeCompleteAcceptMap.get(type) + 1);
                } else {
                    typeCompleteAcceptMap.put(type, 1);
                }
                break;
            case "部分采纳":
                /**处理意见人的数据*/
                if (partAcceptMap.containsKey(userName)) {
                    partAcceptMap.put(userName, partAcceptMap.get(userName) + 1);
                } else {
                    partAcceptMap.put(userName, 1);
                }

                /**处理类别的数据*/
                if (typePartAcceptMap.containsKey(type)) {
                    typePartAcceptMap.put(type, typePartAcceptMap.get(type) + 1);
                } else {
                    typePartAcceptMap.put(type, 1);
                }
                break;

            case "不采纳":
                /**处理意见人的数据*/
                if (notAcceptMap.containsKey(userName)) {
                    notAcceptMap.put(userName, notAcceptMap.get(userName) + 1);
                } else {
                    notAcceptMap.put(userName, 1);
                }

                /**处理类别的数据*/
                if (typeNotAcceptMap.containsKey(type)) {
                    typeNotAcceptMap.put(type, typeNotAcceptMap.get(type) + 1);
                } else {
                    typeNotAcceptMap.put(type, 1);
                }
                break;
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

