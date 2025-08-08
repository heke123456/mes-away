package com.awise.storage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.storage.mapper.AwCustomermaterialsstorageMapper;
import com.awise.storage.domain.AwCustomermaterialsstorage;
import com.awise.storage.service.IAwCustomermaterialsstorageService;

/**
 * 客供入库Service业务层处理
 * 
 * @author awise
 * @date 2024-04-21
 */
@Service
public class AwCustomermaterialsstorageServiceImpl implements IAwCustomermaterialsstorageService 
{
    @Autowired
    private AwCustomermaterialsstorageMapper awCustomermaterialsstorageMapper;

    /**
     * 查询客供入库
     * 
     * @param id 客供入库主键
     * @return 客供入库
     */
    @Override
    public AwCustomermaterialsstorage selectAwCustomermaterialsstorageById(Long id)
    {
        return awCustomermaterialsstorageMapper.selectAwCustomermaterialsstorageById(id);
    }

    /**
     * 查询客供入库列表
     * 
     * @param awCustomermaterialsstorage 客供入库
     * @return 客供入库
     */
    @Override
    public List<AwCustomermaterialsstorage> selectAwCustomermaterialsstorageList(AwCustomermaterialsstorage awCustomermaterialsstorage)
    {
        return awCustomermaterialsstorageMapper.selectAwCustomermaterialsstorageList(awCustomermaterialsstorage);
    }

    /**
     * 新增客供入库
     * 
     * @param awCustomermaterialsstorage 客供入库
     * @return 结果
     */
    @Override
    public int insertAwCustomermaterialsstorage(AwCustomermaterialsstorage awCustomermaterialsstorage)
    {
        return awCustomermaterialsstorageMapper.insertAwCustomermaterialsstorage(awCustomermaterialsstorage);
    }

    /**
     * 修改客供入库
     * 
     * @param awCustomermaterialsstorage 客供入库
     * @return 结果
     */
    @Override
    public int updateAwCustomermaterialsstorage(AwCustomermaterialsstorage awCustomermaterialsstorage)
    {
        return awCustomermaterialsstorageMapper.updateAwCustomermaterialsstorage(awCustomermaterialsstorage);
    }

    /**
     * 批量删除客供入库
     * 
     * @param ids 需要删除的客供入库主键
     * @return 结果
     */
    @Override
    public int deleteAwCustomermaterialsstorageByIds(Long[] ids)
    {
        return awCustomermaterialsstorageMapper.deleteAwCustomermaterialsstorageByIds(ids);
    }

    /**
     * 删除客供入库信息
     * 
     * @param id 客供入库主键
     * @return 结果
     */
    @Override
    public int deleteAwCustomermaterialsstorageById(Long id)
    {
        return awCustomermaterialsstorageMapper.deleteAwCustomermaterialsstorageById(id);
    }
}
