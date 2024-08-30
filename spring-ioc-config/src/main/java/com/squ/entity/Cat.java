package com.squ.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 实体类 Cat
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cat {
    private String nickname;
    private String color;
    private String age;
}
