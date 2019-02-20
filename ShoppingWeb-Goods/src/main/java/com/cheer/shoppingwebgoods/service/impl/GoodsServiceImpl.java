package com.cheer.shoppingwebgoods.service.impl;

import com.cheer.shoppingwebgoods.dao.GoodsMapper;
import com.cheer.shoppingwebgoods.model.Goods;
import com.cheer.shoppingwebgoods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Goods selectGoodsAndId(Integer goodsId,String goodsState){
        return this.goodsMapper.selectGoodsAndId(goodsId,goodsState);
    }

    @Override
    public List<Goods> selectAllGoods(String goodsState){
        return this.goodsMapper.selectAllGoods(goodsState);
    }

    @Override
    public List<Goods> selectAllGoodsLikeName(String goodsName){
        return this.goodsMapper.selectAllGoodsLikeName(goodsName);
    }

    @Override
    public void updateGoods(Integer goodsId,String goodsState){
        this.goodsMapper.updateGoods(goodsId,goodsState);
    }

    @Override
    public void insertGoods(Integer goodsId,String goodsName,String goodsSpecification,String goodsDescribe,Double goodsPrice,Double goodsVipPrice,Integer categoryId,Integer subclassificationId,Integer subseriesId,String goodsState){
        this.goodsMapper.insertGoods(goodsId,goodsName,goodsSpecification,goodsDescribe,goodsPrice,goodsVipPrice,categoryId,subclassificationId,subseriesId,goodsState);
    }

    @Override
    public List<Goods> selectgoodsAndCategoryId(Integer categoryId){
        return this.goodsMapper.selectgoodsAndCategory(categoryId,null,null);
    }

    @Override
    public List<Goods> selectgoodsAndsubclassificationId(Integer subclassificationId){
        return this.goodsMapper.selectgoodsAndCategory(null,subclassificationId,null);
    }

    @Override
    public List<Goods> selectgoodsAndsubseriesId(Integer subseriesId){
        return this.goodsMapper.selectgoodsAndCategory(null,null,subseriesId);
    }

}
