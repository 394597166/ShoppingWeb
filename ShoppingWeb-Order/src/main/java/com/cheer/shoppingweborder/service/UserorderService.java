package com.cheer.shoppingweborder.service;

import com.cheer.shoppingweborder.model.Userorder;

import java.util.List;

public interface UserorderService {
    /**
     * 通过用户编号和状态获得所有订单信息
     * @param userId
     * @param userorderState
     * @return
     */
    List<Userorder> selectUserorderAndIdAndState(Integer userId,  String userorderState);

    /**
     * 通过用户编号获得所有订单信息
     * @param userId
     * @return
     */
    List<Userorder> selectUserorderAndId(Integer userId);

    /**
     * 通过订单编号获得订单信息
     * @param userorderId
     * @return
     */
    Userorder selectUserorderAnduserorderId(Integer userorderId);

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
     * @param userCouponId
     * @param couponSubtract
     * @param userId
     */
    void insertUserorder(Integer userorderId,String addressAlias,String addressName,String addressDistrict,String addressDetailed,String addressPhone,Integer userorderCount,Double userorderPrice,String userorderState,String userorderTime,Integer userCouponId,Integer couponSubtract,Integer userId);

    /**
     * 支付成功后，添加支付时间
     * @param userorderId
     * @param payTime
     */
    void insertUserorderpayTime(Integer userorderId,String payTime);

    /**
     * 通过订单号修改订单状态
     * @param userorderId
     * @param userorderState
     */
    void updateUserorder(Integer userorderId,String userorderState);

    /**
     * 使用优惠券，添加用户优惠券编号
     * @param userorderId
     * @param userCouponId
     */
    void insertUserordercouponId(Integer userorderId,Integer userCouponId);

    /**
     * 取消订单，清空优惠券信息
     * @param userorderId
     */
    void clearUserCoupon(Integer userorderId);

    /**
     * 通过状态获得所有订单
     * @param userorderState
     * @return
     */
    List<Userorder> selectAllUserorderAndState( String userorderState);

    /**
     * 获得所有订单
     * @return
     */
    List<Userorder> selectAllUserorder();

}
