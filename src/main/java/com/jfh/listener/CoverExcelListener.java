package com.jfh.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.jfh.bean.CoverInputBean;
import com.jfh.bean.ReviewInputBean;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author jiafenghua
 * @Date 2021/8/25 上午7:46
 * @Description 封面处理类
 */
public class CoverExcelListener extends AnalysisEventListener<Map<Integer, String> > {
    public Map<String, String> coverInfoMap ;



    public CoverExcelListener(Map<String, String> coverInfoMap) {
        this.coverInfoMap = coverInfoMap;

    }

    //一行一行读取excel内容
    @Override
    public void invoke(Map<Integer, String>  inputMap, AnalysisContext analysisContext) {
//        System.out.println("封面--->"+ inputMap);
        if (inputMap.get(0).contains("项目编号")) {
            coverInfoMap.put("项目编号", inputMap.get(1));
        }
        if (!Objects.isNull(inputMap.get(2)) && inputMap.get(2).contains("项目名称")) {
            coverInfoMap.put("项目名称", inputMap.get(3));
        }
        if (!Objects.isNull(inputMap.get(4)) && inputMap.get(4).contains("负责部室")) {
            coverInfoMap.put("负责部室", inputMap.get(5));
        }
        if (inputMap.get(0).contains("评审日期") && inputMap.get(0).contains("部室")) {
            coverInfoMap.put("评审日期(部室)", inputMap.get(1));
        }
        if (inputMap.get(0).contains("评审日期") && inputMap.get(0).contains("中心")) {
            coverInfoMap.put("评审日期(中心)", inputMap.get(1));
        }
    }
    //读取表头内容
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
//        System.out.println("表头："+headMap);
    }
    //读取完成之后
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) { }
}

