package com.atguigu.java;

import org.junit.Test;

import javax.annotation.processing.Filer;
import java.io.*;

/**
 * 一.流的分类
 * 1.操作数据单位：字节流，字符流
 * 2.数据的流向：输入流，输出流
 * 3.流的角色：节点流，处理流
 *
 * 二.流的体系结构
 * 抽象基类               节点流(文件流)           缓冲流(处理流的一种)
 * InputStream          FileInputStream (read(byte[] buffer))                   BufferedInputStream (read(byte[] buffer))
 * OutputStream         FileOutputStream (write(byte[] buffer,0,len))           BufferedOutputStream (write(byte[] buffer,0,len))/flush()
 * Reader               FileReader (read(char[] cubf))                          BufferedReader (read(char[] cubf)/readLine())
 * Writer               FileWriter (write(char[] cbuf,0,len))                   BufferedWriter (write(char[] cbuf,0,len))/flush()
 *
 * @author Tonny
 * @version 2021.2
 * @date 2022/6/5 20:52
 */
public class FileReaderWriterTest {
    public static void main(String[] args) {
        File file=new File("hello.txt");//相较于当前工程
        System.out.println(file.getAbsolutePath());

        File file1=new File("\\day09\\hello.txt");
        System.out.println(file1.getAbsolutePath());
    }
    /*
    将day09下的hello.txt文件内容读入程序中，并输出到控制台

    说明点：
    1.read()理解：返回一个读入的字符。如果到达文件末尾，返回-1
    2.异常的处理：为了保证流资源一定可以执行关闭操作。则需使用try-catch-finally处理
    3.读入的文件一定要存在，否则会报FileNotFoundException
     */
    @Test
    public void test1(){
        FileReader fr= null;
        try {
            //1.实例化File类的对象，指明要操作的文件
            File file=new File("hello.txt");//相较于当前module
            //2.提供具体的流
            fr = new FileReader(file);
            //3.数据的读入
            //read():返回读入的一个字符。如果未达文件末尾，返回-1。
            //方式一：
//        int read = fr.read();
//        while (read!=-1){
//            System.out.print((char) read);
//            read=fr.read();
//        }
            //方式二：
            int read;
            while ((read=fr.read())!=-1){
                System.out.print((char) read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流的关闭操作
            try {
                if (fr!=null)
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2(){
        FileReader rd= null;
        try {
            //1.File类的实例化
            File file=new File("hello.txt");
            //2.FileReader流的实例化
            rd = new FileReader(file);
            //3.读入操作
            char[] cbuf=new char[5];
            int len;
            while ((len=rd.read(cbuf))!=-1){
                //方式一：
                //错误的写法
    //            for (int i = 0; i < cbuf.length; i++) {
    //                System.out.print(cbuf[i]);
    //            }
                //正确的写法
    //            for (int i = 0; i < len; i++) {
    //                System.out.print(cbuf[i]);
    //            }
                //方式二：
                //错误的写法
    //            String str=new String(cbuf);
    //            System.out.print(str);
                //正确的写法
                String str=new String(cbuf,0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rd!=null)
                rd.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /*
    从内存中写出数据到硬盘的文件里

    说明
    1.输出操作，对应的File可以不存在的。并不会报异常
    2.
        File对应的硬盘中的文件如果不存在，在输出的过程中。会自动创建此文件
        File对应的硬盘中的文件如果存在：
                如果流使用的构造器是：FileWrite(file,false)/FileWrite(file):对原文件的覆盖
                如果流使用的构造器是：FileWrite(file,true):不会对原有文件覆盖，而是在原文件的基础上添加内容
     */
    @Test
    public void test3(){
        FileWriter fw= null;
        try {
            //1.实例化File类的对象，指明写出到的文件
            File file=new File("hello1.txt");
            //2.提供FileWriter的对象，用于数据的写出
            fw = new FileWriter(file);
            //3.写出的操作
            fw.write("I have a dream\n");
            fw.write("you need to have a dream");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流资源的关闭
            if (fw!=null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test(){
        FileReader fr= null;
        FileWriter fw= null;
        try {
            //1.创建File类的对象，指明读入和写出的文件
            File srcFile=new File("hello.txt");
            File destFile=new File("hello2.txt");
            //2.创建输入流和输出流的对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);
            //3.数据的读入和写出操作
            char[] cubf=new char[5];
            int len;//记录每次读入到cubf数组中的字符的个数
            while ((len=fr.read(cubf))!=-1){
                //每次写出len长度的字符
                fw.write(cubf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流资源的关闭
                try {
                    if (fr!=null)
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    if (fw!=null)
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
