package com.squ.service.Impl;

import com.squ.dao.FoodDao;
import com.squ.entity.Food;
import com.squ.service.FoodService;

import java.util.List;

/**
 * 食品业务实现表
 */
public class FoodServiceImpl implements FoodService {
    //业务需要注入dao层操作对象
    private FoodDao dao;

    //构造注入
    public FoodServiceImpl(FoodDao dao) {
        this.dao = dao;
    }

    public FoodServiceImpl() {
    }

    //设值注入
    public FoodDao getDao() {
        return dao;
    }

    public void setDao(FoodDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Food> findAll() {
        return dao.queryAll();
    }
}
