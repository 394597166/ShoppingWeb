package com.cheer.shoppingwebcategory.service;

import com.cheer.shoppingwebcategory.model.Category;

import java.util.List;

public interface CategoryService {
    /**
     * 返回所有分类
     * @return
     */
    List<Category> CategoryAll();
}
