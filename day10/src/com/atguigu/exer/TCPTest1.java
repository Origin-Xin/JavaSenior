package com.atguigu.exer;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * 实现TCP网络编程
 * 例子1：客户端发送信息给服务器，服务器将数据显示在控制台上
 *
 * @author Tonny
 * @version 2021.2
 * @date 2022/6/11 15:20
 */
public class TCPTest1 {

    //客户端
    @Test
    public void client() throws Exception {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 8899);
        OutputStream os = socket.getOutputStream();
        os.write("你好我是客户端".getBytes());
        os.close();
        socket.close();
    }
    //服务端
    @Test
    public void server() throws Exception {
        ServerSocket serverSocket = new ServerSocket(8899);
        Socket socket = serverSocket.accept();
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer=new byte[20];
        int len;
        while ((len=is.read(buffer))!=-1){
            baos.write(buffer,0,len);
        }
        System.out.println(baos.toString());
        is.close();
        baos.close();
        socket.close();
        serverSocket.close();
    }
}
