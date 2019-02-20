package com.cheer.shoppingwebgoods.model;

/**
 * 商品评论
 */
public class Commentgoods {
//    商品评论编号
    private Integer commentgoodsId;
//    用户名
    private String userName;
//    商品评论内容
    private String commentgoodsConten;
//    商品规格
    private String commentgoodsSpecification;
//    商品评论时间
    private String commentgoodsTime;
//    商品评论信息（好评、中评、差评）
    private String commentgoodsInfo;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Commentgoods{");
        sb.append("commentgoodsId=").append(commentgoodsId);
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", commentgoodsConten='").append(commentgoodsConten).append('\'');
        sb.append(", commentgoodsSpecification='").append(commentgoodsSpecification).append('\'');
        sb.append(", commentgoodsTime='").append(commentgoodsTime).append('\'');
        sb.append(", commentgoodsInfo='").append(commentgoodsInfo).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Integer getCommentgoodsId() {
        return commentgoodsId;
    }

    public void setCommentgoodsId(Integer commentgoodsId) {
        this.commentgoodsId = commentgoodsId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCommentgoodsConten() {
        return commentgoodsConten;
    }

    public void setCommentgoodsConten(String commentgoodsConten) {
        this.commentgoodsConten = commentgoodsConten;
    }

    public String getCommentgoodsSpecification() {
        return commentgoodsSpecification;
    }

    public void setCommentgoodsSpecification(String commentgoodsSpecification) {
        this.commentgoodsSpecification = commentgoodsSpecification;
    }

    public String getCommentgoodsTime() {
        return commentgoodsTime;
    }

    public void setCommentgoodsTime(String commentgoodsTime) {
        this.commentgoodsTime = commentgoodsTime;
    }

    public String getCommentgoodsInfo() {
        return commentgoodsInfo;
    }

    public void setCommentgoodsInfo(String commentgoodsInfo) {
        this.commentgoodsInfo = commentgoodsInfo;
    }
}
