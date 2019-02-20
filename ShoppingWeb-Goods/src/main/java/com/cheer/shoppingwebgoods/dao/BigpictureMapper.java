package com.cheer.shoppingwebgoods.dao;

import com.cheer.shoppingwebgoods.model.Bigpicture;
import com.cheer.shoppingwebgoods.model.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BigpictureMapper {
    /**
     * 通过商品编号获得所有商品图片
     * @param pictureId
     * @return
     */
    Bigpicture selectBigPictureAndPictureId(@Param("pictureId") Integer pictureId);
}
