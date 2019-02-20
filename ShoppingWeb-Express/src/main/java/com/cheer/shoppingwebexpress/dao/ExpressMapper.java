package com.cheer.shoppingwebexpress.dao;


import com.cheer.shoppingwebexpress.model.Express;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExpressMapper {
    /**
     * 通过快递公司编号获得快递公司对象(单个)
     * @param expressId
     * @return
     */
    Express selectExpressOne(@Param("expressId") Integer expressId);

    /**
     * 获得所有快递公司对象(多个)
     * @return
     */
    List<Express> selectExpressAll();
}
