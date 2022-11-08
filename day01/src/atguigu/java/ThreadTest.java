package atguigu.java;

/**
 * 多线程的创建，方式一：
 * 1.创建一个继承于Thread类的子类
 * 2.重写Thread的run()方法-->将此线程要执行的操作声明在run()方法中
 * 3.创建Thread类的子类的对象
 * 4.通过该对象调用Start()方法
 *
 * 例子：遍历100以内的所有偶数
 * @author Tonny
 * @version 2021.2
 * @date 2022/5/3 17:59
 */
//1.创建一个继承于Thread类的子类
class MyThread extends Thread {
    //2.重写Thread的run()方法-->将此线程要执行的操作声明在run()方法中
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        //3.创建Thread类的子类的对象
        MyThread t1 = new MyThread();
        //4.通过该对象调用Start()方法-->1.启动当前线程2.调用当前线程的run()方法
        t1.start();
        //问题一：不能通过直接调run()方法启动线程
        //t1.run();

        //问题二：再启动一个线程，遍历100以内的偶数。不可以还让已经Start()的线程去执行,会报IllegalThreadStateException的异常
        //t1.start();
        //需要重现创建一个线程对象
        MyThread t2 = new MyThread();
        t2.start();
        for (int i=0;i<100;i++){
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i+"**********");
            }
        }
    }
}
