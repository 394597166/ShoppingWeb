package com.cheer.shoppingwebgoods.dao;

import com.cheer.shoppingwebgoods.model.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PictureMapper {
    /**
     * 通过商品编号获得所有商品图片
     * @param goodsId
     * @return
     */
    List<Picture> selectPictureAndgoodsId(@Param("goodsId") Integer goodsId);
}
