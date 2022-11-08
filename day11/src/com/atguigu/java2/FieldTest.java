package com.atguigu.java2;


import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author Tonny
 * @version 2021.2
 * @date 2022/6/14 20:42
 */
public class FieldTest {
    @Test
    public void test(){
        Class<Person> clazz = Person.class;

        //获取属性结构
        //getFields():获取当前运行时类及其父类中声明public访问权限的属性
//        Field[] fields = clazz.getFields();
//        for (Field f:fields){
//            System.out.println(f);
//        }

        //getDeclaredFields():获取当前运行时类中声明的所有属性(不包含父类中声明的属性)
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f:declaredFields){
            System.out.println(f);
        }
    }
    //权限修饰符 数据类型 变量名
    @Test
    public void test2(){
        Class clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for(Field f : declaredFields){
            //1.权限修饰符
            int modifier = f.getModifiers();
            System.out.print(Modifier.toString(modifier) + "\t");
            System.out.println("+++++++++++++++++++++++++++");
            //2.数据类型
            Class type = f.getType();
            System.out.print(type.getName() + "\t");
            System.out.println("***************************");
            //3.变量名
            String fName = f.getName();
            System.out.print(fName);
        }

    }
}
