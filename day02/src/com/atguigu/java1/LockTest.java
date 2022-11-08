package com.atguigu.java1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题的方式三：Lock锁--JDK5.0新增
 *
 * 1.面试题:synchronized 与 Lock的异同?
 * 相同：二者可以解决线程安全问题
 * 不同：synchronized机制在执行完相应的同步代码以后，自动的释放同步监视器
 *      Lock需要手动的启动同步(lock())，同时结束与需要手动的实现(unlock())
 * @author Tonny
 * @version 2021.2
 * @date 2022/5/9 9:31
 */
 class Window implements Runnable{
    private int ticket=100;
    //实例化ReentrantLock对象
    private ReentrantLock lock=new ReentrantLock();
    @Override
    public void run() {
        try {
            //调用lock()
            lock.lock();
            for (int i=0;i<100;i++){
                if (ticket>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"售票，票价为："+ticket);
                    ticket--;
                }
                else {
                    break;
                }
            }
        }finally {

        }
    }
}
public class LockTest  {
    public static void main(String[] args) {
        Window w = new Window();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}


