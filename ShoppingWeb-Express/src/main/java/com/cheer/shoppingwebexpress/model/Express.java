package com.cheer.shoppingwebexpress.model;

/**
 * 快递公司表
 */
public class Express {
//    快递公司编号
    private Integer expressId;
//    快递公司名
    private String expressName;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Express{");
        sb.append("expressId=").append(expressId);
        sb.append(", expressName='").append(expressName).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Integer getExpressId() {
        return expressId;
    }

    public void setExpressId(Integer expressId) {
        this.expressId = expressId;
    }

    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName;
    }
}
