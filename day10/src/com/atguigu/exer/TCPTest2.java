package com.atguigu.exer;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * 实现TCP网络编程
 * 例题2：客户端发送文件给服务端，服务端将文件保存在本地。
 *
 *
 * @author Tonny
 * @version 2021.2
 * @date 2022/6/11 16:49
 */
public class TCPTest2 {
    @Test
    public void client() throws Exception {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 8899);
        OutputStream os = socket.getOutputStream();
        FileInputStream fis = new FileInputStream(new File("1.png"));
        byte[] buffer=new byte[1024];
        int len;
        while ((len=fis.read(buffer))!=-1){
            os.write(buffer,0,len);
        }

        fis.close();
        os.close();
        socket.close();
    }

    @Test
    public void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8899);
        Socket socket = serverSocket.accept();
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File("7.png"));
        byte[] buffer = new byte[1024];
        int len;
        while ((len=is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }

        fos.close();
        is.close();
        socket.close();
        serverSocket.close();
    }
}
