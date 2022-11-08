package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 *
 * 测试FileInputStream和FileOutputStream的使用
 *
 * 结论：
 * 1.对于文本文件(.txt，.java，.c,.cpp)使用字符流处理
 * 2.对于非文本文件(.jpg,.mp3,.mp4,.avi,.doc,.ppt)使用字节流处理
 * @author Tonny
 * @version 2021.2
 * @date 2022/6/6 10:21
 */
public class FileInputOutputStreamTest {

    //使用字节流FileInputStream处理文本文件，可能出现乱码
    @Test
    public void test(){
        FileInputStream fi= null;
        try {
            //1.造文件
            File file=new File("hello.txt");
            //造流
            fi = new FileInputStream(file);
            //3.读数据
            byte[] cubf=new byte[5];
            int len;//记录每次读取的字节个数
            while ((len=fi.read(cubf))!=-1){
                String str=new String(cubf,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fi!=null)
                //关闭资源
                fi.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    /*
    实现对图片的复制操作
     */
    @Test
    public void test1(){
        FileInputStream fi= null;
        FileOutputStream fo= null;
        try {
            File srcFile=new File("1.png");
            File destFile=new File("2.png");

            fi = new FileInputStream(srcFile);
            fo = new FileOutputStream(destFile);
            //复制过程
            byte[] buffer=new byte[5];
            int len;
            while ((len=fi.read(buffer))!=-1){
                fo.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fi!=null){
                try {
                    fi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fo!=null){
                try {
                    fo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    //指定路径下的文件复制
    public void copyFile(String srcPath,String destPath){
        FileInputStream fi= null;
        FileOutputStream fo= null;
        try {
            File srcFile=new File(srcPath);
            File destFile=new File(destPath);

            fi = new FileInputStream(srcFile);
            fo = new FileOutputStream(destFile);
            //复制过程
            byte[] buffer=new byte[5];
            int len;
            while ((len=fi.read(buffer))!=-1){
                fo.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fi!=null){
                try {
                    fi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fo!=null){
                try {
                    fo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void test3(){
        long start=System.currentTimeMillis();

        String srcPath="";
        String destPath="";
        copyFile(srcPath,destPath);

        long end=System.currentTimeMillis();

        System.out.println("复制操作花费的时间为："+(end-start));
    }
}
