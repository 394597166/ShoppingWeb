package com.cheer.shoppingweborder.service;

import com.cheer.shoppingweborder.model.Userorderitem;

public interface UserorderitemService {
    /**
     * 通过订单号获得订单项目对象
     * @param userorderId
     * @return
     */
    Userorderitem selectUserorderitemAnduserorderId(Integer userorderId);

    /**
     * 插入订单项目数据
     * @param userorderitemId
     * @param goodsId
     * @param goodsName
     * @param inventoryId
     * @param inventoryName
     * @param userorderitemPrice
     * @param userorderitemCount
     * @param userorderId
     */
    void insertUserorderitem(Integer userorderitemId,Integer goodsId,String goodsName,Integer inventoryId,String inventoryName,Double userorderitemPrice,Integer userorderitemCount,Integer userorderId);
}
