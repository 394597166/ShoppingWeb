package com.cheer.shoppingwebbalance.dao;

import com.cheer.shoppingwebbalance.model.BalanceItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BalanceItemMapper {
    /**
     * 获得余额明细信息
     * @param balanceId
     * @return
     */
    List<BalanceItem> getAllBalanceItem(@Param("balanceId") Integer balanceId);

    /**
     * 新增余额明细记录
     * @param balanceItemId
     * @param balanceItemData
     * @param balanceItemMoney
     * @param balanceItemOperation
     * @param balanceItemRemark
     * @param balanceId
     */
    void insertBanlanceItem(@Param("balanceItemId") Integer balanceItemId, @Param("balanceItemData") String balanceItemData, @Param("balanceItemMoney") String balanceItemMoney, @Param("balanceItemOperation") String balanceItemOperation, @Param("balanceItemRemark") String balanceItemRemark, @Param("balanceId") Integer balanceId);

}
