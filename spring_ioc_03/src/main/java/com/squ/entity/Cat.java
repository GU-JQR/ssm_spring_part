package com.squ.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 人的宠物 猫
 * @component 注解相当于在spring容器中创建了对应bean实例
 * 需要:在spring配置文件中添加注解扫描,扫描指定包下面的类,发现类上面存在可识别的注解的时候,就做响相应的处理
 * @Value 注解用于基本属性赋值 不包含引用类型
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component(value = "cat1")
public class Cat {
    @Value("${c.nickname}")
    private String nickname;
    @Value("${c.color}")
    private String color;
}
