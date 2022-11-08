package com.atguigu.java;

/**
 *
 * 使用enum关键字定义的枚举类
 * 说明：定义的枚举类默认继承于java.lang.Enum类
 * @author Tonny
 * @version 2021.2
 * @date 2022/5/16 11:29
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 sunmer = Season1.SUNMER;
        //toString();
        System.out.println(sunmer.toString());
        System.out.println("**************");
        //values();
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
            values[i].show();
        }
        System.out.println("**************");
        Thread.State[] values1 = Thread.State.values();
        for (int i = 0; i < values1.length; i++) {
            System.out.println(values1[i]);
        }
        //valueOf(String objName):返回枚举类中对象名是objName的对象
        //如果没有objName的枚举类对象，则抛异常IllegalArgumentException
        //Season1 spring = Season1.valueOf("SPRING1");
        Season1 spring = Season1.valueOf("SPRING");
        System.out.println(spring);
//        System.out.println(Season1.class.getSuperclass());
    }
}
interface Info{
    void show();
}
//自定义枚举类
enum Season1 implements  Info{
    //3.提供当前枚举类的多个对象，多个对象之间用“,”隔开，末尾“;”结束
    SPRING("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("春天在哪里");
        }
    },
    SUNMER("夏天","夏日炎炎"){
        @Override
        public void show() {
            System.out.println("宁静的夏天");
        }
    },
    AUTUMN("秋天","秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天不回来");
        }
    },
    WINTER("冬天","冰天雪地"){
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };
    //1.声明Season对象的属性：private final修饰
    private final String seasonName;
    private final String seasonDesc;
    //2.私有化类的构造器，并给对象属性赋值
    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //其他诉求1：

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    /*
    其他诉求2：
    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }*/

//    @Override
//    public void show() {
//
//    }
}

