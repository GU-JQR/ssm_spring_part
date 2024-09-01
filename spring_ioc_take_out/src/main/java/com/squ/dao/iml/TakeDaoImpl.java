package com.squ.dao.iml;

import com.squ.dao.TakeDao;
import com.squ.entity.Take;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("TakeDao")
public class TakeDaoImpl implements TakeDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public TakeDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public TakeDaoImpl() {
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Take> queryAll() {
        String sql="SELECT * FROM users;";
        List<Take> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Take.class));
        return query;
    }

    @Override
    public int addOne(Take take) {
        String sql=" INSERT INTO users (UserID,Username,UserAddress,UserPassword,UserPhone) VALUES (?,?,?,?,?);";
        int row=jdbcTemplate.update(sql,take.getUserID(),take.getUserName(),take.getAddress(),take.getPassword(),take.getUserPhone());
        return row;
    }
}
