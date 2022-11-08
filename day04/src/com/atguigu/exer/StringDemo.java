package com.atguigu.exer;

import org.junit.Test;

/**
 * @author Tonny
 * @version 2021.2
 * @date 2022/5/14 10:19
 */
public class StringDemo {
   /*
   将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反转为”abfedcg”

   方法一：转换为char[]
   */
    public String reverse(String str,int startIndex,int endIndex){
        if (str!=null&&str.length()>0){
            char[] arr = str.toCharArray();
            for (int x=startIndex,y=endIndex;x<y;x++,y--){
                char temp=arr[x];
                arr[x]=arr[y];
                arr[y]=temp;
            }
            return new String(arr);
        }
        return null;
    }

    //方式二：使用String的拼接
    public String reverse1(String str,int startIndex,int endIndex){
       if (str!=null){
           //第一部分
           String reversestr=str.substring(0,startIndex);
           //第二部分
           for (int i=endIndex;i>=startIndex;i--){
               reversestr+=str.charAt(i);
           }
           //第三部分
           reversestr+=str.substring(endIndex+1);

           return reversestr;
       }
        return null;
    }
    //方法三：使用StringBuffer/StringBuilder替换String
    public String reverse2(String str,int startIndex,int endIndex){
        StringBuilder builder = new StringBuilder(str.length());
        //第一部分：
        builder.append(str.substring(0,startIndex));
        //第二部分：
        for (int i=endIndex;i>=startIndex;i--){
            builder.append(str.charAt(i));
        }
        //第三部分：
        builder.append(str.substring(endIndex+1));
        return null;
    }

    @Test
    public void testreverse(){
        String str="abcdefg";
        String reverse = reverse1(str, 2, 5);
        System.out.println(reverse);
    }
}
