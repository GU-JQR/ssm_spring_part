package com.squ.dao;

import com.squ.entity.Take;

import java.util.List;

public interface TakeDao {
    List<Take> queryAll();

    int addOne(Take take);
}
