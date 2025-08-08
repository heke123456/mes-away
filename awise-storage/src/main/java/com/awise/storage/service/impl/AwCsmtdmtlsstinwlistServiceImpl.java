package com.awise.storage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.storage.mapper.AwCsmtdmtlsstinwlistMapper;
import com.awise.storage.domain.AwCsmtdmtlsstinwlist;
import com.awise.storage.service.IAwCsmtdmtlsstinwlistService;

/**
 * 客供材料入库单Service业务层处理
 * 
 * @author awise
 * @date 2023-12-21
 */
@Service
public class AwCsmtdmtlsstinwlistServiceImpl implements IAwCsmtdmtlsstinwlistService 
{
    @Autowired
    private AwCsmtdmtlsstinwlistMapper awCsmtdmtlsstinwlistMapper;

    /**
     * 查询客供材料入库单
     * 
     * @param warehouseEntryID 客供材料入库单主键
     * @return 客供材料入库单
     */
    @Override
    public AwCsmtdmtlsstinwlist selectAwCsmtdmtlsstinwlistByWarehouseEntryID(String warehouseEntryID)
    {
        return awCsmtdmtlsstinwlistMapper.selectAwCsmtdmtlsstinwlistByWarehouseEntryID(warehouseEntryID);
    }

    /**
     * 查询客供材料入库单列表
     * 
     * @param awCsmtdmtlsstinwlist 客供材料入库单
     * @return 客供材料入库单
     */
    @Override
    public List<AwCsmtdmtlsstinwlist> selectAwCsmtdmtlsstinwlistList(AwCsmtdmtlsstinwlist awCsmtdmtlsstinwlist)
    {
        return awCsmtdmtlsstinwlistMapper.selectAwCsmtdmtlsstinwlistList(awCsmtdmtlsstinwlist);
    }

    /**
     * 新增客供材料入库单
     * 
     * @param awCsmtdmtlsstinwlist 客供材料入库单
     * @return 结果
     */
    @Override
    public int insertAwCsmtdmtlsstinwlist(AwCsmtdmtlsstinwlist awCsmtdmtlsstinwlist)
    {
        return awCsmtdmtlsstinwlistMapper.insertAwCsmtdmtlsstinwlist(awCsmtdmtlsstinwlist);
    }

    /**
     * 修改客供材料入库单
     * 
     * @param awCsmtdmtlsstinwlist 客供材料入库单
     * @return 结果
     */
    @Override
    public int updateAwCsmtdmtlsstinwlist(AwCsmtdmtlsstinwlist awCsmtdmtlsstinwlist)
    {
        return awCsmtdmtlsstinwlistMapper.updateAwCsmtdmtlsstinwlist(awCsmtdmtlsstinwlist);
    }

    /**
     * 批量删除客供材料入库单
     * 
     * @param warehouseEntryIDs 需要删除的客供材料入库单主键
     * @return 结果
     */
    @Override
    public int deleteAwCsmtdmtlsstinwlistByWarehouseEntryIDs(String[] warehouseEntryIDs)
    {
        return awCsmtdmtlsstinwlistMapper.deleteAwCsmtdmtlsstinwlistByWarehouseEntryIDs(warehouseEntryIDs);
    }

    /**
     * 删除客供材料入库单信息
     * 
     * @param warehouseEntryID 客供材料入库单主键
     * @return 结果
     */
    @Override
    public int deleteAwCsmtdmtlsstinwlistByWarehouseEntryID(String warehouseEntryID)
    {
        return awCsmtdmtlsstinwlistMapper.deleteAwCsmtdmtlsstinwlistByWarehouseEntryID(warehouseEntryID);
    }
}
