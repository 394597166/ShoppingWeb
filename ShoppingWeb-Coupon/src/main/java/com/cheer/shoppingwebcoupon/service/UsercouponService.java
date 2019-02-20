package com.cheer.shoppingwebcoupon.service;

import com.cheer.shoppingwebcoupon.model.Usercoupon;

import java.util.List;

public interface UsercouponService {
    /**
     * 领取优惠券
     * @param userCouponId
     * @param couponId
     * @param userId
     * @param userCouponState
     */
    Integer insertUsercoupon(Integer userCouponId,  Integer couponId,  Integer userId, String userCouponState);

    /**
     * 获得用户所有优惠券
     * @param userId
     * @return
     */
    List<Usercoupon> selectAllUsercoupon(Integer userId);

    /**
     * 获得不同状态的优惠券
     * @param userId
     * @param userCouponState
     * @return
     */
    List<Usercoupon> selectUsercouponAndState( Integer userId, String userCouponState);

    /**
     * 更改优惠券状态
     * @param userCouponId
     * @param userCouponState
     */
    void updateUsercoupon(Integer userCouponId,String userCouponState);
}
