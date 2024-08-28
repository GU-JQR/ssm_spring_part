package com.squ.dao.iml;

import com.squ.dao.FoodDao;
import com.squ.entity.Food;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.swing.*;
import java.util.List;

/**
 * 实现接口方法
 */

public class FoodDaoImpl implements FoodDao {
    //依赖JdbcTemplate工具操作数据库 maven中引入依赖
    private JdbcTemplate jdbcTemplate;
//    构造注入
    public FoodDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public FoodDaoImpl() {
    }

    //设值注入
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //查询全部
    @Override
    public List<Food> queryAll() {
        String sql="SELECT * FROM food;";
        List<Food> foodList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Food.class));
        return foodList;
    }
}
