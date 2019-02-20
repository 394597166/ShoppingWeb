package com.cheer.shoppingwebgoods.service.impl;

import com.cheer.shoppingwebgoods.dao.InventoryMapper;
import com.cheer.shoppingwebgoods.model.Inventory;
import com.cheer.shoppingwebgoods.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryMapper inventoryMapper;

    @Override
    public void insertInventory(Integer inventoryId,String inventoryName,Integer goodsId){
        this.inventoryMapper.insertInventory(inventoryId,inventoryName,goodsId);
    }

    @Override
    public Inventory selectInventoryAndinventoryId(Integer inventoryId){
        return this.inventoryMapper.selectInventoryAndinventoryId(inventoryId);
    }


}
