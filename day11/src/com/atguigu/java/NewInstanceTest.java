package com.atguigu.java;

import org.junit.Test;

import java.util.Random;

/**
 * @author Tonny
 * @version 2021.2
 * @date 2022/6/14 17:36
 */
public class NewInstanceTest {
    @Test
    public void test() throws InstantiationException, IllegalAccessException {
        Class<Person> clazz = Person.class;
        /*
        newInstance():调用此方法，创建运行时类的对象。内部调用了运行时类的空参构造器。

        要想此方法正确的创建运行时类的对象，要求：
        1.运行时类必须提供空参的构造器
        2.空参的构造器的访问权限得够。通常设置为 public

        在javabean中要求提供一个public的空参构造器。原因：
        1.便于通过反射，创建运行时类的对象
        2.便于子类继承此运行时类时，默认调用super()时，保证父类有构造器
         */
        Person person = (Person)clazz.newInstance();
        System.out.println(person);
    }
    @Test
    public void test1(){
        //体会反射的动态性
        for (int i = 0; i < 100; i++) {
            int j = new Random().nextInt(3);
            String classPath="";
            switch (j){
                case 0:
                    classPath="java.util.Date";
                    break;
                case 1:
                    classPath="java.lang.Object";
                    break;
                case 2:
                    classPath="com.atguigu.java.Person";
                    break;
            }
            try {
                Object obj = getInstance(classPath);
                System.out.println(obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    public Object getInstance(String classPath) throws Exception{
        Class clazz = Class.forName(classPath);
        return clazz.newInstance();
    }

}
