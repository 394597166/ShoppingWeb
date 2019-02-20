package com.cheer.shoppingwebgoods.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 商品图片
 */
//解决json序列化问题（对象中存在其他对象时需要）
@JsonIgnoreProperties(value = { "handler" })
public class Picture {
//    商品图片编号
    private Integer pictureId;
//    商品图片地址
    private String picturePic;
//    商品大图
    private Bigpicture bigpicture;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Picture{");
        sb.append("pictureId=").append(pictureId);
        sb.append(", picturePic='").append(picturePic).append('\'');
        sb.append(", bigpicture=").append(bigpicture);
        sb.append('}');
        return sb.toString();
    }

    public Bigpicture getBigpicture() {
        return bigpicture;
    }

    public void setBigpicture(Bigpicture bigpicture) {
        this.bigpicture = bigpicture;
    }

    public Integer getPictureId() {
        return pictureId;
    }

    public void setPictureId(Integer pictureId) {
        this.pictureId = pictureId;
    }

    public String getPicturePic() {
        return picturePic;
    }

    public void setPicturePic(String picturePic) {
        this.picturePic = picturePic;
    }
}
