package com.squ.config;

import com.squ.entity.Dog;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(value = {"com.squ"})
@PropertySource(value = "classpath:data.properties",encoding = "utf-8")
public class JavaConfig2 {

    public Dog createDog(@Value("${dao.type}")String type,
                         @Value("${dog.price}")String price){
        Dog dog=new Dog();
        dog.setType(type);
        dog.setPrice(price);
        return dog;
    }
}
