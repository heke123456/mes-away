package com.awise.storage.mapper;

import java.util.List;
import com.awise.storage.domain.AwDetailcustomermaterialsstorage;

/**
 * 客供材料入库详细Mapper接口
 * 
 * @author awise
 * @date 2024-04-21
 */
public interface AwDetailcustomermaterialsstorageMapper 
{
    /**
     * 查询客供材料入库详细
     * 
     * @param id 客供材料入库详细主键
     * @return 客供材料入库详细
     */
    public AwDetailcustomermaterialsstorage selectAwDetailcustomermaterialsstorageById(Long id);

    /**
     * 查询客供材料入库详细列表
     * 
     * @param awDetailcustomermaterialsstorage 客供材料入库详细
     * @return 客供材料入库详细集合
     */
    public List<AwDetailcustomermaterialsstorage> selectAwDetailcustomermaterialsstorageList(AwDetailcustomermaterialsstorage awDetailcustomermaterialsstorage);

    /**
     * 新增客供材料入库详细
     * 
     * @param awDetailcustomermaterialsstorage 客供材料入库详细
     * @return 结果
     */
    public int insertAwDetailcustomermaterialsstorage(AwDetailcustomermaterialsstorage awDetailcustomermaterialsstorage);

    /**
     * 修改客供材料入库详细
     * 
     * @param awDetailcustomermaterialsstorage 客供材料入库详细
     * @return 结果
     */
    public int updateAwDetailcustomermaterialsstorage(AwDetailcustomermaterialsstorage awDetailcustomermaterialsstorage);

    /**
     * 删除客供材料入库详细
     * 
     * @param id 客供材料入库详细主键
     * @return 结果
     */
    public int deleteAwDetailcustomermaterialsstorageById(Long id);

    /**
     * 批量删除客供材料入库详细
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwDetailcustomermaterialsstorageByIds(Long[] ids);
}
