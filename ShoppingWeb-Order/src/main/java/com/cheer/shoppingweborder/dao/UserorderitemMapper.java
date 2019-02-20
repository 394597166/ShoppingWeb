package com.cheer.shoppingweborder.dao;

import com.cheer.shoppingweborder.model.Userorderitem;
import org.apache.ibatis.annotations.Param;

public interface UserorderitemMapper {
    /**
     * 通过订单号获得订单项目对象
     * @param userorderId
     * @return
     */
    Userorderitem selectUserorderitemAnduserorderId(@Param("userorderId")Integer userorderId);

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
    void insertUserorderitem(@Param("userorderitemId")Integer userorderitemId,@Param("goodsId")Integer goodsId,@Param("goodsName")String goodsName,@Param("inventoryId")Integer inventoryId,@Param("inventoryName")String inventoryName,@Param("userorderitemPrice")Double userorderitemPrice,@Param("userorderitemCount")Integer userorderitemCount,@Param("userorderId")Integer userorderId);
}
