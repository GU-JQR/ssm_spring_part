package com.squ.service.Impl;

import com.squ.dao.TakeDao;
import com.squ.entity.Take;
import com.squ.service.TakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("takeService")
public class TakeServiceImpl implements TakeService {

    @Autowired
    @Qualifier("takeDao")
    private TakeDao takeDao;

    public TakeServiceImpl(TakeDao takeDao) {
        this.takeDao = takeDao;
    }

    public TakeServiceImpl() {
    }

    public TakeDao getTakeDao() {
        return takeDao;
    }

    public void setTakeDao(TakeDao takeDao) {
        this.takeDao = takeDao;
    }

    @Override
    public List<Take> query() {
        return takeDao.queryAll();
    }

    @Override
    public int addOne(Take take) {
        return takeDao.addOne(take);
    }
}
