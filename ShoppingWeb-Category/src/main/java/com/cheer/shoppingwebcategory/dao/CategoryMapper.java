package com.cheer.shoppingwebcategory.dao;

import com.cheer.shoppingwebcategory.model.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryMapper {
    /**
     * 返回所有分类
     * @return
     */
    List<Category> CategoryAll();

    /**
     * 通过商品分类编号获得分类对象
     * @param categoryId
     * @return
     */
    Category selectCategory(@Param("categoryId")Integer categoryId);
}
