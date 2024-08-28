package com.squ.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 健康饮食食品
 * (id,名称,不宜吃,描述)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food {
    private Integer id;
    private String foodname;
    private String noeat;
    private String fooddesc;
}
