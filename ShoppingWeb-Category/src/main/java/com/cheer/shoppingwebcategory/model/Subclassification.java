package com.cheer.shoppingwebcategory.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

//解决json序列化问题（对象中存在其他对象时需要）
@JsonIgnoreProperties(value = { "handler" })
public class Subclassification {
//    商品子分类编号
    private Integer subclassificationId;
//    商品子分类名
    private String subclassificationName;
//    分类次类注入
    private List<Subseries> subseriesList;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Subclassification{");
        sb.append("subclassificationId=").append(subclassificationId);
        sb.append(", subclassificationName='").append(subclassificationName).append('\'');
        sb.append(", subseriesList=").append(subseriesList);
        sb.append('}');
        return sb.toString();
    }

    public Integer getSubclassificationId() {
        return subclassificationId;
    }

    public void setSubclassificationId(Integer subclassificationId) {
        this.subclassificationId = subclassificationId;
    }

    public String getSubclassificationName() {
        return subclassificationName;
    }

    public void setSubclassificationName(String subclassificationName) {
        this.subclassificationName = subclassificationName;
    }

    public List<Subseries> getSubseriesList() {
        return subseriesList;
    }

    public void setSubseriesList(List<Subseries> subseriesList) {
        this.subseriesList = subseriesList;
    }
}
