package com.atguigu.exer;

import org.junit.Test;

/**
 * @author Tonny
 * @version 2021.2
 * @date 2022/5/14 12:28
 */
public class StringDemo2 {
    /*
    获取两个字符串中最大相同子串。
    比如：str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"
    提示：将短的那个串进行长度依次递减的子串与较长的串比较。
    */

    public String getMaxSameString(String str1,String str2){
        if (str1!=null && str2!=null){
            String maxstr=(str1.length()>=str2.length())?str1:str2;
            String minstr=(str1.length()<str2.length())?str1:str2;
            int length=minstr.length();
            for (int i=0;i<length;i++){
                for (int x=0,y=length-i;y<=length;x++,y++){
                    String subStr=minstr.substring(x,y);
                    if (maxstr.contains(subStr)){
                        return subStr;
                    }
                }
            }
        }
        return null;
    }
    @Test
    public void testGetMaxSameString(){
        String str1 ="abcwerthelloyuiodef";
        String str2="cvhellobnm";
        String maxSameString = getMaxSameString(str1, str2);
        System.out.println(maxSameString);
    }
    /*for (int i = 0; i < length; i++) {
        for (int x=0,y=length-i;y<=length;x++,y++){
            String subStr=minstr.substring(x,y);
            if (maxstr.contains(subStr)){
                return subStr;
            }
        }
    }*/
}
