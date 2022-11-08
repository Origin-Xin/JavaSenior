package com.atguigu.exer;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 创建该类的 5 个对象，并把这些对象放入 TreeSet 集合中（下一章：
 * TreeSet 需使用泛型来定义）
 * 分别按以下两种方式对集合中的元素进行排序，并遍历输出：
 * 1). 使 Employee 实现 Comparable 接口，并按 name 排序
 * 2). 创建 TreeSet 时传入 Comparator 对象，按生日日期的先后排序
 * @author Tonny
 * @version 2021.2
 * @date 2022/5/26 9:44
 */
public class EmployeeTest {
    //按 name 排序
    @Test
    public void test1(){
        TreeSet set = new TreeSet();

        Employee e1=new Employee("张三",18,new MyDate(1999,10,1));
        Employee e2=new Employee("李四",20,new MyDate(1989,5,2));
        Employee e3=new Employee("王五",36,new MyDate(1967,12,1));
        Employee e4=new Employee("老六",66,new MyDate(1911,6,6));
        Employee e5=new Employee("赵七",22,new MyDate(1993,5,9));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    //按生日日期的先后排序
    @Test
    public void test2() {
        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee) {
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;

                    MyDate b1 = e1.getBirthday();
                    MyDate b2 = e1.getBirthday();
                    //比较年
                    int minYear = b1.getYear() - b2.getYear();
                    if (minYear!=0){
                        return minYear;
                    }
                    //比较月
                    int minMonth = b1.getMonth() - b2.getMonth();
                    if (minMonth!=0){
                        return minMonth;
                    }
                    //比较日
                    return b1.getDay()-b2.getDay();
                }
                throw new RuntimeException("输入数据类型不一致");
            }
        };
        TreeSet set = new TreeSet();

        Employee e1=new Employee("张三",18,new MyDate(1999,10,1));
        Employee e2=new Employee("李四",20,new MyDate(1989,5,2));
        Employee e3=new Employee("王五",36,new MyDate(1967,12,1));
        Employee e4=new Employee("老六",66,new MyDate(1911,6,6));
        Employee e5=new Employee("赵七",22,new MyDate(1993,5,9));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
