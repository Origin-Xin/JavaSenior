package atguigu.java;

/**
 * 例子：创建三个窗口买票，总票数为100张，使用继承Thread方式完成
 * @author Tonny
 * @version 2021.2
 * @date 2022/5/4 16:20
 */
class Window extends Thread{
    private static int ticket=100;

    @Override
    public void run() {
        while (true){
            if (ticket>0){
                System.out.println(getName()+"卖票，票号："+ticket);
                ticket--;
            }
            else {
                break;
            }
        }
    }
}
public class WindowTest {
    public static void main(String[] args) {
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();

        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");

        w1.start();
        w2.start();
        w3.start();
    }
}
