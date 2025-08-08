package com.awise.storage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.storage.mapper.AwDetailcustomermaterialsstorageMapper;
import com.awise.storage.domain.AwDetailcustomermaterialsstorage;
import com.awise.storage.service.IAwDetailcustomermaterialsstorageService;

/**
 * 客供材料入库详细Service业务层处理
 * 
 * @author awise
 * @date 2024-04-21
 */
@Service
public class AwDetailcustomermaterialsstorageServiceImpl implements IAwDetailcustomermaterialsstorageService 
{
    @Autowired
    private AwDetailcustomermaterialsstorageMapper awDetailcustomermaterialsstorageMapper;

    /**
     * 查询客供材料入库详细
     * 
     * @param id 客供材料入库详细主键
     * @return 客供材料入库详细
     */
    @Override
    public AwDetailcustomermaterialsstorage selectAwDetailcustomermaterialsstorageById(Long id)
    {
        return awDetailcustomermaterialsstorageMapper.selectAwDetailcustomermaterialsstorageById(id);
    }

    /**
     * 查询客供材料入库详细列表
     * 
     * @param awDetailcustomermaterialsstorage 客供材料入库详细
     * @return 客供材料入库详细
     */
    @Override
    public List<AwDetailcustomermaterialsstorage> selectAwDetailcustomermaterialsstorageList(AwDetailcustomermaterialsstorage awDetailcustomermaterialsstorage)
    {
        return awDetailcustomermaterialsstorageMapper.selectAwDetailcustomermaterialsstorageList(awDetailcustomermaterialsstorage);
    }

    /**
     * 新增客供材料入库详细
     * 
     * @param awDetailcustomermaterialsstorage 客供材料入库详细
     * @return 结果
     */
    @Override
    public int insertAwDetailcustomermaterialsstorage(AwDetailcustomermaterialsstorage awDetailcustomermaterialsstorage)
    {
        return awDetailcustomermaterialsstorageMapper.insertAwDetailcustomermaterialsstorage(awDetailcustomermaterialsstorage);
    }

    /**
     * 修改客供材料入库详细
     * 
     * @param awDetailcustomermaterialsstorage 客供材料入库详细
     * @return 结果
     */
    @Override
    public int updateAwDetailcustomermaterialsstorage(AwDetailcustomermaterialsstorage awDetailcustomermaterialsstorage)
    {
        return awDetailcustomermaterialsstorageMapper.updateAwDetailcustomermaterialsstorage(awDetailcustomermaterialsstorage);
    }

    /**
     * 批量删除客供材料入库详细
     * 
     * @param ids 需要删除的客供材料入库详细主键
     * @return 结果
     */
    @Override
    public int deleteAwDetailcustomermaterialsstorageByIds(Long[] ids)
    {
        return awDetailcustomermaterialsstorageMapper.deleteAwDetailcustomermaterialsstorageByIds(ids);
    }

    /**
     * 删除客供材料入库详细信息
     * 
     * @param id 客供材料入库详细主键
     * @return 结果
     */
    @Override
    public int deleteAwDetailcustomermaterialsstorageById(Long id)
    {
        return awDetailcustomermaterialsstorageMapper.deleteAwDetailcustomermaterialsstorageById(id);
    }
}
