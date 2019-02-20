package com.cheer.shoppingwebgoodscollect.dao;

import com.cheer.shoppingwebgoodscollect.model.Goodscollect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodscollectMapper {
    /**
     * 通过用户编号获得所有收藏商品
     * @param userId
     * @return
     */
    List<Goodscollect> selectGoodscollectAll(@Param("userId")Integer userId);

    /**
     * 通过用户编号和商品编号获得收藏商品
     * @param goodsId
     * @param userId
     * @return
     */
    Goodscollect selectGoodscollectAndgoodsIduserId(@Param("goodsId")Integer goodsId,@Param("userId")Integer userId);

    /**
     * 通过商品收藏编号删除商品收藏
     * @param goodscollectId
     */
    void deleteGoodscollectAndgoodscollectId(@Param("goodscollectId")Integer goodscollectId);

    /**
     * 添加商品收藏
     * @param goodscollectId
     * @param goodsId
     * @param userId
     */
    void insertGoodscollect(@Param("goodscollectId")Integer goodscollectId,@Param("goodsId")Integer goodsId,@Param("userId")Integer userId);
}
