package com.jfh.test;

import com.alibaba.excel.EasyExcel;
import com.jfh.bean.*;
import com.jfh.listener.ReviewExcelListener;
import com.jfh.listener.TypeExcelListener;
import java.io.File;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author jiafenghua
 * @Date 2021/6/25 上午7:48
 * @Description TODO
 */
public class ExcelProcess {

    public static void main(String[] args) {

        /** 输入路径*/
        File file = new File("/Users/susu/Downloads/Fw_转发：评审记录统计小工具开发参考模板2");
        /** 输出路径1*/
        String filename = "/Users/susu/Downloads/jiafenghua_output/z_根据项目的统计结果.xlsx";
        /** 输出路径2*/
        String filename2 = "d://z_提出评审意见人员统计结果.xlsx";
        /** 输出路径3*/
        String filename3 = "d://z_参加评审人员统计结果.xlsx";
        /** 需要读取的sheet页名称*/
        String sheetName = "评审记录-中心";
        String sheetName2 = "评审记录-部室";
        String sheetName3 = "评审人员";

        HashMap<String, Integer> completeAcceptMap = new HashMap<String, Integer>();    //已采纳
        HashMap<String, Integer> partAcceptMap = new HashMap<String, Integer>();        //部分采纳
        HashMap<String, Integer> notAcceptMap = new HashMap<String, Integer>();         //不采纳

        HashMap<String, Integer> typeCompleteAcceptMap = new HashMap<String, Integer>();         //类型-已采纳
        HashMap<String, Integer> typePartAcceptMap = new HashMap<String, Integer>();         //类型-部分采纳
        HashMap<String, Integer> typeNotAcceptMap = new HashMap<String, Integer>();         //类型-不采纳
        List<String> typeList = Arrays.asList("编写规范", "需求分析", "需求设计", "需求整合", "架构分析", "落地成效", "用户体验", "安全", "技术", "大数据");   //提前定义好类别的顺序

        HashMap<String, Integer> userNameMap = new HashMap<String, Integer>();         //“參加评审人员”统计的中间结果存放map


        /** 遍历目录下的excel文件，一个一个进行处理*/
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (null != files && files.length > 0) {
                for (File file1 : files) {
                    System.out.println("----------->处理文件" + file1.getName());
                    EasyExcel.read(file1, ReviewInputBean.class,new ReviewExcelListener(completeAcceptMap, partAcceptMap, notAcceptMap, typeCompleteAcceptMap, typePartAcceptMap, typeNotAcceptMap)).sheet(sheetName).doRead();
                    EasyExcel.read(file1, ReviewInputBean.class,new ReviewExcelListener(completeAcceptMap, partAcceptMap, notAcceptMap, typeCompleteAcceptMap, typePartAcceptMap, typeNotAcceptMap)).sheet(sheetName2).doRead();
                    EasyExcel.read(file1, UserInputBean.class,new TypeExcelListener(userNameMap)).sheet(sheetName3).doRead();
                }
            }
        }



        /******************************** 处理“根据类别的统计结果”***********************/
        List<List<? extends Serializable>> lists1 = typeList.stream().
                map(name -> Arrays.asList(
                        name,
                        (null == typeCompleteAcceptMap.get(name) ? 0 : typeCompleteAcceptMap.get(name)),
                        (null == typePartAcceptMap.get(name) ? 0 : typePartAcceptMap.get(name)),
                        (null == typeNotAcceptMap.get(name) ? 0 : typeNotAcceptMap.get(name)),
                        (null == typeCompleteAcceptMap.get(name) ? 0 : typeCompleteAcceptMap.get(name)) +
                                (null == typePartAcceptMap.get(name) ? 0 : typePartAcceptMap.get(name)) +
                                (null == typeNotAcceptMap.get(name) ? 0 : typeNotAcceptMap.get(name))
                        )
                )
                .collect(Collectors.toList());

        // 调用easyexcel里面的方法实现写操作
        // write方法两个参数：第一个参数文件路径名称，第二个参数实体类class
        EasyExcel.write(filename, TypeOutputBean.class).sheet("统计结果").doWrite(lists1);




        /******************************** 处理"按照意见提出评审意见人员的统计结果”***********************/
        HashSet<String> userNameSet = new HashSet<>();
        userNameSet.addAll(completeAcceptMap.keySet());
        userNameSet.addAll(partAcceptMap.keySet());
        userNameSet.addAll(notAcceptMap.keySet());

        List<List<? extends Serializable>> lists2 = userNameSet.stream().
                map(name -> Arrays.asList(
                        name,
                        (null == completeAcceptMap.get(name) ? 0 : completeAcceptMap.get(name)),
                        (null == partAcceptMap.get(name) ? 0 : partAcceptMap.get(name)),
                        (null == notAcceptMap.get(name) ? 0 : notAcceptMap.get(name)),
                        (null == completeAcceptMap.get(name) ? 0 : completeAcceptMap.get(name)) +
                                (null == partAcceptMap.get(name) ? 0 : partAcceptMap.get(name)) +
                                (null == notAcceptMap.get(name) ? 0 : notAcceptMap.get(name))
                        )
                )
                .collect(Collectors.toList());

        // 调用easyexcel里面的方法实现写操作
        // write方法两个参数：第一个参数文件路径名称，第二个参数实体类class
        EasyExcel.write(filename2, ReviewOutputBean.class).sheet("统计结果").doWrite(lists2);


        /******************************** 处理"按照参加评审人员的统计结果”***********************/
        List<List<? extends Serializable>> list3 = userNameMap.keySet().stream()
                                                        .map(key -> Arrays.asList(key.split("-")[0], key.split("-")[1], userNameMap.get(key)))
                                                        .collect(Collectors.toList());

        //调用easyexcel里面的方法实现写操作
        // write方法两个参数：第一个参数文件路径名称，第二个参数实体类class
        EasyExcel.write(filename3, UserOutputBean.class).sheet("统计结果").doWrite(list3);


    }
}
