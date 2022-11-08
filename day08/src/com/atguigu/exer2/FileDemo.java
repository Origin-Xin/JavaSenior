package com.atguigu.exer2;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author Tonny
 * @version 2021.2
 * @date 2022/5/31 12:18
 */
public class FileDemo {
    @Test
    public void test() throws IOException {
        File file=new File("D:\\user\\io2\\hello.txt");
        File file1=new File(file.getParent(),"hi.txt");
        boolean newFile = file1.createNewFile();
        if (newFile){
            System.out.println("创建成功");
        }
    }
}
