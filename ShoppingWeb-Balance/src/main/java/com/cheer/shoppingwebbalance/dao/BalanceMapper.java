package com.cheer.shoppingwebbalance.dao;

import com.cheer.shoppingwebbalance.model.Balance;
import org.apache.ibatis.annotations.Param;

public interface BalanceMapper {
    /**
     * 获得余额信息
     * @param userId
     * @return
     */
    Balance getBalance(@Param("userId") Integer userId);

    /**
     * 新建余额表(注册用户时)
     * @param balanceId
     * @param balanceMoney
     * @param userId
     */
    void insertBalance(@Param("balanceId") Integer balanceId, @Param("balanceMoney") Double balanceMoney, @Param("userId") Integer userId);

    /**
     * 变更余额
     * @param balanceId
     * @param balanceMoney
     */
    void updateBalance(@Param("balanceId") Integer balanceId, @Param("balanceMoney") Double balanceMoney);

}
