package com.cheer.shoppingwebgoods.service;

import com.cheer.shoppingwebgoods.model.Inventory;

public interface InventoryService {
    /**
     * 新建标签
     * @param inventoryId
     * @param inventoryName
     * @param goodsId
     */
    void insertInventory(Integer inventoryId,String inventoryName,Integer goodsId);

    /**
     * 获得单个标签对象
     * @param inventoryId
     * @return
     */
    Inventory selectInventoryAndinventoryId(Integer inventoryId);
}
