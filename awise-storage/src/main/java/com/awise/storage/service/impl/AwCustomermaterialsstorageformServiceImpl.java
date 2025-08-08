package com.awise.storage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.storage.mapper.AwCustomermaterialsstorageformMapper;
import com.awise.storage.domain.AwCustomermaterialsstorageform;
import com.awise.storage.service.IAwCustomermaterialsstorageformService;

/**
 * 客供入库单Service业务层处理
 * 
 * @author awise
 * @date 2024-04-21
 */
@Service
public class AwCustomermaterialsstorageformServiceImpl implements IAwCustomermaterialsstorageformService 
{
    @Autowired
    private AwCustomermaterialsstorageformMapper awCustomermaterialsstorageformMapper;

    /**
     * 查询客供入库单
     * 
     * @param warehouseEntryID 客供入库单主键
     * @return 客供入库单
     */
    @Override
    public AwCustomermaterialsstorageform selectAwCustomermaterialsstorageformByWarehouseEntryID(String warehouseEntryID)
    {
        return awCustomermaterialsstorageformMapper.selectAwCustomermaterialsstorageformByWarehouseEntryID(warehouseEntryID);
    }

    /**
     * 查询客供入库单列表
     * 
     * @param awCustomermaterialsstorageform 客供入库单
     * @return 客供入库单
     */
    @Override
    public List<AwCustomermaterialsstorageform> selectAwCustomermaterialsstorageformList(AwCustomermaterialsstorageform awCustomermaterialsstorageform)
    {
        return awCustomermaterialsstorageformMapper.selectAwCustomermaterialsstorageformList(awCustomermaterialsstorageform);
    }

    /**
     * 新增客供入库单
     * 
     * @param awCustomermaterialsstorageform 客供入库单
     * @return 结果
     */
    @Override
    public int insertAwCustomermaterialsstorageform(AwCustomermaterialsstorageform awCustomermaterialsstorageform)
    {
        return awCustomermaterialsstorageformMapper.insertAwCustomermaterialsstorageform(awCustomermaterialsstorageform);
    }

    /**
     * 修改客供入库单
     * 
     * @param awCustomermaterialsstorageform 客供入库单
     * @return 结果
     */
    @Override
    public int updateAwCustomermaterialsstorageform(AwCustomermaterialsstorageform awCustomermaterialsstorageform)
    {
        return awCustomermaterialsstorageformMapper.updateAwCustomermaterialsstorageform(awCustomermaterialsstorageform);
    }

    /**
     * 批量删除客供入库单
     * 
     * @param warehouseEntryIDs 需要删除的客供入库单主键
     * @return 结果
     */
    @Override
    public int deleteAwCustomermaterialsstorageformByWarehouseEntryIDs(String[] warehouseEntryIDs)
    {
        return awCustomermaterialsstorageformMapper.deleteAwCustomermaterialsstorageformByWarehouseEntryIDs(warehouseEntryIDs);
    }

    /**
     * 删除客供入库单信息
     * 
     * @param warehouseEntryID 客供入库单主键
     * @return 结果
     */
    @Override
    public int deleteAwCustomermaterialsstorageformByWarehouseEntryID(String warehouseEntryID)
    {
        return awCustomermaterialsstorageformMapper.deleteAwCustomermaterialsstorageformByWarehouseEntryID(warehouseEntryID);
    }
}
