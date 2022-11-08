package com.atguigu.java1;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author Tonny
 * @version 2021.2
 * @date 2022/5/25 17:35
 */
public class TreeSetTest {
    /*
    1.向TreeSet中添加的数据，要求是相同类的对象
    2.两种排序方式：自然排序(实现Comparable)和定制排序(Comparator)

    3.自然排序中，比较两个对象是否相同的标准为：compareTo()返回0，不再是equals().
    4.定制排序中，比较两个对象是否相同的标准为：compare()返回0，不再是equals().
     */
    @Test
    public void test1(){
        TreeSet set = new TreeSet();
        //失败：不能添加不同类的对象
//        set.add(123);
//        set.add(456);
//        set.add("AA");
//        set.add(new User("Kim",18));
          //举例一：
//        set.add(34);
//        set.add(-34);
//        set.add(58);
//        set.add(52);
//        set.add(0);
          //举例二：
        set.add(new User("Tom",12));
        set.add(new User("kim",16));
        set.add(new User("lix",18));
        set.add(new User("Ouy",20));
        set.add(new User("jack",19));


        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    @Test
    public void test2(){
        //按照年龄从小到大排序
        Comparator com=new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof User && o2 instanceof User){
                    User u1=(User)o1;
                    User u2=(User)o2;
                    return Integer.compare(u1.getAge(),u2.getAge());
                }else {
                    throw new RuntimeException("输入的数据类型不匹配");
                }

            }
        };
        TreeSet set = new TreeSet(com);
        set.add(new User("Tom",12));
        set.add(new User("kim",16));
        set.add(new User("lix",18));
        set.add(new User("Ouy",20));
        set.add(new User("jack",19));


        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
