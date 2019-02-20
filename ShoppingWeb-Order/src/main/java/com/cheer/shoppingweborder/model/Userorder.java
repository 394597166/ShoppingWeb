package com.cheer.shoppingweborder.model;

import com.cheer.shoppingwebexpress.model.UserOrderExpress;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * 订单表
 */
//解决json序列化问题（对象中存在其他对象时需要）
@JsonIgnoreProperties(value = { "handler" })
public class Userorder {
//    订单编号
    private Integer userorderId;
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
//    合计数量
    private Integer userorderCount;
//    合计金额
    private Double userorderPrice;
//    订单状态(待支付,待发货,待收货,待评价,已完成,已取消,返修中,退货中)
    private String userorderState;
//    下单时间
    private String userorderTime;
//    支付时间
    private String payTime;
    //用户优惠券编号
    private Integer userCouponId;
//    减多少钱
    private Integer couponSubtract;
//    订单项目集合
    private List<Userorderitem> userorderitemList;
    //发货快递信息
    private UserOrderExpress userOrderExpress;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Userorder{");
        sb.append("userorderId=").append(userorderId);
        sb.append(", addressAlias='").append(addressAlias).append('\'');
        sb.append(", addressName='").append(addressName).append('\'');
        sb.append(", addressDistrict='").append(addressDistrict).append('\'');
        sb.append(", addressDetailed='").append(addressDetailed).append('\'');
        sb.append(", addressPhone='").append(addressPhone).append('\'');
        sb.append(", userorderCount=").append(userorderCount);
        sb.append(", userorderPrice=").append(userorderPrice);
        sb.append(", userorderState='").append(userorderState).append('\'');
        sb.append(", userorderTime='").append(userorderTime).append('\'');
        sb.append(", payTime='").append(payTime).append('\'');
        sb.append(", userCouponId=").append(userCouponId);
        sb.append(", couponSubtract=").append(couponSubtract);
        sb.append(", userorderitemList=").append(userorderitemList);
        sb.append(", userOrderExpress=").append(userOrderExpress);
        sb.append('}');
        return sb.toString();
    }

    public UserOrderExpress getUserOrderExpress() {
        return userOrderExpress;
    }

    public void setUserOrderExpress(UserOrderExpress userOrderExpress) {
        this.userOrderExpress = userOrderExpress;
    }

    public Integer getUserCouponId() {
        return userCouponId;
    }

    public void setUserCouponId(Integer userCouponId) {
        this.userCouponId = userCouponId;
    }

    public Integer getUserorderId() {
        return userorderId;
    }

    public void setUserorderId(Integer userorderId) {
        this.userorderId = userorderId;
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

    public Integer getUserorderCount() {
        return userorderCount;
    }

    public void setUserorderCount(Integer userorderCount) {
        this.userorderCount = userorderCount;
    }

    public Double getUserorderPrice() {
        return userorderPrice;
    }

    public void setUserorderPrice(Double userorderPrice) {
        this.userorderPrice = userorderPrice;
    }

    public String getUserorderState() {
        return userorderState;
    }

    public void setUserorderState(String userorderState) {
        this.userorderState = userorderState;
    }

    public String getUserorderTime() {
        return userorderTime;
    }

    public void setUserorderTime(String userorderTime) {
        this.userorderTime = userorderTime;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public Integer getCouponSubtract() {
        return couponSubtract;
    }

    public void setCouponSubtract(Integer couponSubtract) {
        this.couponSubtract = couponSubtract;
    }

    public List<Userorderitem> getUserorderitemList() {
        return userorderitemList;
    }

    public void setUserorderitemList(List<Userorderitem> userorderitemList) {
        this.userorderitemList = userorderitemList;
    }
}
