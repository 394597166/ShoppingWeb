package com.cheer.shoppingwebcategory.service.impl;

import com.cheer.shoppingwebcategory.dao.SubclassificationMapper;
import com.cheer.shoppingwebcategory.model.Subclassification;
import com.cheer.shoppingwebcategory.service.SubclassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务处理
 * @author Lean
 */
@Service
public class SubclassificationServiceImpl implements SubclassificationService {
    //依赖注入
    @Autowired
    private SubclassificationMapper subclassificationMapper;

    @Override
    public List<Subclassification> selectSubclassificationAndcategoryId(Integer categoryId){
        return this.subclassificationMapper.selectSubclassificationAndcategoryId(categoryId);
    }
}
