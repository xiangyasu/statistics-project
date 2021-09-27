package com.jfh.test;

import com.alibaba.excel.EasyExcel;
import com.jfh.bean.*;
import com.jfh.listener.CoverExcelListener;
import com.jfh.listener.ProjectCenterExcelListener;
import com.jfh.listener.ProjectDeptExcelListener;
import com.jfh.listener.UserCountExcelListener;
import java.io.File;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author jiafenghua
 * @Date 2021/6/25 上午7:48
 * @Description 按照项目进行统计
 */
public class ExcelProcessV2_project {
    public static void main(String[] args) {
        /** 输入路径*/
        File directory = new File("C:\\Users\\admin\\Desktop\\Fw_转发：评审记录统计小工具开发参考模板2_bak");
        /** 输出路径1*/
        String projectOutputFile = "C:\\Users\\admin\\Desktop\\统计结果\\z_根据项目的统计结果.xlsx";

        /** 需要读取的sheet页名称*/
        String sheetName0 = "封面";
        String sheetName1 = "评审记录-中心";
        String sheetName2 = "评审记录-部室";
        String sheetName3 = "评审人员";

        HashMap<String, String> coverInfoMap = new HashMap<String, String>();    //用于存储封面信息
        HashMap<String, Integer> centerSummaryMap = new HashMap<String, Integer>();    // 评审记录-中心 的 汇总信息存放的map
        HashMap<String, Integer> deptSummaryMap = new HashMap<String, Integer>();    // 评审记录-部室 的 汇总信息存放的map
        HashMap<String, Integer> userSummaryMap = new HashMap<String, Integer>();    // 评审人员 的 汇总信息存放的map

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
                    EasyExcel.read(file, ReviewInputBean.class,new ProjectCenterExcelListener(centerSummaryMap)).sheet(sheetName1).doRead();
                    EasyExcel.read(file, ReviewInputBean.class,new ProjectDeptExcelListener(deptSummaryMap)).sheet(sheetName2).doRead();
                    EasyExcel.read(file, UserInputBean.class,new UserCountExcelListener(userSummaryMap)).sheet(sheetName3).doRead();

                    List<? extends Serializable> tempList = Arrays.asList(
                            coverInfoMap.get("项目编号"),
                            coverInfoMap.get("项目名称"),
                            coverInfoMap.get("负责部室"),
                            userSummaryMap.get("评审人数"),
                            coverInfoMap.get("评审日期(中心)"),
                            (centerSummaryMap.get("采纳") != null ? centerSummaryMap.get("采纳") : 0 ) +
                                    (centerSummaryMap.get("部分采纳") != null ? centerSummaryMap.get("部分采纳") : 0 ) +
                                    (centerSummaryMap.get("不采纳") != null ? centerSummaryMap.get("不采纳") : 0) +
                                    (centerSummaryMap.get("未反馈") != null ? centerSummaryMap.get("未反馈") : 0),
                            centerSummaryMap.get("采纳") != null ? centerSummaryMap.get("采纳") : 0,
                            centerSummaryMap.get("部分采纳") != null ? centerSummaryMap.get("部分采纳") : 0,
                            centerSummaryMap.get("不采纳") != null ? centerSummaryMap.get("不采纳") : 0,
                            centerSummaryMap.get("未反馈") != null ? centerSummaryMap.get("未反馈") : 0,
                            centerSummaryMap.get("编写规范") != null ? centerSummaryMap.get("编写规范") : 0,
                            centerSummaryMap.get("需求分析") != null ? centerSummaryMap.get("需求分析") : 0,
                            centerSummaryMap.get("需求设计") != null ? centerSummaryMap.get("需求设计") : 0,
                            centerSummaryMap.get("需求整合") != null ? centerSummaryMap.get("需求整合") : 0,
                            centerSummaryMap.get("架构分析") != null ? centerSummaryMap.get("架构分析") : 0,
                            centerSummaryMap.get("落地成效") != null ? centerSummaryMap.get("落地成效") : 0,
                            centerSummaryMap.get("用户体验") != null ? centerSummaryMap.get("用户体验") : 0,
                            centerSummaryMap.get("安全") != null ? centerSummaryMap.get("安全") : 0,
                            centerSummaryMap.get("大数据") != null ? centerSummaryMap.get("大数据") : 0,
                            centerSummaryMap.get("技术") != null ? centerSummaryMap.get("技术") : 0,

                            /** 部室*/
                            coverInfoMap.get("评审日期(部室)"),
                            (deptSummaryMap.get("采纳") != null ? deptSummaryMap.get("采纳") : 0 )+
                                    (deptSummaryMap.get("部分采纳") != null ? deptSummaryMap.get("部分采纳") : 0 )+
                                    (deptSummaryMap.get("不采纳") != null ? deptSummaryMap.get("不采纳") : 0) +
                                    (deptSummaryMap.get("未反馈") != null ? deptSummaryMap.get("未反馈") : 0),
                            deptSummaryMap.get("采纳") != null ? deptSummaryMap.get("采纳") : 0,
                            deptSummaryMap.get("部分采纳") != null ? deptSummaryMap.get("部分采纳") : 0,
                            deptSummaryMap.get("不采纳") != null ? deptSummaryMap.get("不采纳") : 0,
                            deptSummaryMap.get("未反馈") != null ? deptSummaryMap.get("未反馈") : 0,
                            deptSummaryMap.get("编写规范") != null ? deptSummaryMap.get("编写规范") : 0,
                            deptSummaryMap.get("需求分析") != null ? deptSummaryMap.get("需求分析") : 0,
                            deptSummaryMap.get("需求设计") != null ? deptSummaryMap.get("需求设计") : 0,
                            deptSummaryMap.get("需求整合") != null ? deptSummaryMap.get("需求整合") : 0,
                            deptSummaryMap.get("架构分析") != null ? deptSummaryMap.get("架构分析") : 0,
                            deptSummaryMap.get("落地成效") != null ? deptSummaryMap.get("落地成效") : 0,
                            deptSummaryMap.get("用户体验") != null ? deptSummaryMap.get("用户体验") : 0,
                            deptSummaryMap.get("安全") != null ? deptSummaryMap.get("安全") : 0,
                            deptSummaryMap.get("大数据") != null ? deptSummaryMap.get("大数据") : 0,
                            deptSummaryMap.get("技术") != null ? deptSummaryMap.get("技术") : 0
                    );
                    resultList.add(tempList);
                    //清空map
                    coverInfoMap.clear();
                    centerSummaryMap.clear();
                    deptSummaryMap.clear();
                    userSummaryMap.clear();
                }
            }
        }

        // 调用easyexcel里面的方法实现写操作
        // write方法两个参数：第一个参数文件路径名称，第二个参数实体类class
        EasyExcel.write(projectOutputFile, ProjectOutputBean.class).sheet("统计结果").doWrite(resultList);

    }
}
