package com.cheer.shoppingwebaddress.service;

public interface DefaultaddressService {
    /**
     * 更改默认收货地址
     * @param addressId
     */
    void updateDefault(Integer defaultaddressId, Integer addressId);
    /**
     * 建立用户时创立默认收货地址数据表
     * @param defaultaddressId
     */
    void insert(Integer defaultaddressId);
}
