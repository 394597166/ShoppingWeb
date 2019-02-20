package com.cheer.shoppingwebaddress.model;

/**
 * 默认收货地址
 */
public class Defaultaddress {
    //默认地址编号
    private Integer defaultaddressId;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Defaultaddress{");
        sb.append("defaultaddressId=").append(defaultaddressId);
        sb.append('}');
        return sb.toString();
    }

    public Integer getDefaultaddressId() {
        return defaultaddressId;
    }

    public void setDefaultaddressId(Integer defaultaddressId) {
        this.defaultaddressId = defaultaddressId;
    }
}
