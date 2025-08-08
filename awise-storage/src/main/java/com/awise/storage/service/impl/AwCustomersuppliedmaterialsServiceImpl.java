package com.awise.storage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.storage.mapper.AwCustomersuppliedmaterialsMapper;
import com.awise.storage.domain.AwCustomersuppliedmaterials;
import com.awise.storage.service.IAwCustomersuppliedmaterialsService;

/**
 * 客供材料实时库存Service业务层处理
 * 
 * @author awise
 * @date 2023-12-27
 */
@Service
public class AwCustomersuppliedmaterialsServiceImpl implements IAwCustomersuppliedmaterialsService 
{
    @Autowired
    private AwCustomersuppliedmaterialsMapper awCustomersuppliedmaterialsMapper;

    /**
     * 查询客供材料实时库存
     * 
     * @param id 客供材料实时库存主键
     * @return 客供材料实时库存
     */
    @Override
    public AwCustomersuppliedmaterials selectAwCustomersuppliedmaterialsById(Long id)
    {
        return awCustomersuppliedmaterialsMapper.selectAwCustomersuppliedmaterialsById(id);
    }

    /**
     * 查询客供材料实时库存列表
     * 
     * @param awCustomersuppliedmaterials 客供材料实时库存
     * @return 客供材料实时库存
     */
    @Override
    public List<AwCustomersuppliedmaterials> selectAwCustomersuppliedmaterialsList(AwCustomersuppliedmaterials awCustomersuppliedmaterials)
    {
        return awCustomersuppliedmaterialsMapper.selectAwCustomersuppliedmaterialsList(awCustomersuppliedmaterials);
    }

    /**
     * 新增客供材料实时库存
     * 
     * @param awCustomersuppliedmaterials 客供材料实时库存
     * @return 结果
     */
    @Override
    public int insertAwCustomersuppliedmaterials(AwCustomersuppliedmaterials awCustomersuppliedmaterials)
    {
        return awCustomersuppliedmaterialsMapper.insertAwCustomersuppliedmaterials(awCustomersuppliedmaterials);
    }

    /**
     * 修改客供材料实时库存
     * 
     * @param awCustomersuppliedmaterials 客供材料实时库存
     * @return 结果
     */
    @Override
    public int updateAwCustomersuppliedmaterials(AwCustomersuppliedmaterials awCustomersuppliedmaterials)
    {
        return awCustomersuppliedmaterialsMapper.updateAwCustomersuppliedmaterials(awCustomersuppliedmaterials);
    }

    /**
     * 批量删除客供材料实时库存
     * 
     * @param ids 需要删除的客供材料实时库存主键
     * @return 结果
     */
    @Override
    public int deleteAwCustomersuppliedmaterialsByIds(Long[] ids)
    {
        return awCustomersuppliedmaterialsMapper.deleteAwCustomersuppliedmaterialsByIds(ids);
    }

    /**
     * 删除客供材料实时库存信息
     * 
     * @param id 客供材料实时库存主键
     * @return 结果
     */
    @Override
    public int deleteAwCustomersuppliedmaterialsById(Long id)
    {
        return awCustomersuppliedmaterialsMapper.deleteAwCustomersuppliedmaterialsById(id);
    }
}
