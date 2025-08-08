package com.awise.storage.mapper;

import com.awise.storage.domain.AwCustomersuppliedmaterialsEn;

import java.util.List;

/**
 * 客供材料实时库存Mapper接口
 * 
 * @author awise
 * @date 2023-08-03
 */
public interface AwCustomersuppliedmaterialsEnMapper
{
    /**
     * 查询客供材料实时库存列表
     * 
     * @param awCustomersuppliedmaterialsEn 客供材料实时库存
     * @return 客供材料实时库存集合
     */
    public List<AwCustomersuppliedmaterialsEn> selectAwCustomersuppliedmaterialsEnList(AwCustomersuppliedmaterialsEn awCustomersuppliedmaterialsEn);
}
