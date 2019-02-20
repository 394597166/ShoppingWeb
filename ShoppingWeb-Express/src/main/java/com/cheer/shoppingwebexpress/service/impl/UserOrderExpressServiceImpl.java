package com.cheer.shoppingwebexpress.service.impl;

import com.cheer.shoppingwebexpress.dao.UserOrderExpressMapper;
import com.cheer.shoppingwebexpress.model.UserOrderExpress;
import com.cheer.shoppingwebexpress.service.UserOrderExpressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * 业务处理
 * @author Lean
 */
@Service
public class UserOrderExpressServiceImpl implements UserOrderExpressService {
    //依赖注入
    @Autowired
    private UserOrderExpressMapper userOrderExpressMapper;

    @Override
    public UserOrderExpress selectUserOrderExpressOne(Integer userorderId){
        return this.userOrderExpressMapper.selectUserOrderExpressOne(userorderId);
    }

    @Override
    public void insertUserOrderExpress(Integer userorderexpressId,String userorderexpressName, Integer userorderId, Integer expressId){
        this.userOrderExpressMapper.insertUserOrderExpress(userorderexpressId,userorderexpressName,userorderId,expressId);
    }

}
