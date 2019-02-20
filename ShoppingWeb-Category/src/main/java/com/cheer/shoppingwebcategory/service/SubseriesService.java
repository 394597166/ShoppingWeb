package com.cheer.shoppingwebcategory.service;

import com.cheer.shoppingwebcategory.model.Subseries;

import java.util.List;

public interface SubseriesService {
    /**
     * 通过subclassificationId获得所有分类
     * @param subclassificationId
     * @return
     */
    List<Subseries> selectSubseriesAndSubclassificationId(Integer subclassificationId);
}
