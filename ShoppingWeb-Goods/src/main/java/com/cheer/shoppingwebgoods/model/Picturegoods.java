package com.cheer.shoppingwebgoods.model;

/**
 * 商品详细图片
 */
public class Picturegoods {
//    商品详细图片编号
    private Integer picturegoodsId;
//    商品详细图片地址
    private String picturegoodsPic;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Picturegoods{");
        sb.append("picturegoodsId=").append(picturegoodsId);
        sb.append(", picturegoodsPic='").append(picturegoodsPic).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Integer getPicturegoodsId() {
        return picturegoodsId;
    }

    public void setPicturegoodsId(Integer picturegoodsId) {
        this.picturegoodsId = picturegoodsId;
    }

    public String getPicturegoodsPic() {
        return picturegoodsPic;
    }

    public void setPicturegoodsPic(String picturegoodsPic) {
        this.picturegoodsPic = picturegoodsPic;
    }
}
