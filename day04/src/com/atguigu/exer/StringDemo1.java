package com.atguigu.exer;

import org.junit.Test;

/**
 * @author Tonny
 * @version 2021.2
 * @date 2022/5/14 11:27
 */
public class StringDemo1 {
    /*
    获取一个字符串在另一个字符串中出现的次数。比如：获取“ ab”在 “abkkcadkabkebfkabkskab” 中出现的次数
    */
    public int getCount(String mainstr,String substr){
        int mainLength = mainstr.length();
        int subLength=substr.length();
        int count=0;
        int index=0;
        if (mainLength>=subLength){
            //方式一：
           /* while ((index=mainstr.indexOf(substr))!=-1){
                count++;
                mainstr=mainstr.substring(index+substr.length());
            }*/
            //方式二：方式一的改进
            while ((index=mainstr.indexOf(substr,index))!=-1) {
                count++;
                index+=subLength;
            }
            return count;
        }
        else {
            return 0;
        }
    }
    @Test
    public void testGetCount(){
        String mainstr="abkkcadkabkebfkabkskab";
        String substr="ab";

        int count = getCount(mainstr, substr);
        System.out.println(count);
    }
}
