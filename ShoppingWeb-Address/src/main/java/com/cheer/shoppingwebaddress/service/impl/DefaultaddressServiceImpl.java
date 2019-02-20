package com.cheer.shoppingwebaddress.service.impl;

import com.cheer.shoppingwebaddress.dao.DefaultaddressMapper;
import com.cheer.shoppingwebaddress.service.DefaultaddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 收件地址处理
 * @author Lean
 */
@Service
public class DefaultaddressServiceImpl implements DefaultaddressService {
    //依赖注入
    @Autowired
    private DefaultaddressMapper defaultaddressMapper;

    @Override
    public void updateDefault(Integer defaultaddressId, Integer addressId){
        this.defaultaddressMapper.updateDefault(defaultaddressId,addressId);
    }

    @Override
    public void insert(Integer defaultaddressId){
        this.defaultaddressMapper.insert(defaultaddressId,null);
    }
}
