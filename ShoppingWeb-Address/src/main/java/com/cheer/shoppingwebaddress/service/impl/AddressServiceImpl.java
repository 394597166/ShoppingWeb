package com.cheer.shoppingwebaddress.service.impl;

import com.cheer.shoppingwebaddress.dao.AddressMapper;
import com.cheer.shoppingwebaddress.model.Address;
import com.cheer.shoppingwebaddress.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 收件地址处理
 * @author Lean
 */
@Service
public class AddressServiceImpl implements AddressService {

    //依赖注入
    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<Address> AddressAll(Integer userId){
        return this.addressMapper.AddressAll(userId);
    }

    @Override
    public void deleteAddress(Integer addressId){
        this.addressMapper.deleteAddress(addressId);
    }

    @Override
    public void insertAddress(Integer addressId,String addressAlias,String addressName,String addressDistrict,String addressDetailed,String addressPhone,Integer userId){
        this.addressMapper.insertAddress(addressId,addressAlias,addressName,addressDistrict,addressDetailed,addressPhone,userId);
    }

    @Override
    public void updateAddress(Address address){
        this.addressMapper.updateAddress(address);
    }
}
