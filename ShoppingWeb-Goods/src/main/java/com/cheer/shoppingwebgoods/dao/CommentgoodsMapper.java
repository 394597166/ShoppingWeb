package com.cheer.shoppingwebgoods.dao;

import com.cheer.shoppingwebgoods.model.Commentgoods;
import com.cheer.shoppingwebgoods.model.Picturegoods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentgoodsMapper {
    /**
     * 通过商品编号获得商品评论
     * @param goodsId
     * @return
     */
    List<Commentgoods> selectCommentgoodsAndgoodsId(@Param("goodsId") Integer goodsId);
}
