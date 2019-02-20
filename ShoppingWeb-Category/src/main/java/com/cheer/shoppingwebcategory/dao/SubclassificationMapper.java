package com.cheer.shoppingwebcategory.dao;

import com.cheer.shoppingwebcategory.model.Subclassification;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SubclassificationMapper {
    /**
     * 返回所有分类
     * @return
     */
    List<SubclassificationMapper> SubclassificationMapperAll();

    /**
     * 通过子类编号获得子类对象
     * @param subclassificationId
     * @return
     */
    Subclassification selectSubclassification(@Param("subclassificationId")Integer subclassificationId);

    /**
     * 通过分类编号获得子类对象
     * @param categoryId
     * @return
     */
    List<Subclassification> selectSubclassificationAndcategoryId(@Param("categoryId")Integer categoryId);
}
