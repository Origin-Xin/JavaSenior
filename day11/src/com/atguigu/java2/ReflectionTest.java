package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Tonny
 * @version 2021.2
 * @date 2022/6/15 10:31
 */
public class ReflectionTest {
    /*
    不需要掌握
     */
    @Test
    public void test() throws Exception {
        Class<Person> clazz = Person.class;

        //创建运行时类的对象
        Person person = (Person) clazz.newInstance();

        //获取指定的属性:要求运行时类中声明的属性为public
        Field id = clazz.getField("id");

        /*
        设置当前属性的值

        set():参数1：指明设置哪个对象的属性   参数2：将此属性值设置为多少

         */
        id.set(person,1001);

        /*
        获取当前属性的值
        get():参数1：获取哪个对象的当前属性值
         */
        int pid= (int) id.get(person);
        System.out.println(pid);

    }
    /*
    如何操作运行时类中的指定的属性--需要掌握
     */
    @Test
    public void test2() throws Exception {
        Class<Person> clazz = Person.class;

        //创建运行时类的对象
        Person person = (Person) clazz.newInstance();
        //1.getDeclaredField(String fieldName):获取运行时类中指定变量名的属性
        Field name = clazz.getDeclaredField("name");
        //2.保证当前属性是可访问的
        name.setAccessible(true);
        //3.获取，设置指定对象的此属性值
        name.set(person,"张三");
        System.out.println(name.get(person));
    }
    /*
    如何操作运行时类中的指定的方法 --需要掌握
     */
    @Test
    public void test3() throws Exception {
        Class<Person> clazz = Person.class;
        //1.创建运行时类的对象
        Person person =(Person) clazz.newInstance();
        /*
        1.获取某个指定的方法
        getDeclaredMethod():参数1:指明获取方法的名称   参数2：指明获取的方法的形参列表
         */
        Method show = clazz.getDeclaredMethod("show", String.class);
        //2.保证当前方法时可以访问的
        show.setAccessible(true);
        /*
        3.调用方法的invoke():参数1:方法的调用者  参数2:给方法形参赋值实参
        invoke()的返回值即为对应类中调用的方法的返回值
         */
        Object returnValue = show.invoke(person, "CHN");//String str=p.show("CHNs");
        System.out.println(returnValue);

        System.out.println("********如何调用静态方法*********");

        //private static void showDesc()
        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        //如果调用的运行时类中的方法没有返回值,则此invoke()返回null
        //Object returnVal = showDesc.invoke(null);
        Object returnVal = showDesc.invoke(person);
        System.out.println(returnVal);//null

    }
    /*
    如何调用运行时类中的指定的构造器
     */
    @Test
    public void test4() throws Exception {
        Class<Person> clazz = Person.class;
        //private Person(String name)
        /*
        1.获取指定的构造器
        getDeclaredConstructor()参数：指明构造器的参数列表
         */
        Constructor<Person> Constructor = clazz.getDeclaredConstructor(String.class);
        //2.保证此构造器时可访问的
        Constructor.setAccessible(true);
        //3.调用此构造器创建运行时类的对象
        Person per = (Person) Constructor.newInstance("Tom");
        System.out.println(per);
    }
}
