package com.cheer.shoppingweborder.model;

/**
 * 订单项目类
 */
public class Userorderitem {
//    订单项目编号
    private Integer userorderitemId;
//    商品编号
    private Integer goodsId;
//    商品名
    private String goodsName;
//    商品标签编号
    private Integer inventoryId;
//    商品标签名
    private String inventoryName;
//    订单项目单价
    private Double userorderitemPrice;
//    订单项目数量
    private Integer userorderitemCount;
//    购物车编号（用于生成订单时删除购物车数据）
    private Integer cartId;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Userorderitem{");
        sb.append("userorderitemId=").append(userorderitemId);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", goodsName='").append(goodsName).append('\'');
        sb.append(", inventoryId=").append(inventoryId);
        sb.append(", inventoryName='").append(inventoryName).append('\'');
        sb.append(", userorderitemPrice=").append(userorderitemPrice);
        sb.append(", userorderitemCount=").append(userorderitemCount);
        sb.append(", cartId=").append(cartId);
        sb.append('}');
        return sb.toString();
    }

    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getUserorderitemId() {
        return userorderitemId;
    }

    public void setUserorderitemId(Integer userorderitemId) {
        this.userorderitemId = userorderitemId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    public Double getUserorderitemPrice() {
        return userorderitemPrice;
    }

    public void setUserorderitemPrice(Double userorderitemPrice) {
        this.userorderitemPrice = userorderitemPrice;
    }

    public Integer getUserorderitemCount() {
        return userorderitemCount;
    }

    public void setUserorderitemCount(Integer userorderitemCount) {
        this.userorderitemCount = userorderitemCount;
    }
}
