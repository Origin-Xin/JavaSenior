package com.atguigu.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * jdk 8之前的日期时间的API测试
 * 1.System类中的currentTimeMillis()
 * 2.java.util.Date和子类java.sql.Date
 * 3.SimpleDateFormat
 * 4.Calendar
 * @author Tonny
 * @version 2021.2
 * @date 2022/5/14 17:39
 */
public class DateTimeTest {
    /*
    SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析

    1.两个操作：
    1.1格式化：日期-->字符串
    1.2解析：格式化的逆过程，字符串-->日期

    */
    @Test
    public void testSimpleDateFormat() throws ParseException {
        //实力化SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化：日期-->字符串
        Date date = new Date();
        System.out.println(date);
        String format = sdf.format(date);
        System.out.println(format);

        //解析：格式化的逆过程，字符串-->日期
        String str="2022/12/14 下午8:53";
        Date parse = sdf.parse(str);
        System.out.println(parse);
        //指定的方式格式化和解析
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format1 = sdf1.format(date);
        System.out.println(format1);
        //解析:要求字符串必须时符合SimpleDateFormat识别的格式(通过构造器参数体现)
        //否则：抛异常
        Date date1 = sdf1.parse("2022-05-14 06:01:36");
        System.out.println(date1);
    }

        /*
        练习1：字符串“2022-5-14”转换为java.sql.Date

        练习2：“三天打渔两天晒网” 1990-01-01 xxxx-xx-xx 打渔？筛网？

        举例：2022-05-14？总天数

        总天数 % 5==1,2,3 ：打渔
        总天数 % 5==4,0 ：晒完

        总天数的计算？
        方式一： (date2.getTime()-date1.getTime())/(1000*60*60*24) +1
        方式二： 1990-01-01-->2021-12-31 + 2022-1-1-->2022-5-14
        */
    @Test
    public void test() throws ParseException {
        String birth="2022-5-14";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(birth);

        java.sql.Date birthDate=new java.sql.Date(date.getTime());
        System.out.println(birthDate);

    }
     /*
        Calendar日历类（抽象类）的使用
         */
    @Test
    public void testCalendar(){
        //1.实例化
        //方式一：创建其子类对象（GregorianCalendar）对象
        //方式二：调用其静态方法Calendar.getInstance()
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);

        //2.常用方法
        //get()
        int i = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(i);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        //set()
        calendar.set(Calendar.DAY_OF_MONTH,18);
        i= calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(i);
        //add()
        calendar.add(Calendar.DAY_OF_MONTH,-3);
        i= calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(i);
        //getTime:日历类-->Date
        Date date = calendar.getTime();
        System.out.println(date);
        //setTime():Date-->日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        
    }
}
