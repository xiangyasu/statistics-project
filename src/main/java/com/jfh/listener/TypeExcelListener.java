package com.jfh.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.jfh.bean.UserInputBean;

import java.util.Map;
import java.util.Objects;

/**
 * @Author jiafenghua
 * @Date 2021/6/25 上午7:46
 * @Description TODO
 */
public class TypeExcelListener extends AnalysisEventListener<UserInputBean> {
    public Map<String, Integer> userNameMap ;    //已采纳


    public TypeExcelListener(Map<String, Integer> userNameMap) {
        this.userNameMap = userNameMap;
    }

    //一行一行读取excel内容
    @Override
    public void invoke(UserInputBean userInputBean, AnalysisContext analysisContext) {
        System.out.println("--->"+ userInputBean);

        String userName = userInputBean.getUserName();  //姓名
        String dept = userInputBean.getDept();          // 部室

        if (!Objects.isNull(userName) && userName.equals("姓名")) {
            return;
        }

        userName = Objects.isNull(userName) ? null: userName.trim();    //消除“姓名”中可能存在的空格
        dept = Objects.isNull(dept) ? null: dept.trim();                //消除“部室”中可能存在的空格

        String key = userName + "-" + dept; //姓名与部署拼接，拼接之后的结果如： 贾丰华-大数据

        if (userNameMap.containsKey(key)) {
            userNameMap.put(key, userNameMap.get(key) + 1);
        } else {
            userNameMap.put(key, 1);
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

