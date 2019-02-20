package com.cheer.shoppingwebcoupon.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 用户优惠券表
 */
//解决json序列化问题（对象中存在其他对象时需要）
@JsonIgnoreProperties(value = { "handler" })
public class Usercoupon {
    //用户优惠券编号
    private Integer userCouponId;
    //优惠卷
    private Coupon coupon;
    //优惠卷状态（可用,已用,过期,回收站）
    private String userCouponState;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Usercoupon{");
        sb.append("userCouponId=").append(userCouponId);
        sb.append(", coupon=").append(coupon);
        sb.append(", userCouponState='").append(userCouponState).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Integer getUserCouponId() {
        return userCouponId;
    }

    public void setUserCouponId(Integer userCouponId) {
        this.userCouponId = userCouponId;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public String getUserCouponState() {
        return userCouponState;
    }

    public void setUserCouponState(String userCouponState) {
        this.userCouponState = userCouponState;
    }
}
