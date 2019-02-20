package com.cheer.shoppingwebcoupon.dao;


import com.cheer.shoppingwebcoupon.model.Coupon;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CouponMapper {
    /**
     * 新增优惠卷
     * @param couponId
     * @param couponFull
     * @param couponSubtract
     * @param couponStart
     * @param couponFinish
     */
    void insertCoupon(@Param("couponId") Integer couponId, @Param("couponFull") Integer couponFull,@Param("couponSubtract") Integer couponSubtract,@Param("couponStart") String couponStart,@Param("couponFinish") String couponFinish);

    /**
     * 获得所有未过期优惠券
     * @param couponFinish
     * @return
     */
    List<Coupon> selectAllCoupon(@Param("couponFinish") String couponFinish);

    /**
     * 获得指定编号优惠券
     * @param couponId
     * @return
     */
    Coupon selectCoupon(@Param("couponId") Integer couponId);
}
