package com.squ.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 人类 (姓名 年龄 身高 体重 性别)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private Integer age;
    private Integer height;
    private Integer weight;
    private  String gender;

//    进入spring容器的组件  都有生命周期 初始化-- 。。。 销毁
    //自定义一个组件初始化的方法
    public void init(){
        System.out.println("person被初始化...");
    }
    //自定义一个组件销毁的方法
     public void destory(){
         System.out.println("person被销毁...");
     }


}
