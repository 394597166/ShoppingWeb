package com.cheer.shoppingwebgoodscollect.service.impl;

import com.cheer.shoppingwebgoodscollect.dao.GoodscollectMapper;
import com.cheer.shoppingwebgoodscollect.model.Goodscollect;
import com.cheer.shoppingwebgoodscollect.service.GoodscollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GoodscollectServiceImpl implements GoodscollectService {
    @Autowired
    private GoodscollectMapper goodscollectMapper;

    @Override
    public List<Goodscollect> selectGoodscollectAll(Integer userId){
        return this.goodscollectMapper.selectGoodscollectAll(userId);
    }

    @Override
    public Goodscollect selectGoodscollectAndgoodsIduserId(Integer goodsId,Integer userId){
        return this.goodscollectMapper.selectGoodscollectAndgoodsIduserId(goodsId,userId);
    }

    @Override
    public void deleteGoodscollectAndgoodscollectId(Integer goodscollectId){
        this.goodscollectMapper.deleteGoodscollectAndgoodscollectId(goodscollectId);
    }

    @Override
    public void insertGoodscollect(Integer goodscollectId,Integer goodsId,Integer userId){
        this.goodscollectMapper.insertGoodscollect(goodscollectId,goodsId,userId);
    }

}
