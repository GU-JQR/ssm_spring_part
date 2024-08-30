package com.squ.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 狗狗的类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dog {
    private String type;
    private String price;
}
