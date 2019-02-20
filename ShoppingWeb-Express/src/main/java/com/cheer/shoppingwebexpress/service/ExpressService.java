package com.cheer.shoppingwebexpress.service;

import com.cheer.shoppingwebexpress.model.Express;

import java.util.List;

public interface ExpressService {
    /**
     * 通过快递公司编号获得快递公司对象(单个)
     * @param expressId
     * @return
     */
    Express selectExpressOne(Integer expressId);

    /**
     * 获得所有快递公司对象(多个)
     * @return
     */
    List<Express> selectExpressAll();
}
