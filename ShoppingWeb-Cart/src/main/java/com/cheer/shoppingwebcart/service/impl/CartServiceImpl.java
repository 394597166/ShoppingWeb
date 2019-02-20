package com.cheer.shoppingwebcart.service.impl;

import com.cheer.shoppingwebcart.dao.CartMapper;
import com.cheer.shoppingwebcart.model.Cart;
import com.cheer.shoppingwebcart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartMapper cartMapper;

    @Override
    public List<Cart> selectCartAll(Integer userId){
        return this.cartMapper.selectCartAll(userId);
    }

    @Override
    public Cart selectCartOne(Integer userId,Integer goodsId,Integer inventoryId){
        return this.cartMapper.selectCartOne(userId,goodsId,inventoryId);
    }

    @Override
    public void deleteCart(Integer cartId){
        this.cartMapper.deleteCart(cartId);
    }

    @Override
    public void updateCartCount(Integer cartId,Integer cartCount){
        this.cartMapper.updateCartCount(cartId,cartCount);
    }

    @Override
    public void insertCart(Integer cartId,Integer cartCount,Integer goodsId,Integer inventoryId,Integer userId){
        this.cartMapper.insertCart(cartId,cartCount,goodsId,inventoryId,userId);
    }


}
