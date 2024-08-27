package com.squ.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 人类 (姓名 年龄 身高 体重 性别)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean{
    private String name;
    private Integer age;
    private Integer height;
    private Integer weight;
    private  String gender;
    //引用类型属性
    private Dog dog;

    public Person(String name, Integer age, Integer height, Integer weight, String gender) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
    }

    //    进入spring容器的组件  都有生命周期 初始化-- 。。。 销毁
    //自定义一个组件初始化的方法
    public void init(){
        System.out.println("person被初始化...");
    }
    //自定义一个组件销毁的方法
     public void destory(){
         System.out.println("person被销毁...");
     }


    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext");
    }
}
