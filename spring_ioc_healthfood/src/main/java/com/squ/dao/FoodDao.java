package com.squ.dao;

import com.squ.entity.Food;

import java.util.List;

/**
 * 定义食品的接口
 * 1.查询全部食品方法
 * 2.增加食品
 * 3.删除食品
 *
 */
public interface FoodDao {
    List<Food> queryAll();//查询全部
}
