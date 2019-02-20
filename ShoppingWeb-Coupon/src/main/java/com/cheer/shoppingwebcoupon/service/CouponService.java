package com.cheer.shoppingwebcoupon.service;

import com.cheer.shoppingwebcoupon.model.Coupon;

import java.util.List;

public interface CouponService {

    /**
     * 新增优惠卷
     * @param couponId
     * @param couponFull
     * @param couponSubtract
     * @param couponStart
     * @param couponFinish
     */
    void insertCoupon( Integer couponId,  Integer couponFull,  Integer couponSubtract,  String couponStart,  String couponFinish);

    /**
     * 获得所有未过期优惠券
     * @param couponFinish
     * @return
     */
    List<Coupon> selectAllCoupon(String couponFinish);

    /**
     * 获得指定编号优惠券
     * @param couponId
     * @return
     */
    Coupon selectCoupon(Integer couponId);
}
