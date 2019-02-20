package com.cheer.shoppingwebcart.service;

import com.cheer.shoppingwebcart.model.Cart;

import java.util.List;

public interface CartService {
    /**
     * 获得所有购物车对象
     * @param userId
     * @return
     */
    List<Cart> selectCartAll(Integer userId);

    /**
     * 获得单个购物车对象
     * @param userId
     * @param goodsId
     * @return
     */
    Cart selectCartOne(Integer userId,Integer goodsId,Integer inventoryId);

    /**
     * 删除单个购物车对象
     * @param cartId
     */
    void deleteCart(Integer cartId);

    /**
     * 修改单个购物车对象的商品数量
     * @param cartId
     * @param cartCount
     */
    void updateCartCount(Integer cartId,Integer cartCount);

    /**
     * 添加单个购物车对象
     * @param cartId
     * @param cartCount
     * @param goodsId
     * @param userId
     */
    void insertCart(Integer cartId,Integer cartCount,Integer goodsId,Integer inventoryId,Integer userId);
}
