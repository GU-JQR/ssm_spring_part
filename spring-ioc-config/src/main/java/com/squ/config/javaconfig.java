package com.squ.config;

import com.squ.entity.Cat;
import com.squ.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

/**
 * 配置类:
 * 1.可以去除xml文件配置
 * 2.可以在配置类中扫描包注解
 * 3.可以在配置类中读取外部文件
 * 4.可以在配置类中创建Bean实例 (引入外部插件) JDBCTemplate DATASource
 *
 * @configuration : 表名是一个配置类
 * @ComponentScan : 扫描指定包中的配置注解
 * @PropertySource : 引入外部资源文件
 * @Bean : 创建bean实例在容器中
 * @Value : 引入外部资源文件值给,属性|参数
 * @scope : 设值注入bean实例是单例还是prototype
 * @Import : 引入其他配置类
 */
@Import(value = JavaConfig2.class)
@Configuration
@ComponentScan(value = {"com.squ"})
@PropertySource(value = "classpath:data.properties",encoding = "utf-8")
public class javaconfig {
    //在属性上获取外部文件值
    @Value("${cat.nickname}")
//    private String nickname;
    //将cat的bean实例在spring容器中创建
    /**
     * 1.定义方法 方法返回值类型 等同于cat
     * 2.方法上面添加@Bean注解
     * 3.在方法里面创建cat的实例,设置相关属性并返回
     * 4.一般从外部资源文件获取属性的值 使用@value注解,该注解可以添加在filed,args上
     * 使用${}读取配置文件对应的key值
     * 5.从配置类创建的bean实例 名称默认是方法名 可以修改
     */
    @Bean(value = "cat")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Cat createCat(@Value("${cat.nickname}")String nickname,
                         @Value("${cat.color}")String color,
                         @Value("${cat.age} ")String age){
        Cat cat = new Cat();
        cat.setNickname(nickname);
        cat.setColor(color);
        cat.setAge(age);
        return cat;
    }
    @Bean(value = "cat2")
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Cat createCat2(@Value("${cat.nickname2}")String nickname,
                          @Value("${cat.color2}")String color,
                         @Value("${cat.age2} ")String age){
        Cat cat = new Cat();
        cat.setNickname(nickname);
        cat.setColor(color);
        cat.setAge(age);
        return cat;
    }

    /**
     * 创建person类的实例
     * 1.提供方法的参数,参数类型cat,容器会根据类型自动装配
     * 2.注入根据spring容器中存在的bean名称+类型自动匹配,如果存在多个同类型的实例
     *  需要荣国注解限定@Autowired @Qualifier(value="cat")
     * @Autowired 代表按照类型注入
     * @Qualifier
     */

    @Bean(value = "person")
    public Person createPerson(@Value("${person.name}") String name,
                               @Value("${person.gender}") String gender,
                               @Autowired @Qualifier (value="cat2") Cat cat){
        Person person=new Person();
        person.setName(name);
        person.setGender(gender);
        person.setCat(cat);
        return person;

    }
}
