package com.jfh.bean;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * @Author jiafenghua
 * @Date 2021/6/25 上午7:42
 * @Description TODO
 * 封面类
 */

public class CoverInputBean {
    //设置excel表头名称
    @ExcelProperty(value = "第一列",index = 0)
    private String col1;
    @ExcelProperty(value = "第二列",index = 1)
    private String col2;
    @ExcelProperty(value = "第三列",index = 2)
    private String col3;
    @ExcelProperty(value = "第四列",index = 3)
    private String col4;
    @ExcelProperty(value = "第五列",index = 4)
    private String col5;
    @ExcelProperty(value = "第六列",index = 5)
    private String col6;

    public String getCol1() {
        return col1;
    }

    public void setCol1(String col1) {
        this.col1 = col1;
    }

    public String getCol2() {
        return col2;
    }

    public void setCol2(String col2) {
        this.col2 = col2;
    }

    public String getCol3() {
        return col3;
    }

    public void setCol3(String col3) {
        this.col3 = col3;
    }

    public String getCol4() {
        return col4;
    }

    public void setCol4(String col4) {
        this.col4 = col4;
    }

    public String getCol5() {
        return col5;
    }

    public void setCol5(String col5) {
        this.col5 = col5;
    }

    public String getCol6() {
        return col6;
    }

    public void setCol6(String col6) {
        this.col6 = col6;
    }

    @Override
    public String toString() {
        return "CoverInputBean{" +
                "col1='" + col1 + '\'' +
                ", col2='" + col2 + '\'' +
                ", col3='" + col3 + '\'' +
                ", col4='" + col4 + '\'' +
                ", col5='" + col5 + '\'' +
                ", col6='" + col6 + '\'' +
                '}';
    }
}
