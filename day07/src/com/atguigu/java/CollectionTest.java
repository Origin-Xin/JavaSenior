package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Collections:操作Collection,Map的工具类
 *
 * 面试题：Collection 和 Collections的区别?
 * @version 2021.2
 * @date 2022/5/29 10:09
 */
public class CollectionTest {
    /*
    reverse(List)：反转 List 中元素的顺序
    shuffle(List)：对 List 集合元素进行随机排序
    sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
    sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
    swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换

    Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
    Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回
    给定集合中的最大元素
    Object min(Collection)
    Object min(Collection，Comparator)
    int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
    void copy(List dest,List src)：将src中的内容复制到dest中
    boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换List 对象的所有旧值
     */
    @Test
    public void test(){
        List list=new ArrayList();
        list.add(123);
        list.add(456);
        list.add(-78);
        list.add(59);
        list.add(59);
        list.add(59);
        list.add(0);

        //Collections.reverse(list);
        //Collections.shuffle(list);
        //Collections.sort(list);
        //Collections.swap(list,1,2);
        //int frequency = Collections.frequency(list, 59);
        //System.out.println(frequency);
        System.out.println(list);
    }
    @Test
    public void tets1(){
        List list=new ArrayList();
        list.add(123);
        list.add(456);
        list.add(-78);
        list.add(59);
        list.add(0);

//        报异常：IndexOutOfBoundsException: Source does not fit in dest
//        List dest=new ArrayList(list.size());
//        Collections.copy(dest,list);

        List dest= Arrays.asList(new Object[list.size()]);
        Collections.copy(dest,list);
        System.out.println(dest.size());
        System.out.println(dest);

    }
}
