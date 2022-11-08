package com.atguigu.java1;

import java.io.Serializable;

/**
 * @author Tonny
 * @version 2021.2
 * @date 2022/6/14 18:17
 */
public class Creature<T> implements Serializable{
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }

    public void eat(){
        System.out.println("生物吃东西");
    }
}
