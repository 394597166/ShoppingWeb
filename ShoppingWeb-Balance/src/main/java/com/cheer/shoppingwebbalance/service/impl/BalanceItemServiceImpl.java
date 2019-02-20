package com.cheer.shoppingwebbalance.service.impl;

import com.cheer.shoppingwebbalance.dao.BalanceItemMapper;
import com.cheer.shoppingwebbalance.model.BalanceItem;
import com.cheer.shoppingwebbalance.service.BalanceItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 余额明细处理
 * @author Lean
 */
@Service
public class BalanceItemServiceImpl  implements BalanceItemService {
    //依赖注入
    @Autowired
    private BalanceItemMapper balanceItemMapper;


    @Override
    public List<BalanceItem> getAllBalanceItem(Integer balanceId){
        List<BalanceItem> balanceItemList = this.balanceItemMapper.getAllBalanceItem(balanceId);
        return balanceItemList;
    }

    @Override
    public void insertBanlanceItem(Integer balanceItemId,String balanceItemData,String balanceItemMoney,String balanceItemOperation,String balanceItemRemark,Integer balanceId){
        this.balanceItemMapper.insertBanlanceItem(balanceItemId,balanceItemData,balanceItemMoney,balanceItemOperation,balanceItemRemark,balanceId);
    }


}
