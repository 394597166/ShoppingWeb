package com.cheer.shoppingwebcategory.dao;

import com.cheer.shoppingwebcategory.model.Subseries;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SubseriesMapper {
    /**
     * 返回所有分类
     * @return
     */
    List<Subseries> SubseriesAll();

    /**
     * 通过次类编号获得次类对象
     * @param subseriesId
     * @return
     */
    Subseries selectSubseries(@Param("subseriesId")Integer subseriesId);

    /**
     * 通过subclassificationId获得所有分类
     * @param subclassificationId
     * @return
     */
    List<Subseries> selectSubseriesAndSubclassificationId(@Param("subclassificationId")Integer subclassificationId);
}
