package com.squ.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.squ.controller.FoodController;
import com.squ.dao.FoodDao;
import com.squ.dao.iml.FoodDaoImpl;
import com.squ.service.FoodService;
import com.squ.service.Impl.FoodServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan(value = {"com.squ.dao","com.squ.service","com.squ.controller"})
@PropertySource(value = "classpath:database.properties",encoding = "utf-8")
public class JavaConfig {
    @Bean("dataSource")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public DruidDataSource createDataSource(@Value("${jqr.username}") String username,
                                            @Value("${jqr.password}") String password,
                                            @Value("${jqr.url}") String url,
                                            @Value("${jqr.driver}") String driverClassName){
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

    //jdbcTemplate实例 依赖注入德鲁伊数据源
    @Bean("jdbcTemplate")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public JdbcTemplate createTemplate(DruidDataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }

    //dao层实例 依赖注入jdbcTemplate对象
    @Bean("foodDao")
    public FoodDao createFoodDao(JdbcTemplate jdbcTemplate){
        FoodDaoImpl foodDao = new FoodDaoImpl();
        foodDao.setJdbcTemplate(jdbcTemplate);
        return foodDao;
    }

    //
    @Bean("fooService")
    public FoodService createFoodService(FoodDao foodDao){
        FoodServiceImpl foodService = new FoodServiceImpl();
        foodService.setDao(foodDao);
        return foodService;
    }
    //
    @Bean("controller")
    public FoodController createFoodController(FoodService foodService){
        FoodController controller = new FoodController();
        controller.setService(foodService);
        return controller;
    }
}
