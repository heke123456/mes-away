package com.awise.storage.mapper;

import java.util.List;
import com.awise.storage.domain.AwCustomermaterialsstorage;

/**
 * 客供入库Mapper接口
 * 
 * @author awise
 * @date 2024-04-21
 */
public interface AwCustomermaterialsstorageMapper 
{
    /**
     * 查询客供入库
     * 
     * @param id 客供入库主键
     * @return 客供入库
     */
    public AwCustomermaterialsstorage selectAwCustomermaterialsstorageById(Long id);

    /**
     * 查询客供入库列表
     * 
     * @param awCustomermaterialsstorage 客供入库
     * @return 客供入库集合
     */
    public List<AwCustomermaterialsstorage> selectAwCustomermaterialsstorageList(AwCustomermaterialsstorage awCustomermaterialsstorage);

    /**
     * 新增客供入库
     * 
     * @param awCustomermaterialsstorage 客供入库
     * @return 结果
     */
    public int insertAwCustomermaterialsstorage(AwCustomermaterialsstorage awCustomermaterialsstorage);

    /**
     * 修改客供入库
     * 
     * @param awCustomermaterialsstorage 客供入库
     * @return 结果
     */
    public int updateAwCustomermaterialsstorage(AwCustomermaterialsstorage awCustomermaterialsstorage);

    /**
     * 删除客供入库
     * 
     * @param id 客供入库主键
     * @return 结果
     */
    public int deleteAwCustomermaterialsstorageById(Long id);

    /**
     * 批量删除客供入库
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwCustomermaterialsstorageByIds(Long[] ids);
}
