package com.atguigu.java;

import org.junit.Test;

import java.util.*;

/**
 * Collection接口中声明的方法的测试
 *
 *  结论：
 *  向Collection接口的实现类的对象中添加数据obj时，要求obj所在类要重写equals()
 * @author Tonny
 * @version 2021.2
 * @date 2022/5/19 9:57
 */
public class CollectionTest {

    @Test
    public void test1(){
        //contains()
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tim"));
        coll.add(false);
//        Person person=new Person("Jerry",20);
//        coll.add(new Person("Jerry",20));
//        coll.add(person);
        coll.add(new Person("Jerry",20));
        //1.contains(Object obj):判断当前集合中是否包含Obj
        //在判断时会调用obj对象所在类的equals()
        boolean contains = coll.contains(123);
        System.out.println(contains);
//          System.out.println(coll.contains(person));//true
        System.out.println(coll.contains(new String("Tim")));
        System.out.println(coll.contains(new Person("Jerry",20)));

        //2.containsAll(Collection coll1):判断形参coll1中的Collection中的所有元素是否都存在于当前集合中
        Collection coll1= Arrays.asList("123","456");
        System.out.println(coll.containsAll(coll1));
    }
    @Test
    public void test2(){
        //3.remove(Object obj)：从当前集合中移除obj
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tim"));
        coll.add(new Person("Jerry",20));
        coll.add(false);

        coll.remove(123);
        System.out.println(coll);

        coll.remove(new Person("Jerry",20));
        System.out.println(coll);

        //4.removeAll(Collection coll1):从当前集合中移除coll1中的所有的元素
        Collection coll1=Arrays.asList(123,456);
        coll.removeAll(coll1);
        System.out.println(coll);
    }
    @Test
    public void test3(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tim"));
        coll.add(new Person("Jerry",20));
        coll.add(false);

        //5.retainAll；获取当前集合与coll1的交集，并返回给当前集合
//        Collection coll1=Arrays.asList("123","456");
//        coll.retainAll(coll1);
//        System.out.println(coll);

        //6.equals(Object obj):当前集合和形参集合的元素都相同，则返回true
        Collection coll1=new ArrayList();
        coll1.add(123);
        coll1.add(456);
        coll1.add(new String("Tim"));
        coll1.add(new Person("Jerry",20));
        coll1.add(false);

        System.out.println(coll.equals(coll1));

    }
    @Test
    public void test4(){
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tim"));
        coll.add(new Person("Jerry",20));
        coll.add(false);

        //7.hashCode:返回当前对象的哈希值
        System.out.println(coll.hashCode());

        //8.集合-->数组：toArray()
        Object[] objects = coll.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }

        //拓展：数组-->集合：调用Arrays类的静态方法asList()
        List<String> strings = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(strings);

        List arr = Arrays.asList(new int[]{123, 456});
        System.out.println(arr.size());

        List arr1 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(arr1.size());

        //9.iterator():返回Iterator接口的实例，用于遍历集合元素。放在返回IteratorTest.java中测试
    }

}
