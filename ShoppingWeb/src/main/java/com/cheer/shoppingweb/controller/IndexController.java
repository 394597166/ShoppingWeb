package com.cheer.shoppingweb.controller;


import com.cheer.shoppingwebcategory.model.Category;
import com.cheer.shoppingwebcategory.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class IndexController {
    //依赖注入
    @Autowired
    private CategoryService categoryService;
    /**
     * 打开首页
     * @return
     */
    @RequestMapping(value = "/index.html")
    public String index(){
        return "index";
    }

    /**
     * 获得分类数据
     */
    @RequestMapping(value = "/category")
    @ResponseBody
    public List<Category> category(){
        List<Category> categoryList = this.categoryService.CategoryAll();
        return categoryList;
    }
}
