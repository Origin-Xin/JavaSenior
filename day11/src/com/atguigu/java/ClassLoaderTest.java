package com.atguigu.java;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 了解类的加载器
 * @author Tonny
 * @version 2021.2
 * @date 2022/6/14 10:22
 */
public class ClassLoaderTest {
    @Test
    public void test(){
        //对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        //调用系统类加载器的getParent():获得扩展类加载器
        ClassLoader classLoaderParent = classLoader.getParent();
        System.out.println(classLoaderParent);
        //调用扩展类加载器的getParent()：无法获得引导类加载器
        //引导类加载器主要负责加载java的核心类库，无法加载自定义类的
        ClassLoader parent = classLoaderParent.getParent();
        System.out.println(parent);

        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);
    }
    @Test
    public void test1() throws IOException, ClassNotFoundException {
        Properties pros = new Properties();
        //此时的文件默认在当前的module下。
        //读取配置文件的方式一：
//        FileInputStream fis=new FileInputStream("jdbc.properties");
//        FileInputStream fis=new FileInputStream("src//jdbc1.properties");
//        pros.load(fis);
        //读取配置文件的方式二：使用ClassLoader
        //配置文件默认识别为：当前module的src下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
        pros.load(is);


        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        System.out.println("user:"+user+",password:"+password);
    }
}
