package com.atguigu.java1;

import java.util.Date;

/**
 * 注解的使用
 *
 * 一.理解Annotation：
 * 1.jdk 5.0 新增功能
 *
 * 2.Annotation 其实就是代码里的特殊标记, 这些标记可以在编译, 类加
 * 载, 运行时被读取, 并执行相应的处理。通过使用 Annotation, 程序员
 * 可以在不改变原有逻辑的情况下, 在源文件中嵌入一些补充信息。
 *
 * 3.在JavaSE中，注解的使用目的比较简单，例如标记过时的功能，
 * 忽略警告等。在JavaEE/Android中注解占据了更重要的角色，例如
 * 用来配置应用程序的任何切面，代替JavaEE旧版中所遗留的繁冗
 * 代码和XML配置等。
 *
 * 二.Annotation的使用示例
 * 示例一：生成文档相关的注解
 * 示例二：在编译时进行格式检查(JDK内置的三个基本注解)
 * @Override: 限定重写父类方法, 该注解只能用于方法
 * @Deprecated: 用于表示所修饰的元素(类, 方法等)已过时。通常是因为所修饰的结构危险或存在更好的选择
 * @SuppressWarnings: 抑制编译器警告
 * 示例三：跟踪代码依赖性，实现替代配置文件功能
 *
 * 3.如何自定义注解：参照@SuppressWarnings定义
 *      *1 注解声明为：@interface
 *      *2 内部定义成员，通常使用value表示
 *      *3 可以指定成员的默认值，使用default定义
 *      *4 如果自定义注解没有成员，表面一个标识作用
 *
 *      如果注解有成员，在使用注解时，需要指明成员的值
 *      自定义注解必须配上注解的信息处理流程(使用反射)才有意义。
 *      自定义注解通过都会指明两个元注解：Retention,Target
 *
 * 4.jdk 提供的4种元注解
 *  元注解：对现有的注解进行解释说明的注解
 *  Retention：指定所修饰的Annotation的生命周期：SOURCE/CLASS(默认行为)/RUNTIME
 *  只有声明为RUNTIME生命周期的注解，才能通过反射获取。
 *  Target：用于修饰 Annotation 定义, 用于指定被修饰的 Annotation 能用于
 * 修饰哪些程序元素。 @Target 也包含一个名为 value 的成员变量。
 *  Documented:: 用于指定被该元 Annotation 修饰的 Annotation 类将被
 * javadoc 工具提取成文档。默认情况下，javadoc是不包括注解的。
 *  Inherited:: 被它修饰的 Annotation 将具有继承性。
 *
 *  5.jdk 8 中注解的新特性：可重复注解，类型注解
 *
 *  5.1 可重复注解：1.在MyAnnotation上声明@Repeatable,成员值为MyAnnotations.Class
 *                2.MyAnnotation的Target和Retention和MyAnnotations相同
 *  5.2类型注解：1.ElementType.TYPE_PARAMETER 表示该注解能写在类型变量的声明语
 *  句中（如：泛型声明）。
 *              2.ElementType.TYPE_USE 表示该注解能写在使用类型的任何语句中。
 *
 * @author Tonny
 * @version 2021.2
 * @date 2022/5/17 10:15
 */
public class AnnotationTest {
    public static void main(String[] args) {
        Person person = new Student();
        person.walk();
    }
}
//jdk 8 之前的写法：
//@MyAnnotation({@MyAnnotation(value = "hi"),@MyAnnotation(value = "abc"))
//@MyAnnotation(value = "hi")
//@MyAnnotation(value = "abc")



class  Person{
    private String name;
    private int age;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void walk(){
        System.out.println("人走路");
    }
    public void eat(){
        System.out.println("人吃饭");
    }

}
interface Inof{
    void show();
}
class Student extends Person implements Inof{

    @Override
    public void walk() {
        System.out.println("学生走路");
    }
    @Override
    public void show() {

    }
}
