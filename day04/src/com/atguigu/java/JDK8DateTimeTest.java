package com.atguigu.java;

import org.junit.Test;

import java.text.Format;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Formatter;

/**
 * @author Tonny
 * @version 2021.2
 * @date 2022/5/15 17:16
 */
public class JDK8DateTimeTest {
        /*
        LocalDate、LocalTime、LocalDateTime的使用
         */
        @Test
    public void test1(){
            //now()获取当前的日期，时间，日期+时间
            LocalDate localDate = LocalDate.now();
            LocalTime localTime = LocalTime.now();
            LocalDateTime localDateTime = LocalDateTime.now();

            System.out.println(localDate);
            System.out.println(localTime);
            System.out.println(localDateTime);
            //of():设置指定的年，月，日，时，分，秒。没有偏移量
            LocalDateTime localDateTime1 =LocalDateTime.of(2021,5,14,17,37,30);
            System.out.println(localDateTime1);

            //getXXX():获取相关属性
            System.out.println(localDateTime.getDayOfMonth());
            System.out.println(localDateTime.getDayOfWeek());
            System.out.println(localDateTime.getDayOfYear());
            System.out.println(localDateTime.getMonthValue());
            System.out.println(localDateTime.getMinute());


            //体现不可变性:设置相关属性
                LocalDate localDate1 = localDate.withDayOfMonth(22);
                System.out.println(localDate);
                System.out.println(localDate1);

                LocalDateTime localDateTime2 = localDateTime.withHour(4);
                System.out.println(localDateTime);
                System.out.println(localDateTime2);

                LocalDateTime localDateTime3 = localDateTime.plusMonths(7);
                System.out.println(localDateTime);
                System.out.println(localDateTime3);
        }
        /*
        Instant的使用
         */
        @Test
        public void test2(){
                //now():获取本初子午线对应的标准时间
                Instant instant = Instant.now();
                System.out.println(instant);//2022-05-15T09:57:23.481958500Z

                //添加时间偏移量
                OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
                System.out.println(offsetDateTime);

                //toEpochMilli()获取对应的毫秒数-->Date类的getTime方法
                long milli = instant.toEpochMilli();
                System.out.println(milli);

                //ofEpochMilli():通过给定的毫秒数，获取Instant实例-->Date(long mills)
                Instant instant1 = Instant.ofEpochMilli(1652608910485L);
                System.out.println(instant1);
        }
        /*
        DateTimeFormatter:格式化或解析日期，时间类似于SimpleDateFormat
         */
        @Test
        public void test3(){

//                预定义的标准格式。如：ISO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
                DateTimeFormatter isoDateTime = DateTimeFormatter.ISO_DATE_TIME;
                //格式化:日期-->字符串
                LocalDateTime localDateTime = LocalDateTime.now();
                String str= isoDateTime.format(localDateTime);
                System.out.println(localDateTime);
                System.out.println(str);

                TemporalAccessor parse = isoDateTime.parse("2022-05-15T18:22:04.346706");
                System.out.println(parse);

//                本地化相关的格式。如：ofLocalizedDateTime(FormatStyle.LONG)
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
                String str1= dateTimeFormatter.format(localDateTime);
                System.out.println(str1);//2022/5/15 下午6:36
//                自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)

        }
}
