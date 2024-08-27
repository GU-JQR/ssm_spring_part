package com.squ.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Collection {
    private String[] arrs;
    private List<String> list;
    private Set<String> set;
    private Map<String,String> map;
    private Properties properties;

    private Map<String,Dog> pets;//宠物集合
}
