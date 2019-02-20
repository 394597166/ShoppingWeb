package com.cheer.shoppingwebgoods.dao;

import com.cheer.shoppingwebgoods.model.Picturegoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PicturegoodsMapper {
    /**
     * 通过商品编号获得所有商品详细图片
     * @param goodsId
     * @return
     */
    List<Picturegoods> selectPicturegoodsAndgoodsId(@Param("goodsId") Integer goodsId);
}
