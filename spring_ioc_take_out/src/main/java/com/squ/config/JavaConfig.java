package com.squ.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.squ.controller.TakeController;
import com.squ.dao.TakeDao;
import com.squ.dao.iml.TakeDaoImpl;
import com.squ.service.Impl.TakeServiceImpl;
import com.squ.service.TakeService;
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
    @Bean("jdbcTemplate")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public JdbcTemplate createTemplate(DruidDataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }
    @Bean("takeDao")
    public TakeDao createTakeDao(JdbcTemplate jdbcTemplate){
        TakeDaoImpl takeDao = new TakeDaoImpl();
        takeDao.setJdbcTemplate(jdbcTemplate);
        return takeDao;

    }

    @Bean("takeService")
    public TakeService createTakeService(TakeDao takeDao){
        TakeServiceImpl takeService = new TakeServiceImpl();
        takeService.setTakeDao(takeDao);
        return takeService;
    }

    @Bean("controller")
    public TakeController creakeTakeController (TakeService service){
        TakeController takeController = new TakeController();
        takeController.setTakeService(service);
        return takeController;
    }


}
