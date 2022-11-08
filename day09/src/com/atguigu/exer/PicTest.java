package com.atguigu.exer;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Tonny
 * @version 2021.2
 * @date 2022/6/7 17:09
 */
public class PicTest {
    //图片的加密
    @Test
    public void test(){
        FileInputStream fis= null;
        FileOutputStream fos= null;
        try {
            fis = new FileInputStream("1.png");
            fos = new FileOutputStream("secret.png");

            byte[] buffer=new byte[20];
            int len;
            while ((len=fis.read(buffer))!=-1){
                //字节数组进行修改
                //错误的
    //            for (byte b:buffer){
    //                b= (byte) (b^5);
    //            }
                //正确的
                for (int i = 0; i < buffer.length; i++) {
                    buffer[i]= (byte) (buffer[i]^5);
                }
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis!=null)
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos!=null)
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //图片的解密
    @Test
    public void test1(){
        FileInputStream fis= null;
        FileOutputStream fos= null;
        try {
            fis = new FileInputStream("secret.png");
            fos = new FileOutputStream("4.png");

            byte[] buffer=new byte[20];
            int len;
            while ((len=fis.read(buffer))!=-1){
                //字节数组进行修改
                //错误的
                //            for (byte b:buffer){
                //                b= (byte) (b^5);
                //            }
                //正确的
                for (int i = 0; i < buffer.length; i++) {
                    buffer[i]= (byte) (buffer[i]^5);
                }
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis!=null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos!=null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
