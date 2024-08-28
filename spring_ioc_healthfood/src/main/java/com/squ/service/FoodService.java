package com.squ.service;

import com.squ.entity.Food;

import java.util.List;

/**
 *食品业务接口
 *1.获取食品全部信息
 * 2.添加食品
 *
 */
public interface FoodService {
    List<Food> findAll();//
}
