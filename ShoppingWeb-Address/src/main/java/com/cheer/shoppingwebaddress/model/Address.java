package com.cheer.shoppingwebaddress.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//解决json序列化问题（对象中存在其他对象时需要）
@JsonIgnoreProperties(value = { "handler" })
/**
 * 收货地址
 */
public class Address {
//    地址编号
    private Integer addressId;
//    地址别名
    private String addressAlias;
//    地址收件人
    private String addressName;
//    地址地区
    private String addressDistrict;
//    详细地址
    private String addressDetailed;
//    联系人手机
    private String addressPhone;
//    默认地址
    private Defaultaddress defaultaddress;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Address{");
        sb.append("addressId=").append(addressId);
        sb.append(", addressAlias='").append(addressAlias).append('\'');
        sb.append(", addressName='").append(addressName).append('\'');
        sb.append(", addressDistrict='").append(addressDistrict).append('\'');
        sb.append(", addressDetailed='").append(addressDetailed).append('\'');
        sb.append(", addressPhone='").append(addressPhone).append('\'');
        sb.append(", defaultaddress=").append(defaultaddress);
        sb.append('}');
        return sb.toString();
    }

    public Defaultaddress getDefaultaddress() {
        return defaultaddress;
    }

    public void setDefaultaddress(Defaultaddress defaultaddress) {
        this.defaultaddress = defaultaddress;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddressAlias() {
        return addressAlias;
    }

    public void setAddressAlias(String addressAlias) {
        this.addressAlias = addressAlias;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getAddressDistrict() {
        return addressDistrict;
    }

    public void setAddressDistrict(String addressDistrict) {
        this.addressDistrict = addressDistrict;
    }

    public String getAddressDetailed() {
        return addressDetailed;
    }

    public void setAddressDetailed(String addressDetailed) {
        this.addressDetailed = addressDetailed;
    }

    public String getAddressPhone() {
        return addressPhone;
    }

    public void setAddressPhone(String addressPhone) {
        this.addressPhone = addressPhone;
    }


}
