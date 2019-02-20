package com.cheer.shoppingwebbalance.service;

import com.cheer.shoppingwebbalance.model.BalanceItem;

import java.util.List;

public interface BalanceItemService {
    /**
     * 获得余额明细信息
     * @param balanceId
     * @return
     */
    List<BalanceItem> getAllBalanceItem(Integer balanceId);

    /**
     * 新增余额明细记录
     * @param balanceItemId
     * @param balanceItemData
     * @param balanceItemMoney
     * @param balanceItemOperation
     * @param balanceItemRemark
     * @param balanceId
     */
    void insertBanlanceItem(Integer balanceItemId,String balanceItemData,String balanceItemMoney,String balanceItemOperation,String balanceItemRemark,Integer balanceId);
}
