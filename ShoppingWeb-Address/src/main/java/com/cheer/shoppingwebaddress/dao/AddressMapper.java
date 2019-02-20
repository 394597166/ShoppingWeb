package com.cheer.shoppingwebaddress.dao;

import com.cheer.shoppingwebaddress.model.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressMapper {
    /**
     * 获得所有地址信息
     * @return
     */
   List<Address> AddressAll(@Param("userId") Integer userId);

    /**
     * 更新收货地址
     * @param address
     */
   void updateAddress(Address address);

    /**
     * 插入收货地址
     * @param addressId
     * @param addressAlias
     * @param addressName
     * @param addressDistrict
     * @param addressDetailed
     * @param addressPhone
     * @param userId
     */
   void insertAddress(@Param("addressId") Integer addressId, @Param("addressAlias") String addressAlias, @Param("addressName") String addressName, @Param("addressDistrict") String addressDistrict, @Param("addressDetailed") String addressDetailed, @Param("addressPhone") String addressPhone, @Param("userId") Integer userId);

    /**
     * 删除地址
     * @param addressId
     */
   void deleteAddress(@Param("addressId") Integer addressId);
}
