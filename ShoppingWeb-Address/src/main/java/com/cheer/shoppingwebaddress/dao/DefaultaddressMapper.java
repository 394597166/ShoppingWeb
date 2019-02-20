package com.cheer.shoppingwebaddress.dao;

import com.cheer.shoppingwebaddress.model.Defaultaddress;
import org.apache.ibatis.annotations.Param;

public interface DefaultaddressMapper {
    /**
     * 获得默认地址信息
     * @return
     */
   Defaultaddress Default();

    /**
     * 更改默认收货地址
     * @param addressId
     */
   void updateDefault(@Param("defaultaddressId") Integer defaultaddressId, @Param("addressId") Integer addressId);

    /**
     * 建立用户时创立默认收货地址数据表
     * @param defaultaddressId
     * @param addressId
     */
   void insert(@Param("defaultaddressId") Integer defaultaddressId, @Param("addressId") Integer addressId);
}
