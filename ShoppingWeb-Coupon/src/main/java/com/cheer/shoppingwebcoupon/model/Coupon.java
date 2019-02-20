package com.cheer.shoppingwebcoupon.model;

/**
 * 优惠券表
 */
public class Coupon {
//    优惠券编号
    private Integer couponId;
//    满多少钱
    private Integer couponFull;
//    减多少钱
    private Integer couponSubtract;
//    开始时间
    private String couponStart;
//    结束时间
    private String couponFinish;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Coupon{");
        sb.append("couponId=").append(couponId);
        sb.append(", couponFull=").append(couponFull);
        sb.append(", couponSubtract=").append(couponSubtract);
        sb.append(", couponStart='").append(couponStart).append('\'');
        sb.append(", couponFinish='").append(couponFinish).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public Integer getCouponFull() {
        return couponFull;
    }

    public void setCouponFull(Integer couponFull) {
        this.couponFull = couponFull;
    }

    public Integer getCouponSubtract() {
        return couponSubtract;
    }

    public void setCouponSubtract(Integer couponSubtract) {
        this.couponSubtract = couponSubtract;
    }

    public String getCouponStart() {
        return couponStart;
    }

    public void setCouponStart(String couponStart) {
        this.couponStart = couponStart;
    }

    public String getCouponFinish() {
        return couponFinish;
    }

    public void setCouponFinish(String couponFinish) {
        this.couponFinish = couponFinish;
    }
}
