package com.cheer.shoppingwebbalance.model;

/**
 * 余额明细
 */
public class BalanceItem {
//    余额明细编号
    private Integer balanceItemId;
//    创建时间
    private String balanceItemData;
//    金额
    private String balanceItemMoney;
//    操作（转入/转出）
    private String balanceItemOperation;
//    备注
    private String balanceItemRemark;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("BalanceItem{");
        sb.append("balanceItemId=").append(balanceItemId);
        sb.append(", balanceItemData='").append(balanceItemData).append('\'');
        sb.append(", balanceItemMoney='").append(balanceItemMoney).append('\'');
        sb.append(", balanceItemOperation='").append(balanceItemOperation).append('\'');
        sb.append(", balanceItemRemark='").append(balanceItemRemark).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Integer getBalanceItemId() {
        return balanceItemId;
    }

    public void setBalanceItemId(Integer balanceItemId) {
        this.balanceItemId = balanceItemId;
    }

    public String getBalanceItemData() {
        return balanceItemData;
    }

    public void setBalanceItemData(String balanceItemData) {
        this.balanceItemData = balanceItemData;
    }

    public String getBalanceItemMoney() {
        return balanceItemMoney;
    }

    public void setBalanceItemMoney(String balanceItemMoney) {
        this.balanceItemMoney = balanceItemMoney;
    }

    public String getBalanceItemOperation() {
        return balanceItemOperation;
    }

    public void setBalanceItemOperation(String balanceItemOperation) {
        this.balanceItemOperation = balanceItemOperation;
    }

    public String getBalanceItemRemark() {
        return balanceItemRemark;
    }

    public void setBalanceItemRemark(String balanceItemRemark) {
        this.balanceItemRemark = balanceItemRemark;
    }

}
