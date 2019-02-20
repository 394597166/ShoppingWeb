package com.cheer.shoppingweb.controller;


import com.cheer.shoppingweb.service.ListPageUtil;
import com.cheer.shoppingwebgoods.model.Goods;
import com.cheer.shoppingwebgoods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    /**
     * 打开地址页面
     * @return
     */
    @RequestMapping(value = "/goods.html")
    public String goods(){
        return "goods";
    }

    /**
     * 打开商品分页页面
     * @return
     */
    @RequestMapping(value = "/goodsPaging.html")
    public String goodsPaging(){
        return "goodsPaging";
    }

    /**
     * 获得商品编号
     * @param goodsId
     * @return
     */
    @RequestMapping(value = "/goods")
    public String goods(@RequestParam(value = "goodsId")Integer goodsId, HttpSession session){
        session.setAttribute("goodsId",goodsId);
        return "redirect:http://localhost:8080/goods/goods.html";
    }

    /**
     * 获得商品信息
     * @return
     */
    @RequestMapping(value = "/selectGoods")
    @ResponseBody
    public Goods goods( HttpSession session){
        Integer goodsId = (Integer) session.getAttribute("goodsId");
        Goods goods = this.goodsService.selectGoodsAndId(goodsId,"上架");
        return goods;
    }

    /**
     * 搜索商品
     * @return
     */
    @RequestMapping(value = "/selectgoods")
    @ResponseBody
    public String selectgoods(@RequestParam(value = "goodsName")String str, HttpSession session){
        String goodsName = "%"+str+"%";
        List<Goods> goodsList = this.goodsService.selectAllGoodsLikeName(goodsName);
        session.setAttribute("goodsList",goodsList);
        return "true";
    }

    /**
     * 获得商品信息
     * @return
     */
    @RequestMapping(value = "/goodspage")
    @ResponseBody
    public Map<String,Object> goodspage(HttpSession session){
        Map<String,Object> map = new HashMap<>();
        List<Goods> goodsList = (List<Goods>) session.getAttribute("goodsList");
        map.put("goodsList",goodsList);
        return map;
    }

    /**
     * 获得商品信息
     * @return
     */
    @RequestMapping(value = "/goodspageWithnowPage")
    @ResponseBody
    public Map<String,Object> goodspageWithnowPage(@RequestParam(value = "nowPage")Integer nowPage, HttpSession session){
        Map<String,Object> map = new HashMap<>();
        List<Goods> list = (List<Goods>) session.getAttribute("goodsList");
        if (list.size() != 0 && null != list){
            ListPageUtil<Goods> listPageUtil = new ListPageUtil<Goods>(list,nowPage, 20);
            List<Goods> goodsList = listPageUtil.getPagedList();
            map.put("goodsList",goodsList);
        }else{
            map.put("goodsList",list);
        }
        return map;
    }

    /**
     * 搜索商品
     * @return
     */
    @RequestMapping(value = "/selectgoodsAndCategoryId")
    @ResponseBody
    public String selectgoodsAndCategoryId(@RequestParam(value = "categoryId")Integer categoryId, HttpSession session){
        List<Goods> goodsList = this.goodsService.selectgoodsAndCategoryId(categoryId);
        session.setAttribute("goodsList",goodsList);
        return "true";
    }

    /**
     * 搜索商品
     * @return
     */
    @RequestMapping(value = "/selectgoodsAndSubclassificationId")
    @ResponseBody
    public String selectgoodsAndSubclassificationId(@RequestParam(value = "subclassificationId")Integer subclassificationId, HttpSession session){
        List<Goods> goodsList = this.goodsService.selectgoodsAndsubclassificationId(subclassificationId);
        session.setAttribute("goodsList",goodsList);
        return "true";
    }

    /**
     * 搜索商品
     * @return
     */
    @RequestMapping(value = "/selectgoodsAndSubseriesId")
    @ResponseBody
    public String selectgoodsAndSubseriesId(@RequestParam(value = "subseriesId")Integer subseriesId, HttpSession session){
        List<Goods> goodsList = this.goodsService.selectgoodsAndsubseriesId(subseriesId);
        session.setAttribute("goodsList",goodsList);
        return "true";
    }
}
