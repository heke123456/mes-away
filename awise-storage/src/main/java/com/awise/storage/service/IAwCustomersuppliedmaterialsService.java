package com.awise.storage.service;

import java.util.List;
import com.awise.storage.domain.AwCustomersuppliedmaterials;

/**
 * 客供材料实时库存Service接口
 * 
 * @author awise
 * @date 2023-12-27
 */
public interface IAwCustomersuppliedmaterialsService 
{
    /**
     * 查询客供材料实时库存
     * 
     * @param id 客供材料实时库存主键
     * @return 客供材料实时库存
     */
    public AwCustomersuppliedmaterials selectAwCustomersuppliedmaterialsById(Long id);

    /**
     * 查询客供材料实时库存列表
     * 
     * @param awCustomersuppliedmaterials 客供材料实时库存
     * @return 客供材料实时库存集合
     */
    public List<AwCustomersuppliedmaterials> selectAwCustomersuppliedmaterialsList(AwCustomersuppliedmaterials awCustomersuppliedmaterials);

    /**
     * 新增客供材料实时库存
     * 
     * @param awCustomersuppliedmaterials 客供材料实时库存
     * @return 结果
     */
    public int insertAwCustomersuppliedmaterials(AwCustomersuppliedmaterials awCustomersuppliedmaterials);

    /**
     * 修改客供材料实时库存
     * 
     * @param awCustomersuppliedmaterials 客供材料实时库存
     * @return 结果
     */
    public int updateAwCustomersuppliedmaterials(AwCustomersuppliedmaterials awCustomersuppliedmaterials);

    /**
     * 批量删除客供材料实时库存
     * 
     * @param ids 需要删除的客供材料实时库存主键集合
     * @return 结果
     */
    public int deleteAwCustomersuppliedmaterialsByIds(Long[] ids);

    /**
     * 删除客供材料实时库存信息
     * 
     * @param id 客供材料实时库存主键
     * @return 结果
     */
    public int deleteAwCustomersuppliedmaterialsById(Long id);
}
