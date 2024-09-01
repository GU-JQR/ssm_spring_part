package com.squ.controller;

import com.squ.entity.Take;
import com.squ.service.TakeService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Controller("controller")
public class TakeController {
    private TakeService takeService;

    public TakeController(TakeService takeService) {
        this.takeService = takeService;
    }

    public TakeController() {
    }

    public TakeService getTakeService() {
        return takeService;
    }

    public void setTakeService(TakeService takeService) {
        this.takeService = takeService;
    }

    public void queryAll(){
        List<Take> query = takeService.query();
        for (Take take : query) {
            System.out.println(take);
        }
    }

    public void addOne(){
        String replace = UUID.randomUUID().toString().replace("-", "");
        Take take = new Take(replace,"jqr","徐州","123456","18611111111");
        int i = takeService.addOne(take);
        System.out.println(i==0?"添加失败":"添加成功");
    }
}
