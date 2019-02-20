package com.cheer.shoppingwebexpress.service.impl;

import com.cheer.shoppingwebexpress.dao.ExpressMapper;
import com.cheer.shoppingwebexpress.model.Express;
import com.cheer.shoppingwebexpress.service.ExpressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务处理
 * @author Lean
 */
@Service
public class ExpressServiceImpl implements ExpressService {
    //依赖注入
    @Autowired
    private ExpressMapper expressMapper;

    @Override
    public Express selectExpressOne(Integer expressId){
        return this.expressMapper.selectExpressOne(expressId);
    }

    @Override
    public List<Express> selectExpressAll(){
        return this.expressMapper.selectExpressAll();
    }

}
