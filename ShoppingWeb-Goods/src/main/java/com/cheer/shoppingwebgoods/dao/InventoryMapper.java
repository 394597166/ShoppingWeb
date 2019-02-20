package com.cheer.shoppingwebgoods.dao;

import com.cheer.shoppingwebgoods.model.Inventory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InventoryMapper {
    /**
     * 通过商品编号获得所有商品库存
     * @param goodsId
     * @return
     */
    List<Inventory> selectInventoryAndgoodsId(@Param("goodsId")Integer goodsId);

    /**
     * 新建标签
     * @param inventoryId
     * @param inventoryName
     * @param goodsId
     */
    void insertInventory(@Param("inventoryId")Integer inventoryId,@Param("inventoryName")String inventoryName,@Param("goodsId")Integer goodsId);

    /**
     * 获得单个标签对象
     * @param inventoryId
     * @return
     */
    Inventory selectInventoryAndinventoryId(@Param("inventoryId")Integer inventoryId);
}
