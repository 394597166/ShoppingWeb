package com.cheer.shoppingwebcategory.model;

public class Subseries {
//    商品次分类编号
    private Integer subseriesId;
//    商品次分类名
    private String subseriesName;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Subseries{");
        sb.append("subseriesId=").append(subseriesId);
        sb.append(", subseriesName='").append(subseriesName).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Integer getSubseriesId() {
        return subseriesId;
    }

    public void setSubseriesId(Integer subseriesId) {
        this.subseriesId = subseriesId;
    }

    public String getSubseriesName() {
        return subseriesName;
    }

    public void setSubseriesName(String subseriesName) {
        this.subseriesName = subseriesName;
    }
}
