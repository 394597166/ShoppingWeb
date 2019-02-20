package com.cheer.shoppingwebaddress.service;

import com.cheer.shoppingwebaddress.model.Address;

import java.util.List;

public interface AddressService {
    /**
     * 返回所有的收件地址
     * @param userId
     * @return
     */
     List<Address> AddressAll(Integer userId);

    /**
     * 删除地址
     * @param addressId
     */
    void deleteAddress(Integer addressId);

    /**
     * 新增收货地址
     * @param addressId
     * @param addressAlias
     * @param addressName
     * @param addressDistrict
     * @param addressDetailed
     * @param addressPhone
     * @param userId
     */
     void insertAddress(Integer addressId,String addressAlias,String addressName,String addressDistrict,String addressDetailed,String addressPhone,Integer userId);

    /**
     * 更新收货地址
     * @param address
     */
    void updateAddress(Address address);
}
