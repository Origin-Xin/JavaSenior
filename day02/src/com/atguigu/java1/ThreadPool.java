package com.atguigu.java1;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 创建线程的方式：使用线程池
 *
 * 好处：
 * 1.提高响应速度（减少了创建新线程的时间）
 * 2.降低资源消耗（重复利用线程池中线程，不需要每次都创建）
 * 3.便于线程管理
 *  corePoolSize：核心池的大小
 *  maximumPoolSize：最大线程数
 *  keepAliveTime：线程没有任务时最多保持多长时间后会终止
 * @author Tonny
 * @version 2021.2
 * @date 2022/5/10 11:46
 */
class NumberThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
class NumberThread1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
public class ThreadPool {
    public static void main(String[] args) {
        //1.
        ExecutorService service= Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1= (ThreadPoolExecutor) service;
        //设置线程池的属性
//        System.out.println(service.getClass());
//        service1.setCorePoolSize(15);
//        service1.setKeepAliveTime(100);
        service.execute(new NumberThread());//适合实用与Runnable
        service.execute(new NumberThread1());//适合实用与Runnable
//        service.submit();//适合使用与callable
        //关闭连接池
        service.shutdown();

    }
}
