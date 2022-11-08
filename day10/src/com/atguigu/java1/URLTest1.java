package com.atguigu.java1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Tonny
 * @version 2021.2
 * @date 2022/6/12 11:23
 */
public class URLTest1 {
    public static void main(String[] args) {

        InputStream is = null;
        FileOutputStream fos = null;
        try {
            URL url = new URL("http://localhost:8080/examples/beauty.jpg?username=Tom");
            HttpURLConnection urlConnection =(HttpURLConnection)url.openConnection();
            urlConnection.connect();
            is = urlConnection.getInputStream();
            fos = new FileOutputStream("\\day10\\7.png");

            byte[] buffer=new byte[1024];
            int len;
            while ((len=is.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
            System.out.println("下载完成");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is!=null)
                is.close();
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
