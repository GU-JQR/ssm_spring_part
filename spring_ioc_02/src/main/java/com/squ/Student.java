package com.squ;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//ctrl + o 查看类结构
/*
  @data注解:包含了所有getter和setter方法以及 无参构造+tostring
  @ALlArgsConstructor注解:全部参数的构造方法
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String stuno;
    private String stuname;
    private Integer age;
    private String gender;

    //自定义方法
    public void dowork(){
        System.out.println("努力工作,好好赚钱");
    }

}
