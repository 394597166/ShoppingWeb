package com.cheer.shoppingwebbalance.model;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * 余额
 */

//解决json序列化问题（对象中存在其他对象时需要）
@JsonIgnoreProperties(value = { "handler" })
public class Balance {
//    余额编号
    private Integer balanceId;
//    余额
    private Double balanceMoney;
//    余额明细
    private List<BalanceItem> balanceItemList;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Balance{");
        sb.append("balanceId=").append(balanceId);
        sb.append(", balanceMoney=").append(balanceMoney);
        sb.append(", balanceItemList=").append(balanceItemList);
        sb.append('}');
        return sb.toString();
    }

    public Integer getBalanceId() {
        return balanceId;
    }

    public void setBalanceId(Integer balanceId) {
        this.balanceId = balanceId;
    }

    public Double getBalanceMoney() {
        return balanceMoney;
    }

    public void setBalanceMoney(Double balanceMoney) {
        this.balanceMoney = balanceMoney;
    }

    public List<BalanceItem> getBalanceItemList() {
        return balanceItemList;
    }

    public void setBalanceItemList(List<BalanceItem> balanceItemList) {
        this.balanceItemList = balanceItemList;
    }
}
