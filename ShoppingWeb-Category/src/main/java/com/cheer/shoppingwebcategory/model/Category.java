package com.cheer.shoppingwebcategory.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

//解决json序列化问题（对象中存在其他对象时需要）
@JsonIgnoreProperties(value = { "handler" })
public class Category {
//    商品分类编号
    private Integer categoryId;
//    商品分类名
    private String categoryName;
//    分类子类注入
    private List<Subclassification> subclassificationList;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Category{");
        sb.append("categoryId=").append(categoryId);
        sb.append(", categoryName='").append(categoryName).append('\'');
        sb.append(", subclassificationList=").append(subclassificationList);
        sb.append('}');
        return sb.toString();
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Subclassification> getSubclassificationList() {
        return subclassificationList;
    }

    public void setSubclassificationList(List<Subclassification> subclassificationList) {
        this.subclassificationList = subclassificationList;
    }
}
