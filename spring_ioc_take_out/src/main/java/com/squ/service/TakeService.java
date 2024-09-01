package com.squ.service;

import com.squ.entity.Take;

import java.util.List;

public interface TakeService {
    List<Take> query();

    int addOne(Take take);
}
