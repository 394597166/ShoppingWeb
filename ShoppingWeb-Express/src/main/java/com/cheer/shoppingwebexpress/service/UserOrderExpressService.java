package com.cheer.shoppingwebexpress.service;

import com.cheer.shoppingwebexpress.model.UserOrderExpress;

public interface UserOrderExpressService {
    /**
     * 通过订单号获得快递信息对象
     * @param userorderId
     * @return
     */
    UserOrderExpress selectUserOrderExpressOne(Integer userorderId);

    /**
     * 发货
     * @param userorderexpressId
     * @param userorderexpressName
     * @param userorderId
     * @param expressId
     */
    void insertUserOrderExpress(Integer userorderexpressId,String userorderexpressName, Integer userorderId, Integer expressId);
}
