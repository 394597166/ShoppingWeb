package com.cheer.shoppingweborder.dao;

import com.cheer.shoppingweborder.model.Userorder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserorderMapper {
    /**
     * 通过用户编号和状态获得所有订单信息
     * @param userId
     * @param userorderState
     * @return
     */
    List<Userorder> selectUserorderAndIdAndState(@Param("userId")Integer userId,@Param("userorderState") String userorderState);

    /**
     * 通过用户编号获得所有订单信息
     * @param userId
     * @return
     */
    List<Userorder> selectUserorderAndId(@Param("userId")Integer userId);

    /**
     * 通过订单编号获得订单信息
     * @param userorderId
     * @return
     */
    Userorder selectUserorderAnduserorderId(@Param("userorderId")Integer userorderId);

    /**
     * 新增订单
     * @param userorderId
     * @param addressAlias
     * @param addressName
     * @param addressDistrict
     * @param addressDetailed
     * @param addressPhone
     * @param userorderCount
     * @param userorderPrice
     * @param userorderState
     * @param userorderTime
     * @param couponSubtract
     * @param userId
     */
    void insertUserorder(@Param("userorderId")Integer userorderId,@Param("addressAlias")String addressAlias,@Param("addressName")String addressName,@Param("addressDistrict")String addressDistrict,@Param("addressDetailed")String addressDetailed,@Param("addressPhone")String addressPhone,@Param("userorderCount")Integer userorderCount,@Param("userorderPrice")Double userorderPrice,@Param("userorderState")String userorderState,@Param("userorderTime")String userorderTime,@Param("userCouponId")Integer userCouponId,@Param("couponSubtract")Integer couponSubtract,@Param("userId")Integer userId);

    /**
     * 通过订单号修改订单状态
     * @param userorderId
     * @param userorderState
     */
    void updateUserorder(@Param("userorderId")Integer userorderId,@Param("userorderState")String userorderState);

    /**
     * 支付成功后，添加支付时间
     * @param userorderId
     * @param payTime
     */
    void insertUserorderpayTime(@Param("userorderId")Integer userorderId,@Param("payTime")String payTime);

    /**
     * 使用优惠券，添加用户优惠券编号
     * @param userorderId
     * @param userCouponId
     */
    void insertUserordercouponId(@Param("userorderId")Integer userorderId,@Param("userCouponId")Integer userCouponId);

    /**
     * 取消订单，清空优惠券信息
     * @param userorderId
     */
    void clearUserCoupon(@Param("userorderId")Integer userorderId);

    /**
     * 通过状态获得所有订单
     * @param userorderState
     * @return
     */
    List<Userorder> selectAllUserorderAndState(@Param("userorderState") String userorderState);
}
