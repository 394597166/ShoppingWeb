package com.cheer.shoppingwebcoupon.dao;


import com.cheer.shoppingwebcoupon.model.Usercoupon;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsercouponMapper {
    /**
     * 领取优惠券
     * @param userCouponId
     * @param couponId
     * @param userId
     * @param userCouponState
     */
    Integer insertUsercoupon(@Param("userCouponId")Integer userCouponId,@Param("couponId") Integer couponId,@Param("userId") Integer userId,@Param("userCouponState")String userCouponState);

    /**
     * 获得用户所有优惠券
     * @param userId
     * @return
     */
    List<Usercoupon> selectAllUsercoupon(@Param("userId") Integer userId);

    /**
     * 获得不同状态的优惠券
     * @param userId
     * @param userCouponState
     * @return
     */
    List<Usercoupon> selectUsercouponAndState(@Param("userId") Integer userId,@Param("userCouponState") String userCouponState);

    /**
     * 更改优惠券状态
     * @param userCouponId
     * @param userCouponState
     */
    void updateUsercoupon(@Param("userCouponId")Integer userCouponId,@Param("userCouponState")String userCouponState);
}
