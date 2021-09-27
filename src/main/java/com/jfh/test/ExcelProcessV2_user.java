package com.jfh.test;

import com.alibaba.excel.EasyExcel;
import com.jfh.bean.*;
import com.jfh.listener.*;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author jiafenghua
 * @Date 2021/6/25 上午7:48
 * @Description 按照用户进行统计
 */
public class ExcelProcessV2_user {

    public static void main(String[] args) {

        /** 输入路径*/
        File directory = new File("C:\\Users\\admin\\Desktop\\Fw_转发：评审记录统计小工具开发参考模板2_bak");
        /** 输出路径1*/
        String userOutputFile = "C:\\Users\\admin\\Desktop\\统计结果\\z_根据人员的统计结果.xlsx";

        /** 需要读取的sheet页名称*/
        String sheetName0 = "封面";
        String sheetName1 = "评审记录-中心";
        String sheetName2 = "评审记录-部室";
        String sheetName3 = "评审人员";

        HashMap<String, String> coverInfoMap = new HashMap<String, String>();    //用于存储封面信息
        HashMap<String, UserSummaryBean> userSummaryMap = new HashMap<String, UserSummaryBean>();    // 评审人员 的 汇总信息存放的map


        List<List<? extends Serializable>> resultList = new ArrayList<>();

        /** 遍历目录下的excel文件，一个一个进行处理*/
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (null != files && files.length > 0) {
                for (File file : files) {
                    System.out.println("----------->处理文件: " + file.getName());
                    if (file.getName().contains(".DS_Store") || file.getName().contains("~")) {
                        continue;
                    }
                    //读取封面
                    EasyExcel.read(file,new CoverExcelListener(coverInfoMap)).sheet(sheetName0).doRead();
                    //读取"评审人员"
                    EasyExcel.read(file, UserInputBean.class,new UserSummaryExcelListener(userSummaryMap, coverInfoMap.get("项目名称"))).sheet(sheetName3).doRead();
                    //读取"评审记录-中心"
                    EasyExcel.read(file, ReviewInputBean.class,new UserCenterExcelListener(userSummaryMap, coverInfoMap.get("项目名称"))).sheet(sheetName1).doRead();
                    //读取"评审记录-部室"
                    EasyExcel.read(file, ReviewInputBean.class,new UserCenterExcelListener(userSummaryMap, coverInfoMap.get("项目名称"))).sheet(sheetName2).doRead();

                }
            }
        }

        if (null != userSummaryMap && userSummaryMap.size() > 0) {
            for (String userName : userSummaryMap.keySet()) {
                UserSummaryBean bean = userSummaryMap.get(userName);
                List<? extends Serializable> tempList = Arrays.asList(
                        userName,
                        bean.getProject().size(),
                        (bean.getAccept() + bean.getPartAccept() + bean.getNotAccept() + bean.getNoFeedback()),
                        bean.getAccept(),
                        bean.getPartAccept(),
                        bean.getNotAccept(),
                        bean.getNoFeedback(),
                        bean.getType1_bianxieguifan(),
                        bean.getType2_xuqiufenxi(),
                        bean.getType3_xuqiusheji(),
                        bean.getType4_xuqiuzhenghe(),
                        bean.getType5_jaigoufenxi(),
                        bean.getType6_luodichegnxiao(),
                        bean.getType7_yonghutiyan(),
                        bean.getType8_anquan(),
                        bean.getType9_dashuju(),
                        bean.getType10_jishu()
                );
                resultList.add(tempList);
            }
        }



        // 调用easyexcel里面的方法实现写操作
        // write方法两个参数：第一个参数文件路径名称，第二个参数实体类class
        EasyExcel.write(userOutputFile, UserSummaryOutputBean.class).sheet("统计结果").doWrite(resultList);

    }
}
