package com.awise.storage.service.impl;

import com.awise.storage.domain.AwCustomersuppliedmaterialsEn;
import com.awise.storage.mapper.AwCustomersuppliedmaterialsEnMapper;
import com.awise.storage.service.IAwCustomersuppliedmaterialsEnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 客供材料实时库存Service业务层处理
 * 
 * @author awise
 * @date 2023-08-03
 */
@Service
public class AwCustomersuppliedmaterialsEnServiceImpl implements IAwCustomersuppliedmaterialsEnService 
{
    @Autowired
    private AwCustomersuppliedmaterialsEnMapper awCustomersuppliedmaterialsEnMapper;

    /**
     * 查询客供材料实时库存列表
     * 
     * @param awCustomersuppliedmaterialsEn 客供材料实时库存
     * @return 客供材料实时库存
     */
    @Override
    public List<AwCustomersuppliedmaterialsEn> selectAwCustomersuppliedmaterialsEnList(AwCustomersuppliedmaterialsEn awCustomersuppliedmaterialsEn)
    {
        return awCustomersuppliedmaterialsEnMapper.selectAwCustomersuppliedmaterialsEnList(awCustomersuppliedmaterialsEn);
    }

}
