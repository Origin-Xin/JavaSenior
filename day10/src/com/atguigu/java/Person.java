package com.atguigu.java;

import java.io.Serializable;

/**
 *
 * Person需要满足如下的要求,方可序列化。
 * 1.需要实现接口：Serializable
 * 2.当前类提供一个全局常量：serialVersionUID
 * 3.除了当前Person类需要实现Serializable接口之外，还必须保证其内部所有属性也必须时可序列化的。
 *   (默认情况下,基本数据类型可序列化)
 *
 *   补充：ObjectOutputStream和ObjectInputStream不能序列化static和transient修
 * 饰的成员变量
 *
 * 4.序列化机制：
 * 对象序列化机制允许把内存中的Java对象转换成平台无关的二进制流，从
 * 而允许把这种二进制流持久地保存在磁盘上，或通过网络将这种二进制流传
 * 输到另一个网络节点。//当其它程序获取了这种二进制流，就可以恢复成原
 * 来的Java对象
 *
 * @author Tonny
 * @version 2021.2
 * @date 2022/6/10 17:15
 */
public class Person implements Serializable{

    private static final long serialVersionUID = 41564564564562L;

    private String name;
    private int age;
    private int id;
    private Account acct;
    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, int id, Account acct) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.acct = acct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
class Account implements Serializable{
    private static final long serialVersionUID = 4151654564562L;

    private double balance;

    public Account() {

    }

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                '}';
    }
}
