package com.squ.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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
    @Autowired
    private Cat cat;

}
