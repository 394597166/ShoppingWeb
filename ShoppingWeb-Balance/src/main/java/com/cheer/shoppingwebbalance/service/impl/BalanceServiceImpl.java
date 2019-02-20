package com.cheer.shoppingwebbalance.service.impl;

import com.cheer.shoppingwebbalance.dao.BalanceMapper;
import com.cheer.shoppingwebbalance.model.Balance;
import com.cheer.shoppingwebbalance.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 余额处理
 * @author Lean
 */
@Service
public class BalanceServiceImpl implements BalanceService {
    //依赖注入
    @Autowired
    private BalanceMapper balanceMapper;


    @Override
    public Balance getBalance(Integer userId){
        return this.balanceMapper.getBalance(userId);
    }

    @Override
    public void insertBalance(Integer balanceId,Double balanceMoney,Integer userId){
        this.balanceMapper.insertBalance(balanceId,balanceMoney,userId);
    }

    @Override
    public void updateBalance(Integer balanceId,Double balanceMoney){
        this.balanceMapper.updateBalance(balanceId,balanceMoney);
    }

}
