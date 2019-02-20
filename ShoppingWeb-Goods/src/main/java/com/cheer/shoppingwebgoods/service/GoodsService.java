package com.cheer.shoppingwebgoods.service;

import com.cheer.shoppingwebgoods.model.Goods;

import java.util.List;

public interface GoodsService {
    /**
     *  通过goodsId获得商品对象(商品已上架)
     * @param goodsId
     * @param goodsState
     * @return
     */
    Goods selectGoodsAndId(Integer goodsId,String goodsState);

    /**
     * 获得所有商品信息
     * @return
     */
    List<Goods> selectAllGoods(String goodsState);

    /**
     * 通过商品名称模糊查找所有商品对象
     * @param goodsName
     * @return
     */
    List<Goods> selectAllGoodsLikeName(String goodsName);

    /**
     * 更改商品状态
     * @param goodsId
     * @param goodsState
     */
    void updateGoods(Integer goodsId,String goodsState);

    /**
     * 添加商品
     * @param goodsId
     * @param goodsName
     * @param goodsSpecification
     * @param goodsDescribe
     * @param goodsPrice
     * @param goodsVipPrice
     * @param categoryId
     * @param subclassificationId
     * @param subseriesId
     * @param goodsState
     */
    void insertGoods(Integer goodsId,String goodsName,String goodsSpecification,String goodsDescribe,Double goodsPrice,Double goodsVipPrice,Integer categoryId,Integer subclassificationId,Integer subseriesId,String goodsState);


    /**
     * 获得所属分类商品
     * @param categoryId
     * @return
     */
    List<Goods> selectgoodsAndCategoryId(Integer categoryId);

    /**
     * 获得所属分类商品
     * @param subclassificationId
     * @return
     */
    List<Goods> selectgoodsAndsubclassificationId(Integer subclassificationId);

    /**
     * 获得所属分类商品
     * @param subseriesId
     * @return
     */
    List<Goods> selectgoodsAndsubseriesId(Integer subseriesId);
}
