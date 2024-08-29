package com.squ.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Person {
    @Value("jqr")
    private String name;
    @Value("20")
    private Integer age;
//    @Autowired自动装配注解:将spring容器中已经存在的实例,注入到指定内容
//    以上针对同类型的实例,如果在spring容器中存在多个同类的实例,如何区分
    //@Resource:可以荣国name指定是注入哪一个具体的bean组件
//    @Autowired
    @Resource(name="createCat")
    private Cat cat;

}
