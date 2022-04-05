package com.ssx.eam2ncc.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtils {
    //获取某年某月的第一天
    public static  String getFirstDayOfMonth(String month){
        int year = Integer.parseInt(month.substring(0,4));  //截取出年份，并将其转化为int
        int month1 = Integer.parseInt(month.substring(5,7));    //截去除月份，并将其转为int

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,year);    //设置年份
        cal.set(Calendar.MONTH, month1-1);  //设置月份
        int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH); //获取某月最小天数
        cal.set(Calendar.DAY_OF_MONTH, firstDay);   //设置日历中月份的最小天数
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String firstDayOfMonth = sdf.format(cal.getTime());
        return firstDayOfMonth;

    }

    //获取某年某月最后一天
    public static String getLastDayOfMonth(String month){
        int year = Integer.parseInt(month.substring(0,4));  //截取出年份，并将其转化为int
        int month1 = Integer.parseInt(month.substring(5,7));    //截去除月份，并将其转为int


        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,year);    //设置年份
        cal.set(Calendar.MONTH, month1-1);  //设置月份
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);  //获取某月最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);    //设置日历中月份的最大天数
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String lastDayOfMonth = sdf.format(cal.getTime());
        return lastDayOfMonth;
    }

    //测试
    public static void main(String[] args) {
        String month = "2021-02";
        System.out.println(getFirstDayOfMonth(month));
        System.out.println(getLastDayOfMonth(month));
    }
}
