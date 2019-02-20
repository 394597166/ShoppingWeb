package com.cheer.shoppingwebcart.dao;

import com.cheer.shoppingwebcart.model.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {
    /**
     * 获得所有购物车对象
     * @param userId
     * @return
     */
    List<Cart> selectCartAll(@Param("userId")Integer userId);

    /**
     * 获得单个购物车对象
     * @param userId
     * @param goodsId
     * @return
     */
    Cart selectCartOne(@Param("userId")Integer userId,@Param("goodsId")Integer goodsId,@Param("inventoryId")Integer inventoryId);

    /**
     * 删除单个购物车对象
     * @param cartId
     */
    void deleteCart(@Param("cartId")Integer cartId);

    /**
     * 修改单个购物车对象的商品数量
     * @param cartId
     * @param cartCount
     */
    void updateCartCount(@Param("cartId")Integer cartId,@Param("cartCount")Integer cartCount);

    /**
     * 添加单个购物车对象
     * @param cartId
     * @param cartCount
     * @param goodsId
     * @param userId
     */
    void insertCart(@Param("cartId")Integer cartId,@Param("cartCount")Integer cartCount,@Param("goodsId")Integer goodsId,@Param("inventoryId")Integer inventoryId,@Param("userId")Integer userId);
}
