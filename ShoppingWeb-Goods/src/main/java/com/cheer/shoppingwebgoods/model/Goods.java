package com.cheer.shoppingwebgoods.model;


import com.cheer.shoppingwebcategory.model.Category;
import com.cheer.shoppingwebcategory.model.Subclassification;
import com.cheer.shoppingwebcategory.model.Subseries;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * 商品
 */
//解决json序列化问题（对象中存在其他对象时需要）
@JsonIgnoreProperties(value = { "handler" })
public class Goods {
//    商品编号
    private Integer goodsId;
//    商品名称
    private String goodsName;
//    商品规格
    private String goodsSpecification;
//    商品描述
    private String goodsDescribe;
//    商品单价
    private Double goodsPrice;
//    商品会员单价
    private Double goodsVipPrice;
//    商品分类（1对1）
    private Category category;
//    商品子分类(1对1)
    private Subclassification subclassification;
//    商品次分类（1对1）
    private Subseries subseries;
//    商品状态(上架、下架)
    private String goodsState;
//    商品库存
    private List<Inventory> inventoryList;
//    商品图片
    private List<Picture> pictureList;
//    商品详细图片
    private List<Picturegoods> picturegoodsList;
//    商品评论
    private List<Commentgoods> commentgoodsList;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Goods{");
        sb.append("goodsId=").append(goodsId);
        sb.append(", goodsName='").append(goodsName).append('\'');
        sb.append(", goodsSpecification='").append(goodsSpecification).append('\'');
        sb.append(", goodsDescribe='").append(goodsDescribe).append('\'');
        sb.append(", goodsPrice=").append(goodsPrice);
        sb.append(", goodsVipPrice=").append(goodsVipPrice);
        sb.append(", category=").append(category);
        sb.append(", subclassification=").append(subclassification);
        sb.append(", subseries=").append(subseries);
        sb.append(", goodsState='").append(goodsState).append('\'');
        sb.append(", inventoryList=").append(inventoryList);
        sb.append(", pictureList=").append(pictureList);
        sb.append(", picturegoodsList=").append(picturegoodsList);
        sb.append(", commentgoodsList=").append(commentgoodsList);
        sb.append('}');
        return sb.toString();
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsDescribe() {
        return goodsDescribe;
    }

    public void setGoodsDescribe(String goodsDescribe) {
        this.goodsDescribe = goodsDescribe;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Double getGoodsVipPrice() {
        return goodsVipPrice;
    }

    public void setGoodsVipPrice(Double goodsVipPrice) {
        this.goodsVipPrice = goodsVipPrice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Subclassification getSubclassification() {
        return subclassification;
    }

    public void setSubclassification(Subclassification subclassification) {
        this.subclassification = subclassification;
    }

    public String getGoodsSpecification() {
        return goodsSpecification;
    }

    public void setGoodsSpecification(String goodsSpecification) {
        this.goodsSpecification = goodsSpecification;
    }

    public Subseries getSubseries() {
        return subseries;
    }

    public void setSubseries(Subseries subseries) {
        this.subseries = subseries;
    }

    public String getGoodsState() {
        return goodsState;
    }

    public void setGoodsState(String goodsState) {
        this.goodsState = goodsState;
    }

    public List<Inventory> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(List<Inventory> inventoryList) {
        this.inventoryList = inventoryList;
    }

    public List<Picture> getPictureList() {
        return pictureList;
    }

    public void setPictureList(List<Picture> pictureList) {
        this.pictureList = pictureList;
    }

    public List<Picturegoods> getPicturegoodsList() {
        return picturegoodsList;
    }

    public void setPicturegoodsList(List<Picturegoods> picturegoodsList) {
        this.picturegoodsList = picturegoodsList;
    }

    public List<Commentgoods> getCommentgoodsList() {
        return commentgoodsList;
    }

    public void setCommentgoodsList(List<Commentgoods> commentgoodsList) {
        this.commentgoodsList = commentgoodsList;
    }
}
