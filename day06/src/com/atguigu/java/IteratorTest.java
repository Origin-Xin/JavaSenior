package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合元素的遍历操作,使用迭代器Iterator接口
 * 1.内部方法：hasNext() 和 next()
 * 2.集合对象每次调用iterator()方法都得到一个全新的迭代器对象,
 * 默认游标都在集合的第一个元素之前
 * 3.内部定义了remove(),可以在遍历的时候，删除集合中的元素。此方法不同于集合直接调用remove()
 * @author Tonny
 * @version 2021.2
 * @date 2022/5/19 20:32
 */
public class IteratorTest {
    @Test
    public void test(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tim"));
        coll.add(new Person("Jerry",20));
        coll.add(false);

        Iterator iterator = coll.iterator();
        //方式一：
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        //报异常：NoSuchElementException
//        System.out.println(iterator.next());
        //方式二：不推荐
//        for (int i=0;i<coll.size();i++){
//            System.out.println(iterator.next());
//        }

        //方式三：
        while (iterator.hasNext()){
            //next():①指针下移 ②将下移以后集合位置上的元素返回
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test2(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tim"));
        coll.add(new Person("Jerry",20));
        coll.add(false);

        Iterator iterator = coll.iterator();
        //错误方式一：
//        while ((iterator.next())!=null){
//            System.out.println(iterator.next());
//        }
        //错误方式二：
//        while (coll.iterator().hasNext()){
//            System.out.println(coll.iterator().next());
//        }
    }
    //测试Iterator中的remove()
    @Test
    public void test3(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tim"));
        coll.add(new Person("Jerry",20));
        coll.add(false);
        Iterator iterator = coll.iterator();
        //删除集合中“Tim”
        while (iterator.hasNext()){
            Object o = iterator.next();
            if ("Tim".equals(o)){
                iterator.remove();
            }
        }
        iterator = coll.iterator();
        //遍历集合
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
