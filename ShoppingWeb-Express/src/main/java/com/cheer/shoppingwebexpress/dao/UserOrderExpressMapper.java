package com.cheer.shoppingwebexpress.dao;


import com.cheer.shoppingwebexpress.model.UserOrderExpress;
import org.apache.ibatis.annotations.Param;

public interface UserOrderExpressMapper {
    /**
     * 通过订单号获得快递信息对象
     * @param userorderId
     * @return
     */
    UserOrderExpress selectUserOrderExpressOne(@Param("userorderId") Integer userorderId);

    /**
     * 发货
     * @param userorderexpressId
     * @param userorderexpressName
     * @param userorderId
     * @param expressId
     */
    void insertUserOrderExpress(@Param("userorderexpressId") Integer userorderexpressId,@Param("userorderexpressName") String userorderexpressName,@Param("userorderId") Integer userorderId,@Param("expressId") Integer expressId);
}
