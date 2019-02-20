package com.cheer.shoppingwebcategory.service.impl;

import com.cheer.shoppingwebcategory.dao.SubseriesMapper;
import com.cheer.shoppingwebcategory.model.Subseries;
import com.cheer.shoppingwebcategory.service.SubseriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务处理
 * @author Lean
 */
@Service
public class SubseriesServiceImpl implements SubseriesService {
    //依赖注入
    @Autowired
    private SubseriesMapper subseriesMapper;

    @Override
    public List<Subseries> selectSubseriesAndSubclassificationId(Integer subclassificationId){
        return this.subseriesMapper.selectSubseriesAndSubclassificationId(subclassificationId);
    }
}
