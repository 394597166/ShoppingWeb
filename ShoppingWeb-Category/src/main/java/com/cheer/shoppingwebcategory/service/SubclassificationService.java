package com.cheer.shoppingwebcategory.service;

import com.cheer.shoppingwebcategory.model.Subclassification;

import java.util.List;

public interface SubclassificationService {
    /**
     * 通过分类编号获得子类对象
     * @param categoryId
     * @return
     */
    List<Subclassification> selectSubclassificationAndcategoryId(Integer categoryId);
}
