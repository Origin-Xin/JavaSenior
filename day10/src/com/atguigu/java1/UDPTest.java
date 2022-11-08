package com.atguigu.java1;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author Tonny
 * @version 2021.2
 * @date 2022/6/12 10:42
 */
public class UDPTest {
    //发送端
    @Test
    public void sender() throws IOException {
        DatagramSocket socket = new DatagramSocket();
        String str="我是UDP方式发送的导弹";
        byte[] data = str.getBytes();
        InetAddress inet = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(data,0,data.length,inet,8899);

        socket.send(packet);
        socket.close();
    }

    //接收端
    @Test
    public void receiver() throws IOException {
        DatagramSocket socket = new DatagramSocket(8899);
        byte[] data=new byte[1024];
        DatagramPacket packet = new DatagramPacket(data,0,data.length);

        socket.receive(packet);

        System.out.println(new String(packet.getData(),0,packet.getLength()));


        socket.close();
    }
}
