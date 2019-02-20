package com.cheer.shoppingwebexpress.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 订单发货快递信息表
 */
//解决json序列化问题（对象中存在其他对象时需要）
@JsonIgnoreProperties(value = { "handler" })
public class UserOrderExpress {
    //订单发货快递编号
    private Integer userorderexpressId;
    //快递单号
    private String userorderexpressName;
    //快递对象
    private Express express;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UserOrderExpress{");
        sb.append("userorderexpressId=").append(userorderexpressId);
        sb.append(", userorderexpressName='").append(userorderexpressName).append('\'');
        sb.append(", express=").append(express);
        sb.append('}');
        return sb.toString();
    }

    public Integer getUserorderexpressId() {
        return userorderexpressId;
    }

    public void setUserorderexpressId(Integer userorderexpressId) {
        this.userorderexpressId = userorderexpressId;
    }

    public String getUserorderexpressName() {
        return userorderexpressName;
    }

    public void setUserorderexpressName(String userorderexpressName) {
        this.userorderexpressName = userorderexpressName;
    }

    public Express getExpress() {
        return express;
    }

    public void setExpress(Express express) {
        this.express = express;
    }
}
