package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 *处理流之一：缓冲流的使用
 *
 * 1.缓冲流
 *  BufferedInputStream
 *  BufferedOutputStream
 *  BufferedReader
 *  BufferedWriter
 *
 *  2.作用：提高流的读取，写入的速度
 *  提高读写的速度原因：内部提供了一个缓冲区
 * @author Tonny
 * @version 2021.2
 * @date 2022/6/6 12:11
 */
public class BufferedTest {
    /*
    实现非文本文件的复制
     */
    @Test
    public void test(){
        BufferedInputStream bis= null;
        BufferedOutputStream bos= null;
        try {
            //1.造文件
            File srcFile=new File("1.png");
            File destFile=new File("3.png");
            //2造流
            //2.1造节点流
            FileInputStream fis=new FileInputStream(srcFile);
            FileOutputStream fos=new FileOutputStream(destFile);
            //2.2造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //3.赋值细节：读入和写出
            byte[] buffer=new byte[5];
            int len;
            while ((len=bis.read(buffer))!=-1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流资源的关闭
            //要求：先关闭外层的流，再关闭内层的流
            try {
                if (bis!=null)
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bos!=null)
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭，可以省略。
//        fis.close();
//        fos.close();
        }
    }
    public void copyFileWithBuffered(String srcPath,String destPath){
        BufferedInputStream bis= null;
        BufferedOutputStream bos= null;
        try {
            //1.造文件
            File srcFile=new File(srcPath);
            File destFile=new File(destPath);
            //2造流
            //2.1造节点流
            FileInputStream fis=new FileInputStream(srcFile);
            FileOutputStream fos=new FileOutputStream(destFile);
            //2.2造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //3.赋值细节：读入和写出
            byte[] buffer=new byte[5];
            int len;
            while ((len=bis.read(buffer))!=-1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流资源的关闭
            //要求：先关闭外层的流，再关闭内层的流
            try {
                if (bis!=null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bos!=null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //说明：关闭外层流的同时，内层流也会自动的进行关闭。关于内层流的关闭，可以省略。
//        fis.close();
//        fos.close();
        }
    }
    @Test
    public void test3(){
        long start=System.currentTimeMillis();

        String srcPath="";
        String destPath="";
        copyFileWithBuffered(srcPath,destPath);

        long end=System.currentTimeMillis();

        System.out.println("复制操作花费的时间为："+(end-start));
    }
    /*

       */
    @Test
    public void test4(){
        BufferedReader br= null;
        BufferedWriter bw= null;
        try {
            //创建文件和相应的流
            br = new BufferedReader(new FileReader(new File("dbcp.txt")));
            bw = new BufferedWriter(new FileWriter(new File("dbcp1.txt")));
            //读写操作
            //方法一：
//            char[] buffer=new char[5];
//            int len;
//            while ((len=br.read(buffer))!=-1){
//                bw.write(buffer,0,len);
//            }
            //方法二：使用String
            String data;
            while ((data=br.readLine())!=null){
                //方法一：
//                bw.write(data+"\n");//data中不包含换行符
                //方法二：
                bw.write(data);//data中不包含换行符
                bw.newLine();//提供换行操作
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流资源
            try {
                if (br!=null)
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bw!=null)
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
