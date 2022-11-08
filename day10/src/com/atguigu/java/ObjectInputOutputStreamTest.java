package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 *对象流的使用：
 * 1.ObjectInputStream和ObjectOutputStream
 * 2.作用：用于存储和读取基本数据类型数据或对象的处理流。它的强大之处就是可
 *          以把Java中的对象写入到数据源中，也能把对象从数据源中还原回来。
 *
 * 3.要想一个java对象时可序列化的，需要满足相应的要求。见Person.java
 *
 * @author Tonny
 * @version 2021.2
 * @date 2022/6/9 20:46
 */
public class ObjectInputOutputStreamTest {
    /*
    序列化过程：将内存中的java对象保存到磁盘中或通过网络传输出去
    使用ObjectInputStream实现
    */
    @Test
    public void test(){
        ObjectOutputStream oos= null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("Object.dat"));
            oos.writeObject(new String("我爱中国"));
            oos.flush();
            oos.writeObject(new Person("张三",18));
            oos.flush();
            oos.writeObject(new Person("李四",18,1,new Account(20)));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos!=null)
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /*
    反序列化：将磁盘文件中的对象还原为内存中的一个java对象
    使用ObjectInputStream来实现
     */
    @Test
    public void test1(){
        ObjectInputStream ois= null;
        try {
            ois = new ObjectInputStream(new FileInputStream("Object.dat"));
            Object o = ois.readObject();
            String str= (String) o;

            Person p= (Person) ois.readObject();
            Person p1= (Person) ois.readObject();
            System.out.println(str);
            System.out.println(p);
            System.out.println(p1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois!=null)
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
