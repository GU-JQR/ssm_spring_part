package com.squ.factory;

import com.squ.entity.Dog;

/**
 * 宠物工厂
 */
public class PeiFactory {
    public Dog getPet(){
        return new Dog();
    }
}
