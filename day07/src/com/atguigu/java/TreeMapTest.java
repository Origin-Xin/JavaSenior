package com.atguigu.java;

import org.junit.Test;

import java.util.*;

/**
 * @author Tonny
 * @version 2021.2
 * @date 2022/5/28 10:57
 */
public class TreeMapTest {
        //向TreeMap中添加key-value,要求key必须是由同一个类创建的对象
        //因为要按照key进行排序：自然排序，定制排序
        //自然排序
        @Test
    public void test1(){
            TreeMap treeMap = new TreeMap();

            User u1 = new User("Tom",18);
            User u2 = new User("jake",20);
            User u3 = new User("kim",33);
            User u4 = new User("jos",54);

            treeMap.put(u1,98);
            treeMap.put(u2,86);
            treeMap.put(u3,55);
            treeMap.put(u4,44);

            Set set = treeMap.entrySet();
            Iterator iterator = set.iterator();
            while (iterator.hasNext()){
                Object obj = iterator.next();
                Map.Entry entry=(Map.Entry)obj;
                System.out.println(entry.getKey()+"---->"+entry.getValue());
            }
        }
        //定制排序
        @Test
    public void test2(){
            TreeMap treeMap = new TreeMap(new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                   if (o1 instanceof User && o2 instanceof User){
                       User u1=(User) o1;
                       User u2=(User) o2;
                       return Integer.compare(u1.getAge(), u2.getAge());
                   }
                   throw new RuntimeException("输入的类型不匹配");
                }
            });

            User u1 = new User("Tom",18);
            User u2 = new User("jake",20);
            User u3 = new User("kim",33);
            User u4 = new User("jos",54);

            treeMap.put(u1,98);
            treeMap.put(u2,86);
            treeMap.put(u3,55);
            treeMap.put(u4,44);

            Set set = treeMap.entrySet();
            Iterator iterator = set.iterator();
            while (iterator.hasNext()){
                Object obj = iterator.next();
                Map.Entry entry=(Map.Entry)obj;
                System.out.println(entry.getKey()+"---->"+entry.getValue());
            }
        }
}
