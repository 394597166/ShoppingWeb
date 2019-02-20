package com.cheer.shoppingwebgoodscollect.service;

import com.cheer.shoppingwebgoodscollect.model.Goodscollect;

import java.util.List;

public interface GoodscollectService {
    /**
     * 通过用户编号获得所有收藏商品
     * @param userId
     * @return
     */
    List<Goodscollect> selectGoodscollectAll(Integer userId);

    /**
     * 通过用户编号和商品编号获得收藏商品
     * @param goodsId
     * @param userId
     * @return
     */
    Goodscollect selectGoodscollectAndgoodsIduserId(Integer goodsId, Integer userId);

    /**
     * 通过商品收藏编号删除商品收藏
     * @param goodscollectId
     */
    void deleteGoodscollectAndgoodscollectId(Integer goodscollectId);

    /**
     * 添加商品收藏
     * @param goodscollectId
     * @param goodsId
     * @param userId
     */
    void insertGoodscollect(Integer goodscollectId,Integer goodsId,Integer userId);
}
