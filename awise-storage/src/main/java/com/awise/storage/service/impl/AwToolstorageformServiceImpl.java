package com.awise.storage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.storage.mapper.AwToolstorageformMapper;
import com.awise.storage.domain.AwToolstorageform;
import com.awise.storage.service.IAwToolstorageformService;

/**
 * 刀具入库单Service业务层处理
 * 
 * @author awise
 * @date 2023-12-06
 */
@Service
public class AwToolstorageformServiceImpl implements IAwToolstorageformService 
{
    @Autowired
    private AwToolstorageformMapper awToolstorageformMapper;

    /**
     * 查询刀具入库单
     * 
     * @param warehouseEntryID 刀具入库单主键
     * @return 刀具入库单
     */
    @Override
    public AwToolstorageform selectAwToolstorageformByWarehouseEntryID(String warehouseEntryID)
    {
        return awToolstorageformMapper.selectAwToolstorageformByWarehouseEntryID(warehouseEntryID);
    }

    /**
     * 查询刀具入库单列表
     * 
     * @param awToolstorageform 刀具入库单
     * @return 刀具入库单
     */
    @Override
    public List<AwToolstorageform> selectAwToolstorageformList(AwToolstorageform awToolstorageform)
    {
        return awToolstorageformMapper.selectAwToolstorageformList(awToolstorageform);
    }

    /**
     * 新增刀具入库单
     * 
     * @param awToolstorageform 刀具入库单
     * @return 结果
     */
    @Override
    public int insertAwToolstorageform(AwToolstorageform awToolstorageform)
    {
        return awToolstorageformMapper.insertAwToolstorageform(awToolstorageform);
    }

    /**
     * 修改刀具入库单
     * 
     * @param awToolstorageform 刀具入库单
     * @return 结果
     */
    @Override
    public int updateAwToolstorageform(AwToolstorageform awToolstorageform)
    {
        return awToolstorageformMapper.updateAwToolstorageform(awToolstorageform);
    }

    /**
     * 批量删除刀具入库单
     * 
     * @param warehouseEntryIDs 需要删除的刀具入库单主键
     * @return 结果
     */
    @Override
    public int deleteAwToolstorageformByWarehouseEntryIDs(String[] warehouseEntryIDs)
    {
        return awToolstorageformMapper.deleteAwToolstorageformByWarehouseEntryIDs(warehouseEntryIDs);
    }

    /**
     * 删除刀具入库单信息
     * 
     * @param warehouseEntryID 刀具入库单主键
     * @return 结果
     */
    @Override
    public int deleteAwToolstorageformByWarehouseEntryID(String warehouseEntryID)
    {
        return awToolstorageformMapper.deleteAwToolstorageformByWarehouseEntryID(warehouseEntryID);
    }
}
