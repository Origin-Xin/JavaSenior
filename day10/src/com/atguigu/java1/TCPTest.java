package com.atguigu.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 例题3：3.从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给
 * 客户端。并关闭相应的连接。
 *
 * @author Tonny
 * @version 2021.2
 * @date 2022/6/12 10:08
 */
public class TCPTest {
    /*
    这里涉及到的异常，应该使用try-catch-finally处理
     */
    @Test
    public void client() throws IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),8899);
        OutputStream os = socket.getOutputStream();
        FileInputStream fis=new FileInputStream(new File("1.png"));

        byte[] buffer=new byte[1024];
        int len;
        while ((len=fis.read(buffer))!=-1){
            os.write(buffer,0,len);
        }
        //关闭数据输出
        socket.shutdownOutput();
        //接受来自服务器端的数据，并显示在控制台上。
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        byte[] buffer1=new byte[20];
        int len1;
        while ((len=is.read(buffer1))!=-1){
            baos.write(buffer1,0,len);
        }
        //

        System.out.println(baos.toString());

        fis.close();
        os.close();
        socket.close();
        baos.close();
        is.close();

    }

    @Test
    public void server() throws IOException {
        ServerSocket ss = new ServerSocket(8899);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        FileOutputStream fos=new FileOutputStream(new File("6.png"));

        byte[] buffer=new byte[1024];
        int len;
        while ((len=is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }

        //服务器端给予用户反馈
        System.out.println("图片传输完成");

        OutputStream os = socket.getOutputStream();
        os.write("接受成功请关闭".getBytes());

        ss.close();
        socket.close();
        is.close();
        fos.close();
        os.close();

    }
}
