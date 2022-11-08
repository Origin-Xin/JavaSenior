package com.atguigu.exer;

/**
 * @author Tonny
 * @version 2021.2
 * @date 2022/5/10 22:19
 */
public class StringTest {
    String str = new String("good");
    char[] ch = { 't', 'e', 's', 't' };
    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'b';
    }
    public static void main(String[] args) {
        StringTest ex = new StringTest();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str);//
        System.out.println(ex.ch);//
    }
}

