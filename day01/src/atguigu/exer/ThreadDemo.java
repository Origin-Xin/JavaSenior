package atguigu.exer;

/**
 *
 * 练习:创建两个分线程，其中一个线程遍历100以内的偶数，另一个线程遍历100以内的奇数。
 * @author Tonny
 * @version 2021.2
 * @date 2022/5/3 18:33
 */
public class ThreadDemo {
    public static void main(String[] args) {
//        MyThread1 m1 = new MyThread1();
//        MyThread2 m2 = new MyThread2();
//        m1.start();
//        m2.start();
        //创建Thread类的匿名子类的方式
        new MyThread1(){
            public void run() {
                for(int i=0;i<100;i++){
                    if (i%2==0){
                        System.out.println(Thread.currentThread().getName()+":"+i);
                    }
                }
            }
        }.start();

        new MyThread2(){
            public void run() {
                for(int i=0;i<100;i++){
                    if (i%2!=0){
                        System.out.println(Thread.currentThread().getName()+":"+i);
                    }
                }
            }
        }.start();
    }
}
class MyThread1 extends Thread{
   /* @Override
    public void run() {
        for(int i=0;i<100;i++){
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }*/
}
class MyThread2 extends Thread{
   /* @Override
    public void run() {
        for(int i=0;i<100;i++){
            if (i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }*/
}
