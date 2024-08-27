package com.squ.factory;

import com.squ.entity.MoonCake;

public class FoodFactory {
    public static MoonCake getInstance(){
        return new MoonCake();
    }
}
