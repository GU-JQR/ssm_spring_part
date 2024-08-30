package com.squ.config;

import com.squ.entity.Cat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

/**
 * spring新版本中可以通过编写配置类的方式 实现依赖注入+bean创建过程
 * conger脱离xml配置
 * @Configuration: 表示当前类是一个配置类,替代application.xml文件
 * @PropertySource: 引入外部配置
 * @ComponentScan:
 */
@Configuration
@PropertySource("classpath:data.properties")
@ComponentScan(basePackages = {"com.squ"})
public class JavaConfig {
    //在配置类中创建Bean组件放到 spring容器

    /**
     * 1.返回值是需要创建Bean的类型
     * 2.需要在方法上面添加@Bean注解
     * 3.参数值可以通过外部文件获取
     */
    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Cat createCat(@Value("${c.nickname}")String nickname,@Value("${c.color}")String color){
        //实例化组件
        Cat cat=new Cat();
        cat.setColor(color);
        cat.setNickname(nickname);
        return cat;
    }
}
