package com.squ.controller;

import com.squ.entity.Food;
import com.squ.service.FoodService;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FoodController {
    private FoodService service;

    public FoodController(FoodService service) {
        this.service = service;
    }

    public FoodController() {
    }

    public FoodService getService() {
        return service;
    }

    public void setService(FoodService service) {
        this.service = service;
    }


    public void queryAllTest(){
        List<Food> foodli=service.findAll();

        for (int i = 0; i < foodli.size(); i++) {
            System.out.println(foodli.get(i).toString());
        }
    }
}
