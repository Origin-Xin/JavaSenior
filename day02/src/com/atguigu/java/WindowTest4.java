package com.atguigu.java;

/**
 *      使用同步方法处理继承Thread类的方式中的线程安全问题
 *
 *  关于同步方法的总结：
 *  1.同步方法仍然涉及到同步监视器，只是不需要我们显式的声明
 *  2.非静态的同步方法，同步监视器是：this
 *      静态的同步方法，同步监视器是：当前类本身
 * @author Tonny
 * @version 2021.2
 * @date 2022/5/7 11:59
 */
class Window4 extends Thread{
    private static int ticket=100;
    private static Object obj=new Object();
    @Override
    public void run() {
        while (true){
                show();
            }
        }
    private static synchronized void show(){//同步监视器：Window4.class
//    private synchronized void show(){//同步监视器：t1,t2,t3 此种解决方式是真确的
        if (ticket>0){
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"卖票，票号："+ticket);
            ticket--;
        }
    }
}
public class WindowTest4 {
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
