package com.squ.controller;

import com.squ.entity.Food;
import com.squ.service.FoodService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller("controller")
public class FoodController {
    @Autowired
    private FoodService service;

//    public FoodController(FoodService service) {
//        this.service = service;
//    }
//
//    public FoodController() {
//    }
//
//    public FoodService getService() {
//        return service;
//    }
//
//    public void setService(FoodService service) {
//        this.service = service;
//    }


    public void queryAllTest(){
        List<Food> foodli=service.findAll();

        for (int i = 0; i < foodli.size(); i++) {
            System.out.println(foodli.get(i).toString());
        }


    }
    public  void addOne(){
        Food food = new Food( "青岛", "海鲜", "青岛啤酒");
        int i = service.addOne(food);
        if(i==1){
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
    }

    public void queryOne(){
        Food food = service.queryOne(2);
        System.out.println(food.toString());
    }
}
