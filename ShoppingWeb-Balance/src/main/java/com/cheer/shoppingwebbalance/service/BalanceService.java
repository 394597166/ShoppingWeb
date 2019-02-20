package com.cheer.shoppingwebbalance.service;

import com.cheer.shoppingwebbalance.model.Balance;

public interface BalanceService {
    /**
     * 获得余额信息
     * @param userId
     * @return
     */
    Balance getBalance(Integer userId);

    /**
     * 新建余额表(注册用户时)
     * @param balanceId
     * @param balanceMoney
     * @param userId
     */
    void insertBalance(Integer balanceId,Double balanceMoney,Integer userId);

    /**
     * 变更余额
     * @param balanceId
     * @param balanceMoney
     */
    void updateBalance(Integer balanceId,Double balanceMoney);
}
