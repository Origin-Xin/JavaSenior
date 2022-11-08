package com.atguigu.java;

import org.junit.Test;

/**
 * @author Tonny
 * @version 2021.2
 * @date 2022/5/14 14:41
 */
public class IDEADebug {
    @Test
    public void testStringBuffer(){
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        System.out.println(sb.length());//
        System.out.println(sb);//
        StringBuffer sb1 = new StringBuffer(str);
        System.out.println(sb1);//
    }
}
