package com.awise.storage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.storage.mapper.AwToolstorageMapper;
import com.awise.storage.domain.AwToolstorage;
import com.awise.storage.service.IAwToolstorageService;

/**
 * 刀具入库Service业务层处理
 * 
 * @author awise
 * @date 2023-12-06
 */
@Service
public class AwToolstorageServiceImpl implements IAwToolstorageService 
{
    @Autowired
    private AwToolstorageMapper awToolstorageMapper;

    /**
     * 查询刀具入库
     * 
     * @param id 刀具入库主键
     * @return 刀具入库
     */
    @Override
    public AwToolstorage selectAwToolstorageById(String id)
    {
        return awToolstorageMapper.selectAwToolstorageById(id);
    }

    /**
     * 查询刀具入库列表
     * 
     * @param awToolstorage 刀具入库
     * @return 刀具入库
     */
    @Override
    public List<AwToolstorage> selectAwToolstorageList(AwToolstorage awToolstorage)
    {
        return awToolstorageMapper.selectAwToolstorageList(awToolstorage);
    }

    /**
     * 新增刀具入库
     * 
     * @param awToolstorage 刀具入库
     * @return 结果
     */
    @Override
    public int insertAwToolstorage(AwToolstorage awToolstorage)
    {
        return awToolstorageMapper.insertAwToolstorage(awToolstorage);
    }

    /**
     * 修改刀具入库
     * 
     * @param awToolstorage 刀具入库
     * @return 结果
     */
    @Override
    public int updateAwToolstorage(AwToolstorage awToolstorage)
    {
        return awToolstorageMapper.updateAwToolstorage(awToolstorage);
    }

    /**
     * 批量删除刀具入库
     * 
     * @param ids 需要删除的刀具入库主键
     * @return 结果
     */
    @Override
    public int deleteAwToolstorageByIds(String[] ids)
    {
        return awToolstorageMapper.deleteAwToolstorageByIds(ids);
    }

    /**
     * 删除刀具入库信息
     * 
     * @param id 刀具入库主键
     * @return 结果
     */
    @Override
    public int deleteAwToolstorageById(String id)
    {
        return awToolstorageMapper.deleteAwToolstorageById(id);
    }
}
