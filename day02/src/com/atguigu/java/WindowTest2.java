package com.atguigu.java;

import java.awt.*;

/**
 * 例子：创建三个窗口买票，总票数为100张，使用继承Thread方式完成
 *  使用同步代码块解决使用继承Thread类的方式的线程安全问题
 *
 *  说明：在继承Thread类创建多线程的方式中，慎用this充当同步监视器，考虑使用当前类充当同步监视器
 * @author Tonny
 * @version 2021.2
 * @date 2022/5/4 16:20
 */
class Window2 extends Thread{
    private static int ticket=100;
    private static Object obj=new Object();
    @Override
    public void run() {
        while (true){
            //正确的
            //synchronized (obj)
            synchronized (Window2.class){//class clazz=window2.class,window2.claa只会加载一次
            //错误的：this代表着t1,t2,t3三个对象
            //synchronized (this)
                if (ticket>0){
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(getName()+"卖票，票号："+ticket);
                    ticket--;
                }
                else {
                    break;
                }
            }
        }
    }
}
public class WindowTest2 {
    public static void main(String[] args) {
        Window2 w1 = new Window2();
        Window2 w2 = new Window2();
        Window2 w3 = new Window2();

        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");

        w1.start();
        w2.start();
        w3.start();
    }
}
