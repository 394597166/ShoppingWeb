package com.cheer.shoppingwebgoods.dao;

import com.cheer.shoppingwebgoods.model.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {
    /**
     *  通过goodsId获得商品对象(商品已上架)
     * @param goodsId
     * @param goodsState
     * @return
     */
    Goods selectGoodsAndId(@Param("goodsId") Integer goodsId,@Param("goodsState")String goodsState);

    /**
     * 通过商品编号获得商品对象
     * @param goodsId
     * @return
     */
    Goods selectGoodsAndgoodsId(@Param("goodsId") Integer goodsId);

    /**
     * 获得所有商品信息
     * @return
     */
    List<Goods> selectAllGoods(@Param("goodsState")String goodsState);

    /**
     * 更改商品状态
     * @param goodsId
     * @param goodsState
     */
    void updateGoods(@Param("goodsId")Integer goodsId,@Param("goodsState")String goodsState);

    /**
     * 通过商品名称模糊查找所有商品对象
     * @param goodsName
     * @return
     */
    List<Goods> selectAllGoodsLikeName(@Param("goodsName")String goodsName);

    /**
     * 通过商品名称获得所有商品对象(商品已上架)
     * @param goodsName
     * @param goodsState
     * @return
     */
    List<Goods> selectAllGoodsAndName(@Param("goodsName")String goodsName,@Param("goodsState")String goodsState);

    /**
     * 通过商品分类获得所有商品对象(商品已上架)
     * @param categoryId
     * @param goodsState
     * @return
     */
    List<Goods> selectAllGoodsAndCategory(@Param("categoryId")Integer categoryId,@Param("goodsState")String goodsState);

    /**
     * 通过商品子分类获得所有商品对象(商品已上架)
     * @param subclassificationId
     * @param goodsState
     * @return
     */
    List<Goods> selectAllGoodsAndSubclassification(@Param("subclassificationId")Integer subclassificationId,@Param("goodsState")String goodsState);

    /**
     * 通过商品次分类获得所有商品对象(商品已上架)
     * @param subseriesId
     * @param goodsState
     * @return
     */
    List<Goods> selectAllGoodsAndSubseries(@Param("subseriesId")Integer subseriesId,@Param("goodsState")String goodsState);

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
    void insertGoods(@Param("goodsId")Integer goodsId,@Param("goodsName")String goodsName,@Param("goodsSpecification")String goodsSpecification,@Param("goodsDescribe")String goodsDescribe,@Param("goodsPrice")Double goodsPrice,@Param("goodsVipPrice")Double goodsVipPrice,@Param("categoryId")Integer categoryId,@Param("subclassificationId")Integer subclassificationId,@Param("subseriesId")Integer subseriesId,@Param("goodsState")String goodsState);

    /**
     * 获得所属分类商品
     * @param categoryId
     * @return
     */
    List<Goods> selectgoodsAndCategory(@Param("categoryId")Integer categoryId,@Param("subclassificationId")Integer subclassificationId,@Param("subseriesId")Integer subseriesId);
}
