package com.cheer.shoppingwebgoodscollect.model;

import com.cheer.shoppingwebgoods.model.Goods;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 商品收藏表
 */
//解决json序列化问题（对象中存在其他对象时需要）
@JsonIgnoreProperties(value = { "handler" })
public class Goodscollect {
//    商品收藏编号
    private Integer goodscollectId;
//    商品
    private Goods goods;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Goodscollect{");
        sb.append("goodscollectId=").append(goodscollectId);
        sb.append(", goods=").append(goods);
        sb.append('}');
        return sb.toString();
    }

    public Integer getGoodscollectId() {
        return goodscollectId;
    }

    public void setGoodscollectId(Integer goodscollectId) {
        this.goodscollectId = goodscollectId;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
