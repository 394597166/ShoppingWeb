package com.cheer.shoppingwebcategory.service.impl;

import com.cheer.shoppingwebcategory.dao.CategoryMapper;
import com.cheer.shoppingwebcategory.model.Category;
import com.cheer.shoppingwebcategory.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 业务处理
 * @author Lean
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    //依赖注入
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> CategoryAll(){
        List<Category> categoryList = this.categoryMapper.CategoryAll();
        return categoryList;
    }

}
