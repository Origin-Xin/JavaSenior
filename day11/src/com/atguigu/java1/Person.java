package com.atguigu.java1;

/**
 * @author Tonny
 * @version 2021.2
 * @date 2022/6/14 18:19
 */
@MyAnnotation(value = "hi")
public class Person extends Creature<String> implements Comparable<String>,MyInterface{

    private  String name;
    int age;
    public int id;

    public Person() {

    }
    @MyAnnotation(value = "abc")
    private Person(String name) {
        this.name = name;
    }

     Person(int age, int id) {
        this.age = age;
        this.id = id;
    }
    @MyAnnotation
    private String show(String nation){
        System.out.println("我的国籍是"+nation);
        return nation;
    }

    public String display(String interests,int age)throws NullPointerException,ClassCastException{
        return interests+age;
    }

    @Override
    public void info() {
        System.out.println("我是一个人");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    private static void showDesc(){
        System.out.println("我是傻逼");
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
