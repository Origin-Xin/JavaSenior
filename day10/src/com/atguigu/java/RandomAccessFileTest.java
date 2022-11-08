package com.atguigu.java;

import org.junit.Test;
import org.junit.runners.model.FrameworkField;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile的使用
 * 1.RandomAccessFile直接继承于java.lang.Object类，实现类DataInput和DataOutput接口。
 * 2.RandomAccessFile既可以作为一个输入流，又可以作为一个输出流
 *
 * 3.如果RandomAccessFile作为输出流时,写出到的文件如果不存在，则在执行过程中自动创建
 *  如果写出到的文件存在，则会对原有文件内容进行覆盖。（默认情况下，从头覆盖）
 * 4.可以通过相关的操作，实现RandomAccessFile"插入"数据的效果
 *
 * @author Tonny
 * @version 2021.2
 * @date 2022/6/10 20:21
 */
public class RandomAccessFileTest {
    @Test
    public void test(){
        RandomAccessFile raf= null;
        RandomAccessFile raf1= null;
        try {
            raf = new RandomAccessFile(new File("1.png"),"r");
            raf1 = new RandomAccessFile(new File("2.png"),"rw");

            byte[] buffer=new byte[1024];
            int len;
            while ((len=raf.read(buffer))!=-1){
                raf1.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (raf!=null)
                raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (raf1!=null)
                raf1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    @Test
    public void test2() throws IOException {
        RandomAccessFile raf=new RandomAccessFile(new File("hello.txt"),"rw");

        raf.seek(3);//将指针调到角标为3的位置
        raf.write("xyz".getBytes());
        raf.write("123".getBytes());
        raf.close();
    }
    /*
    使用RandomAccessFile实现数据的插入效果
     */
    @Test
    public void test3() throws IOException {
        RandomAccessFile raf=new RandomAccessFile(new File("hello.txt"),"rw");
        raf.seek(3);//将指针调到角标为3的位置
        //保存指针为3后面的所有数据到StringBuffer中
        StringBuffer builder=new StringBuffer((int) new File("hello.txt").length());
        byte[] buffer=new byte[20];
        int len;
        while ((len=raf.read(buffer))!=-1){
            builder.append(new String(buffer,0,len));
        }
        //调回指针,写入"xyz"
        raf.seek(3);//将指针调到角标为3的位置
        raf.write("xyz".getBytes());
        //将StringBuilder中的数据写入到文件中
        raf.write(builder.toString().getBytes());

        raf.close();
    }
}
