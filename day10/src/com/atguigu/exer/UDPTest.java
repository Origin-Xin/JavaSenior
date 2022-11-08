package com.atguigu.exer;

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

        InetAddress host = InetAddress.getLocalHost();

        String str="我是导弹";
        byte[] data=str.getBytes();

        DatagramPacket packet = new DatagramPacket(data,0,data.length,host,9988);

        socket.send(packet);

        socket.close();

    }

    //接收端
    @Test
    public void receiver() throws IOException {
        DatagramSocket socket = new DatagramSocket(9988);

        byte[] data=new byte[1024];

        DatagramPacket packet = new DatagramPacket(data, 0, data.length);

        socket.receive(packet);

        System.out.println(new String(packet.getData(),0, packet.getLength()));

        socket.close();

    }
}
