package com.atguigu.java;

import org.junit.Test;

import java.util.*;

/**
 *
 * 泛型的使用
 * 1.jdk5.0新增特性
 *
 * 2.在集合中使用泛型：
 * 总结：
 * 1.集合接口或集合类在jdk5.0时都修改为带泛型的结构
 * 2.在实例化集合类时，可以指明具体的泛型类型
 * 3.指明完以后，在集合类或接口中凡是定义类或接口时，内部结构使用到类的泛型的位置，都指定为实例化的泛型类型。
 * 比如：add(E e) ---->实例化以后:add(Integer e)
 * 4.注意点：泛型的类型必须时是类,不能是基本数据类型。需要用到基本数据类型的位置,那包装类来替换
 * 5.如果实例化时,没有指明泛型的类型。默认类型为java.lang.Object类型。
 *
 * 3.如何自定义泛型结构：泛型类，泛型接口，泛型方法。
 *
 * @author Tonny
 * @version 2021.2
 * @date 2022/5/29 16:57
 */
public class GenericTest {
    //在集合中使用泛型之前的情况
    @Test
    public void test(){
        ArrayList list=new ArrayList();
        //需求：存放学生数据
        list.add(78);
        list.add(89);
        list.add(98);
        list.add(100);
        //问题一：类型不安全
        list.add("Tom");

        for (Object Score:list){
            //问题二：强转时，可能出现ClassCastException
            int StuScore= (int) Score;
            System.out.println(StuScore);
        }

    }
    //在集合中使用泛型之前的情况:以ArrayList为例
    @Test
    public void test1(){
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(78);
        list.add(89);
        list.add(98);
        list.add(100);
        //编译时，就会进行类型检查，保证数据安全
//        list.add("Tim");
        //方式一：
        for (Integer score:list){
            //避免了强转操作
            int stuScore=score;
            System.out.println(stuScore);
        }
        //方式二：
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
           int stuScore=iterator.next();
            System.out.println(stuScore);
        }
    }
    //在集合中使用泛型的情况：以HashMap为例
    @Test
    public void test3(){
        Map<String,Integer> map=new HashMap<String,Integer>();

        map.put("Tim",18);
        map.put("Jerry",20);
        map.put("Jack",18);
        
//        map.put(123,"ABC");
        //泛型的嵌套
        Set<Map.Entry<String,Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            String key=next.getKey();
            Integer value=next.getValue();

            System.out.println(key+"---->"+value);
        }
    }
}
