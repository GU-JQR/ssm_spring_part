package com.squ.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dog {
    private String type;
    private String color;
    private Integer age;

    //自定义方法

    public void dowork(){
        System.out.println("wangwangwang~~~");
    }
}
