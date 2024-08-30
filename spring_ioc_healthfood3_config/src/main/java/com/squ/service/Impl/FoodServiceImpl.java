package com.squ.service.Impl;

import com.squ.dao.FoodDao;
import com.squ.entity.Food;
import com.squ.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 食品业务实现表
 */
@Service("foodService")
public class FoodServiceImpl implements FoodService {
    //业务需要注入dao层操作对象
    @Autowired
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

    //查询全部业务
    @Override
    public List<Food> findAll() {
        return dao.queryAll();
    }

    //添加一条业务
    @Override
    public int addOne(Food food) {
        return dao.addOne(food);
    }

    @Override
    public Food queryOne(int id) {
        return dao.queryone(id);
    }
}
