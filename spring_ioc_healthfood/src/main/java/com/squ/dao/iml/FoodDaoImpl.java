package com.squ.dao.iml;

import com.mysql.cj.protocol.Resultset;
import com.squ.dao.FoodDao;
import com.squ.entity.Food;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.*;
import java.sql.ResultSet;
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

    //添加一条
    @Override
    public int addOne(Food food) {
        String sql="INSERT INTO food (id,foodname,noeatfood,fooddesc)\n" +
                "VALUES (DEFAULT,?,?,?);";
        int row = jdbcTemplate.update(sql, food.getFoodname(), food.getNoeat(), food.getFooddesc());
        return row;
    }

    @Override
    public Food queryone(Integer id) {
        String sql ="SELECT * FROM food WHERE id = ?;";
        Food f= jdbcTemplate.queryForObject(sql, (ResultSet rs, int rowNum) -> {
            //中间这部分是将查询的数据库表中的一行映射成food类的一个对象实例
            // rs查询出来的结果集 可以通过它获取一行中的对应的数量
            Food food=new Food();
            food.setId(rs.getInt("id"));
            food.setFoodname(rs.getString("foodname"));
            food.setNoeat(rs.getString("noeatfood"));
            food.setFooddesc(rs.getString("fooddesc"));
            return food;
            },id);
        return f;
    }

}
