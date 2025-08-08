package com.awise.storage.mapper;

import java.util.List;
import com.awise.storage.domain.AwCustomermaterialsinventory;

/**
 * 客供材料实时库存Mapper接口
 * 
 * @author awise
 * @date 2024-04-22
 */
public interface AwCustomermaterialsinventoryMapper 
{
    /**
     * 查询客供材料实时库存
     * 
     * @param id 客供材料实时库存主键
     * @return 客供材料实时库存
     */
    public AwCustomermaterialsinventory selectAwCustomermaterialsinventoryById(Long id);

    /**
     * 查询客供材料实时库存列表
     * 
     * @param awCustomermaterialsinventory 客供材料实时库存
     * @return 客供材料实时库存集合
     */
    public List<AwCustomermaterialsinventory> selectAwCustomermaterialsinventoryList(AwCustomermaterialsinventory awCustomermaterialsinventory);

    /**
     * 新增客供材料实时库存
     * 
     * @param awCustomermaterialsinventory 客供材料实时库存
     * @return 结果
     */
    public int insertAwCustomermaterialsinventory(AwCustomermaterialsinventory awCustomermaterialsinventory);

    /**
     * 修改客供材料实时库存
     * 
     * @param awCustomermaterialsinventory 客供材料实时库存
     * @return 结果
     */
    public int updateAwCustomermaterialsinventory(AwCustomermaterialsinventory awCustomermaterialsinventory);

    /**
     * 删除客供材料实时库存
     * 
     * @param id 客供材料实时库存主键
     * @return 结果
     */
    public int deleteAwCustomermaterialsinventoryById(Long id);

    /**
     * 批量删除客供材料实时库存
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwCustomermaterialsinventoryByIds(Long[] ids);
}
