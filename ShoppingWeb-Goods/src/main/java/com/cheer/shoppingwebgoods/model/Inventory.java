package com.cheer.shoppingwebgoods.model;

/**
 * 商品库存表
 */
public class Inventory {
//    商品库存编号
    private Integer inventoryId;
//    商品库存名称
    private String inventoryName;


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Inventory{");
        sb.append("inventoryId=").append(inventoryId);
        sb.append(", inventoryName='").append(inventoryName).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

}
