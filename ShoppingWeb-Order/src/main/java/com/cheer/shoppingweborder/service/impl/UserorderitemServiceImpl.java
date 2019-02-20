package com.cheer.shoppingweborder.service.impl;

import com.cheer.shoppingweborder.dao.UserorderitemMapper;
import com.cheer.shoppingweborder.model.Userorderitem;
import com.cheer.shoppingweborder.service.UserorderitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 业务处理
 * @author Lean
 */
@Service
public class UserorderitemServiceImpl implements UserorderitemService {
    //依赖注入
    @Autowired
    private UserorderitemMapper userorderitemMapper;

    @Override
    public Userorderitem selectUserorderitemAnduserorderId(Integer userorderId){
        return this.userorderitemMapper.selectUserorderitemAnduserorderId(userorderId);
    }

    @Override
    public void insertUserorderitem(Integer userorderitemId,Integer goodsId,String goodsName,Integer inventoryId,String inventoryName,Double userorderitemPrice,Integer userorderitemCount,Integer userorderId){
        this.userorderitemMapper.insertUserorderitem(userorderitemId,goodsId,goodsName,inventoryId,inventoryName,userorderitemPrice,userorderitemCount,userorderId);
    }
}
