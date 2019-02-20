package com.cheer.shoppingwebcart.model;

import com.cheer.shoppingwebgoods.model.Goods;
import com.cheer.shoppingwebgoods.model.Inventory;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 购物车表
 */
//解决json序列化问题（对象中存在其他对象时需要）
@JsonIgnoreProperties(value = { "handler" })
public class Cart {
//    购物车编号
    private Integer cartId;
//    商品数量
    private Integer cartCount;
//    商品
    private Goods goods;
//    商品标签
    private Inventory inventory;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Cart{");
        sb.append("cartId=").append(cartId);
        sb.append(", cartCount=").append(cartCount);
        sb.append(", goods=").append(goods);
        sb.append(", inventory=").append(inventory);
        sb.append('}');
        return sb.toString();
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getCartCount() {
        return cartCount;
    }

    public void setCartCount(Integer cartCount) {
        this.cartCount = cartCount;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
