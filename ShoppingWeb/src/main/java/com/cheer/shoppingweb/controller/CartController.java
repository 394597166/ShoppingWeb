package com.cheer.shoppingweb.controller;


import com.cheer.shoppingweb.service.UtilService;
import com.cheer.shoppingwebcart.model.Cart;
import com.cheer.shoppingwebcart.service.CartService;
import com.cheer.shoppingwebgoods.model.Goods;
import com.cheer.shoppingwebgoods.model.Inventory;
import com.cheer.shoppingwebgoods.service.GoodsService;
import com.cheer.shoppingwebgoods.service.InventoryService;
import com.cheer.shoppingwebgoodscollect.model.Goodscollect;
import com.cheer.shoppingwebgoodscollect.service.GoodscollectService;
import com.cheer.shoppingwebuser.model.User;
import com.cheer.shoppingwebuser.service.UserService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;


@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private UserService userService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private GoodscollectService goodscollectService;
    @Autowired
    private UtilService utilService;
    /**
     * 打开购物车页面
     * @return
     */
    @RequestMapping(value = "/cart.html")
    public String cart(){
        return "cart";
    }

    /**
     * 添加购物车
     * @return
     */
    @RequestMapping(value = "/insertCart")
    @ResponseBody
    public Map<String,Object> insertCart(@RequestParam(value = "cartCount")Integer cartCount,@RequestParam(value = "goodsId")Integer goodsId,@RequestParam(value = "inventoryId")Integer inventoryId, HttpSession session){
        //获得用户信息
        String userName = (String) session.getAttribute("username");
        Map<String,Object> map = new HashMap<>();
        //判定是否登录用户名
        if (null != userName){//已登录
            //获得user对象
            User user = this.userService.checkUserName(userName);
//            获得cart对象
            Cart cart = this.cartService.selectCartOne(user.getUserId(),goodsId,inventoryId);
            //判定购物车中是否存在该cart对象
            if (null != cart){//已存在
                //获得新的数量
                Integer newcartCount = cartCount + cart.getCartCount();
                //更新数据库中购物车的商品数量
                this.cartService.updateCartCount(cart.getCartId(),newcartCount);
            }else{//不存在
                //随机生成编号
                Integer cartId = this.utilService.UUID();
                //新建新的购物车信息
                this.cartService.insertCart(cartId,cartCount,goodsId,inventoryId,user.getUserId());
            }
            map.put("result",true);
            map.put("data","添加购物车成功！");
        }else{//未登录
            //从session中获得购物车数据
            String cart = (String) session.getAttribute("cartList");
            //创建json
            Gson gson = new Gson();
            //判定数组中是否存在该购物车数据
            Boolean flog = false;
            //判定是否为第一次添加购物车
            if (null != cart){//已存在数据
                //json数据转化为list
                List<Cart> cartList = gson.fromJson(cart,new TypeToken<List<Cart>>(){}.getType());
                //遍历list
                Iterator<Cart> cartIterator = cartList.iterator();
                while(cartIterator.hasNext()){
                    Cart cart2 = cartIterator.next();
                    //判定是否存在一模一样的购物车数据
                    if (cart2.getGoods().getGoodsId().equals(goodsId) && cart2.getInventory().getInventoryId().equals(inventoryId)){
                        //存在则更新数量
                        cart2.setCartCount(cart2.getCartCount()+cartCount);
                        flog = true;
                        break;
                    }
                }
                if (flog){
                    String str = gson.toJson(cartList);
                    session.setAttribute("cartList",str);
                }else{//不存在该数据
                    //创建新的购物车数据
                    Cart cart1 = new Cart();
                    cart1.setCartCount(cartCount);
                    Goods goods = new Goods();
                    Goods goods1 = this.goodsService.selectGoodsAndId(goodsId,"上架");
                    goods.setGoodsId(goodsId);
                    goods.setGoodsName(goods1.getGoodsName());
                    goods.setGoodsPrice(goods1.getGoodsPrice());
                    goods.setGoodsVipPrice(goods1.getGoodsVipPrice());
                    cart1.setGoods(goods);
                    Inventory inventory = new Inventory();
                    Inventory inventory1 = this.inventoryService.selectInventoryAndinventoryId(inventoryId);
                    inventory.setInventoryId(inventory1.getInventoryId());
                    inventory.setInventoryName(inventory1.getInventoryName());
                    cart1.setInventory(inventory);
                    //添加数据到list集合中
                    cartList.add(cart1);
                    String str = gson.toJson(cartList);
                    //将新的数据加入到session中
                    session.setAttribute("cartList",str);
                }
            }else{//还未创建购物车
                List<Cart> cartList = new ArrayList<>();
                Cart cart1 = new Cart();
                cart1.setCartCount(cartCount);
                Goods goods = new Goods();
                Goods goods1 = this.goodsService.selectGoodsAndId(goodsId,"上架");
                goods.setGoodsId(goodsId);
                goods.setGoodsName(goods1.getGoodsName());
                goods.setGoodsPrice(goods1.getGoodsPrice());
                goods.setGoodsVipPrice(goods1.getGoodsVipPrice());
                cart1.setGoods(goods);
                Inventory inventory = new Inventory();
                Inventory inventory1 = this.inventoryService.selectInventoryAndinventoryId(inventoryId);
                inventory.setInventoryId(inventory1.getInventoryId());
                inventory.setInventoryName(inventory1.getInventoryName());
                cart1.setInventory(inventory);
                //添加数据到list集合中
                cartList.add(cart1);
                String str = gson.toJson(cartList);
                //将数据加入到session中
                session.setAttribute("cartList",str);
            }
            map.put("result",true);
            map.put("data","添加购物车成功！");
        }
        return map;
    }

    /**
     * 获得所有购物车信息
     * @return
     */
    @RequestMapping(value = "/selectCartAll")
    @ResponseBody
    public Map<String,Object> selectCartAll(HttpSession session){
        //获得用户信息
        String userName = (String) session.getAttribute("username");
        Map<String,Object> map = new HashMap<>();
        if (null != userName){//已登录
            //从session中获得购物车数据
            String cart = (String) session.getAttribute("cartList");
            //获得user对象
            User user = this.userService.checkUserName(userName);
            if (null != cart){//已存在
                //创建json
                Gson gson = new Gson();
                //json数据转化为list
                List<Cart> cartList = gson.fromJson(cart,new TypeToken<List<Cart>>(){}.getType());
                Iterator<Cart> cartIterator = cartList.iterator();
                while (cartIterator.hasNext()){
                    Cart cart1 = cartIterator.next();
                    //获得cart对象
                    Cart cart2 = this.cartService.selectCartOne(user.getUserId(),cart1.getGoods().getGoodsId(),cart1.getInventory().getInventoryId());
                    //判定购物车中是否存在该cart对象
                    if (null != cart2){//已存在
                        //获得新的数量
                        Integer newcartCount = cart2.getCartCount() + cart1.getCartCount();
                        //更新数据库中购物车的商品数量
                        this.cartService.updateCartCount(cart2.getCartId(),newcartCount);
                    }else{//不存在
                        //随机生成编号
                        Integer cartId = this.utilService.UUID();
                        //新建新的购物车信息
                        this.cartService.insertCart(cartId,cart1.getCartCount(),cart1.getGoods().getGoodsId(),cart1.getInventory().getInventoryId(),user.getUserId());
                    }
                }
                session.removeAttribute("cartList");
            }
            //获得所有的购物车数据
            List<Cart> cartList = this.cartService.selectCartAll(user.getUserId());
            map.put("result",true);
            map.put("cartList",cartList);
            map.put("user",user);
        }else{//未登录
            //从session中获得购物车数据
            String cart = (String) session.getAttribute("cartList");
            //判断session中是否存在购物车数据
            if (null != cart){//存在
                //创建json
                Gson gson = new Gson();
                //json数据转化为list
                List<Cart> cartList = gson.fromJson(cart,new TypeToken<List<Cart>>(){}.getType());
                map.put("result",true);
                map.put("cartList",cartList);
            }else{//不存在数据
                map.put("result",false);
            }
        }
        return map;
    }


    /**
     * 减少商品数量
     * @return
     */
    @RequestMapping(value = "/subtractCount")
    @ResponseBody
    public String subtractCount(@RequestParam(value = "cartId")Integer cartId,@RequestParam(value = "cartCount")Integer cartCount,@RequestParam(value = "goodsId")Integer goodsId, @RequestParam(value = "inventoryId")Integer inventoryId,  HttpSession session){
        //获取用户名
        String userName = (String) session.getAttribute("username");
        //检查是否登录
        Map<String,Object> map = this.utilService.checkUserName(userName);
        Boolean flog = (Boolean) map.get("result");
        //已登录
        if (flog){//已登录
            this.cartService.updateCartCount(cartId,cartCount - 1);
        }else{//未登录
            //从session中获得购物车数据
            String cart = (String) session.getAttribute("cartList");
            //创建json
            Gson gson = new Gson();
            //json数据转化为list
            List<Cart> cartList = gson.fromJson(cart,new TypeToken<List<Cart>>(){}.getType());
            //遍历list
            Iterator<Cart> cartIterator = cartList.iterator();
            while(cartIterator.hasNext()){
                Cart cart2 = cartIterator.next();
                //判定是否存在一模一样的购物车数据
                if (cart2.getGoods().getGoodsId().equals(goodsId) && cart2.getInventory().getInventoryId().equals(inventoryId)){
                    //存在则更新数量
                    cart2.setCartCount(cartCount - 1);
                    break;
                }
            }
            String str = gson.toJson(cartList);
            //将数据加入到session中
            session.setAttribute("cartList",str);
        }
        return "true";
    }

    /**
     * 增加商品数量
     * @return
     */
    @RequestMapping(value = "/addCount")
    @ResponseBody
    public String addCount(@RequestParam(value = "cartId")Integer cartId,@RequestParam(value = "cartCount")Integer cartCount,@RequestParam(value = "goodsId")Integer goodsId, @RequestParam(value = "inventoryId")Integer inventoryId, HttpSession session){
        //获取用户名
        String userName = (String) session.getAttribute("username");
        //检查是否登录
        Map<String,Object> map = this.utilService.checkUserName(userName);
        Boolean flog = (Boolean) map.get("result");
        //已登录
        if (flog){//已登录
            this.cartService.updateCartCount(cartId,cartCount + 1);
        }else{//未登录
            //从session中获得购物车数据
            String cart = (String) session.getAttribute("cartList");
            //创建json
            Gson gson = new Gson();
            //json数据转化为list
            List<Cart> cartList = gson.fromJson(cart,new TypeToken<List<Cart>>(){}.getType());
            //遍历list
            Iterator<Cart> cartIterator = cartList.iterator();
            while(cartIterator.hasNext()){
                Cart cart2 = cartIterator.next();
                //判定是否存在一模一样的购物车数据
                if (cart2.getGoods().getGoodsId().equals(goodsId) && cart2.getInventory().getInventoryId().equals(inventoryId)){
                    //存在则更新数量
                    cart2.setCartCount(cartCount + 1);
                    break;
                }
            }
            String str = gson.toJson(cartList);
            //将数据加入到session中
            session.setAttribute("cartList",str);
        }
        return "true";
    }

    /**
     * 删除单个商品
     * @return
     */
    @RequestMapping(value = "/deleteCart")
    @ResponseBody
    public String deleteCart(@RequestParam(value = "cartId")Integer cartId,@RequestParam(value = "goodsId")Integer goodsId, @RequestParam(value = "inventoryId")Integer inventoryId, HttpSession session){
        //获取用户名
        String userName = (String) session.getAttribute("username");
        //检查是否登录
        Map<String,Object> map = this.utilService.checkUserName(userName);
        Boolean flog = (Boolean) map.get("result");
        //已登录
        if (flog){//已登录
            this.cartService.deleteCart(cartId);
        }else{//未登录
            //从session中获得购物车数据
            String cart = (String) session.getAttribute("cartList");
            //创建json
            Gson gson = new Gson();
            //json数据转化为list
            List<Cart> cartList = gson.fromJson(cart,new TypeToken<List<Cart>>(){}.getType());
            //遍历list
            Iterator<Cart> cartIterator = cartList.iterator();
            while(cartIterator.hasNext()){
                Cart cart2 = cartIterator.next();
                //判定是否存在一模一样的购物车数据
                if (cart2.getGoods().getGoodsId().equals(goodsId) && cart2.getInventory().getInventoryId().equals(inventoryId)){
                    //存在则更新数量
                    cartIterator.remove();
                    break;
                }
            }
            String str = gson.toJson(cartList);
            //将数据加入到session中
            session.setAttribute("cartList",str);
        }
        return "true";
    }

    /**
     * 删除单个商品并且添加进商品收藏
     * @return
     */
    @RequestMapping(value = "/deleteCartinsertGoodscollert")
    @ResponseBody
    public Map<String, Object> deleteCartinsertGoodscollert(@RequestParam(value = "cartId")Integer cartId, @RequestParam(value = "goodsId")Integer goodsId, HttpSession session){
        //获取用户名
        String userName = (String) session.getAttribute("username");
        //检查是否登录
        Map<String,Object> map = this.utilService.checkUserName(userName);
        Boolean flog = (Boolean) map.get("result");
        //已登录
        if (flog){//已登录
            //删除该购物车项目
            this.cartService.deleteCart(cartId);
            User user = this.userService.checkUserName(userName);
            Goodscollect goodscollect = this.goodscollectService.selectGoodscollectAndgoodsIduserId(goodsId,user.getUserId());
            //已收藏
            if (null != goodscollect){
                map.put("data","商品已删除，该商品已收藏！");
            }else{//未收藏
                Integer goodscollectId = this.utilService.UUID();
                this.goodscollectService.insertGoodscollect(goodscollectId,goodsId,user.getUserId());
                map.put("data","商品收藏成功！");
            }
        }
        return map;
    }

    /**
     * 删除多个商品
     * @return
     */
    @RequestMapping(value = "/deleteCartAll")
    @ResponseBody
    public String deleteCartAll(@RequestParam(value = "data[]")String[] data, HttpSession session){
        //获取用户名
        String userName = (String) session.getAttribute("username");
        //检查是否登录
        Map<String,Object> map = this.utilService.checkUserName(userName);
        Boolean flog = (Boolean) map.get("result");
        //已登录
        if (flog){//已登录
            for (String newdata:data
                 ) {
                Integer cartId = Integer.valueOf(newdata.split(",")[0]);
                this.cartService.deleteCart(cartId);
            }
        }else{//未登录
            //从session中获得购物车数据
            String cart = (String) session.getAttribute("cartList");
            //创建json
            Gson gson = new Gson();
            //json数据转化为list
            List<Cart> cartList = gson.fromJson(cart,new TypeToken<List<Cart>>(){}.getType());
            //遍历list
            Iterator<Cart> cartIterator = cartList.iterator();
            while(cartIterator.hasNext()){
                Cart cart2 = cartIterator.next();
                for (String newdata:data
                ) {
                    Integer goodsId = Integer.valueOf(newdata.split(",")[1]);
                    Integer inventoryId = Integer.valueOf(newdata.split(",")[2]);
                    //判定是否存在一模一样的购物车数据
                    if (cart2.getGoods().getGoodsId().equals(goodsId) && cart2.getInventory().getInventoryId().equals(inventoryId)){
                        //存在则更新数量
                        cartIterator.remove();
                        break;
                    }
                }
            }
            String str = gson.toJson(cartList);
            //将数据加入到session中
            session.setAttribute("cartList",str);
        }
        return "true";
    }

    /**
     * 删除单个商品
     * @return
     */
    @RequestMapping(value = "/deleteCartone")
    @ResponseBody
    public String deleteCartone(@RequestParam(value = "data[]")String data, HttpSession session){
        //获取用户名
        String userName = (String) session.getAttribute("username");
        //检查是否登录
        Map<String,Object> map = this.utilService.checkUserName(userName);
        Boolean flog = (Boolean) map.get("result");
        //已登录
        if (flog){//已登录
            Integer cartId = Integer.valueOf(data.split(",")[0]);
            this.cartService.deleteCart(cartId);
        }else{//未登录
            //从session中获得购物车数据
            String cart = (String) session.getAttribute("cartList");
            //创建json
            Gson gson = new Gson();
            //json数据转化为list
            List<Cart> cartList = gson.fromJson(cart,new TypeToken<List<Cart>>(){}.getType());
            //遍历list
            Iterator<Cart> cartIterator = cartList.iterator();
            while(cartIterator.hasNext()){
                Cart cart2 = cartIterator.next();
                Integer goodsId = Integer.valueOf(data.split(",")[1]);
                Integer inventoryId = Integer.valueOf(data.split(",")[2]);
                //判定是否存在一模一样的购物车数据
                if (cart2.getGoods().getGoodsId().equals(goodsId) && cart2.getInventory().getInventoryId().equals(inventoryId)){
                    //存在则更新数量
                    cartIterator.remove();
                    break;
                }
            }
            String str = gson.toJson(cartList);
            //将数据加入到session中
            session.setAttribute("cartList",str);
        }
        return "true";
    }

    /**
     * 删除多个商品并且添加进商品收藏
     * @return
     */
    @RequestMapping(value = "/insertGoodscollectAll")
    @ResponseBody
    public Map<String, Object> insertGoodscollectAll(@RequestParam(value = "data[]")String[] data, HttpSession session){
        //获取用户名
        String userName = (String) session.getAttribute("username");
        //检查是否登录
        Map<String,Object> map = this.utilService.checkUserName(userName);
        Boolean flog = (Boolean) map.get("result");
        //已登录
        if (flog){//已登录
            for (String newdata:data
                 ) {
                Integer cartId = Integer.valueOf(newdata.split(",")[0]);
                Integer goodsId = Integer.valueOf(newdata.split(",")[1]);
                //删除该购物车项目
                this.cartService.deleteCart(cartId);
                User user = this.userService.checkUserName(userName);
                Goodscollect goodscollect = this.goodscollectService.selectGoodscollectAndgoodsIduserId(goodsId,user.getUserId());
                //未收藏
                if (null == goodscollect){
                    Integer goodscollectId = this.utilService.UUID();
                    this.goodscollectService.insertGoodscollect(goodscollectId,goodsId,user.getUserId());
                }
            }
            map.put("data","商品收藏成功！");
        }
        return map;
    }

    /**
     * 删除单个商品并且添加进商品收藏
     * @return
     */
    @RequestMapping(value = "/insertGoodscollectone")
    @ResponseBody
    public Map<String, Object> insertGoodscollectone(@RequestParam(value = "data[]")String data, HttpSession session){
        //获取用户名
        String userName = (String) session.getAttribute("username");
        //检查是否登录
        Map<String,Object> map = this.utilService.checkUserName(userName);
        Boolean flog = (Boolean) map.get("result");
        //已登录
        if (flog){//已登录
            Integer cartId = Integer.valueOf(data.split(",")[0]);
            Integer goodsId = Integer.valueOf(data.split(",")[1]);
            //删除该购物车项目
            this.cartService.deleteCart(cartId);
            User user = this.userService.checkUserName(userName);
            Goodscollect goodscollect = this.goodscollectService.selectGoodscollectAndgoodsIduserId(goodsId,user.getUserId());
            //未收藏
            if (null == goodscollect){
                Integer goodscollectId = this.utilService.UUID();
                this.goodscollectService.insertGoodscollect(goodscollectId,goodsId,user.getUserId());
            }
            map.put("data","商品收藏成功！");
        }
        return map;
    }


    /**
     * 订单再次添加购物车
     * @return
     */
    @RequestMapping(value = "/insertCartone")
    @ResponseBody
    public Map<String,Object> insertCartone(@RequestParam(value = "data[]")String data,HttpSession session) {
        //获取用户名
        String userName = (String) session.getAttribute("username");
        //检查是否登录
        Map<String,Object> map = this.utilService.checkUserName(userName);
        Boolean flog = (Boolean) map.get("result");
        //已登录
        if (flog) {//已登录
            //获得user对象
            User user = this.userService.checkUserName(userName);
            commonalityInsertCart(data,user);
        }
        return map;
    }

    /**
     * 订单再次添加购物车
     * @return
     */
    @RequestMapping(value = "/insertCartAll")
    @ResponseBody
    public Map<String,Object> insertCartAll(@RequestParam(value = "data[]")String[] data,HttpSession session) {
        //获取用户名
        String userName = (String) session.getAttribute("username");
        //检查是否登录
        Map<String,Object> map = this.utilService.checkUserName(userName);
        Boolean flog = (Boolean) map.get("result");
        //已登录
        if (flog) {//已登录
            //获得user对象
            User user = this.userService.checkUserName(userName);
            for (String str:data
                 ) {
                commonalityInsertCart(str,user);
            }
        }
        return map;
    }

    private void commonalityInsertCart(String str,User user){
        Integer goodsId = Integer.valueOf(str.split(",")[0]);
        Integer inventoryId = Integer.valueOf(str.split(",")[1]);
        Integer cartCount = Integer.valueOf(str.split(",")[2]);
//            获得cart对象
        Cart cart = this.cartService.selectCartOne(user.getUserId(), goodsId, inventoryId);
        //判定购物车中是否存在该cart对象
        if (null != cart) {//已存在
            //获得新的数量
            Integer newcartCount = cartCount + cart.getCartCount();
            //更新数据库中购物车的商品数量
            this.cartService.updateCartCount(cart.getCartId(), newcartCount);
        } else {//不存在
            //随机生成编号
            Integer cartId = this.utilService.UUID();
            //新建新的购物车信息
            this.cartService.insertCart(cartId, cartCount, goodsId, inventoryId, user.getUserId());
        }
    }
}
