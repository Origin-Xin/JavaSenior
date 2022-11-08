package com.atguigu.java1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 创建线程的方式三：实现callable接口。--JDK 5.0新增
 *  1.call()可以有返回值的
 *  2.call()可以抛出异常，被外面的操作捕获，获取异常的信息
 *  3.callable可以支持泛型
 *
 * 如何理解实现Callable接口的方式创建多线程比实现Runnable接口？
 * 1.
 * @author Tonny
 * @version 2021.2
 * @date 2022/5/10 10:56
 */
//1.创建一个实现类callable实现了
class NewThread implements Callable{
    //2.实现call方法，将此线程需要执行的操作声明在Call()中
    @Override
    public Object call() throws Exception {
        int sum=0;
        for (int i = 0; i <100 ; i++) {
            if (i%2==0){
                System.out.println(i);
                sum +=i;
            }
        }
        return sum;
    }
}
public class ThreadNew{
    public static void main(String[] args) {
        //3.创建Callable接口实现类的对象
        NewThread newThread = new NewThread();
        //4.将此Callable接口实现类的对象作为参数传递到FutureTask的构造器中，创建FutureTask的对象
        FutureTask futureTask = new FutureTask(newThread);
        //5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()
        new Thread(futureTask).start();

        try {
            //6.获取Callable中call方法的返回值
            //get()返回值即为FuterTask构造器参数callable实现类重写的call()返回值
            Object sum=futureTask.get();
            System.out.println("总和为"+sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
