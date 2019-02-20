package com.cheer.shoppingwebgoods.model;

/**
 * 商品大图
 */
public class Bigpicture {
//    商品图片编号
    private Integer bigpictureId;
//    商品图片地址
    private String bigpicturePic;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Bigpicture{");
        sb.append("bigpictureId=").append(bigpictureId);
        sb.append(", bigpicturePic='").append(bigpicturePic).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Integer getBigpictureId() {
        return bigpictureId;
    }

    public void setBigpictureId(Integer bigpictureId) {
        this.bigpictureId = bigpictureId;
    }

    public String getBigpicturePic() {
        return bigpicturePic;
    }

    public void setBigpicturePic(String bigpicturePic) {
        this.bigpicturePic = bigpicturePic;
    }
}
