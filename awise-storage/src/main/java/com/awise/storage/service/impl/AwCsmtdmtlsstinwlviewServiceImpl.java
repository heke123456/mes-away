package com.awise.storage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.storage.mapper.AwCsmtdmtlsstinwlviewMapper;
import com.awise.storage.domain.AwCsmtdmtlsstinwlview;
import com.awise.storage.service.IAwCsmtdmtlsstinwlviewService;

/**
 * 客供入库Service业务层处理
 * 
 * @author awise
 * @date 2023-12-21
 */
@Service
public class AwCsmtdmtlsstinwlviewServiceImpl implements IAwCsmtdmtlsstinwlviewService 
{
    @Autowired
    private AwCsmtdmtlsstinwlviewMapper awCsmtdmtlsstinwlviewMapper;

    /**
     * 查询客供入库
     * 
     * @param warehouseEntryID 客供入库主键
     * @return 客供入库
     */
    @Override
    public AwCsmtdmtlsstinwlview selectAwCsmtdmtlsstinwlviewByWarehouseEntryID(String warehouseEntryID)
    {
        return awCsmtdmtlsstinwlviewMapper.selectAwCsmtdmtlsstinwlviewByWarehouseEntryID(warehouseEntryID);
    }

    /**
     * 查询客供入库列表
     * 
     * @param awCsmtdmtlsstinwlview 客供入库
     * @return 客供入库
     */
    @Override
    public List<AwCsmtdmtlsstinwlview> selectAwCsmtdmtlsstinwlviewList(AwCsmtdmtlsstinwlview awCsmtdmtlsstinwlview)
    {
        return awCsmtdmtlsstinwlviewMapper.selectAwCsmtdmtlsstinwlviewList(awCsmtdmtlsstinwlview);
    }

    /**
     * 新增客供入库
     * 
     * @param awCsmtdmtlsstinwlview 客供入库
     * @return 结果
     */
    @Override
    public int insertAwCsmtdmtlsstinwlview(AwCsmtdmtlsstinwlview awCsmtdmtlsstinwlview)
    {
        return awCsmtdmtlsstinwlviewMapper.insertAwCsmtdmtlsstinwlview(awCsmtdmtlsstinwlview);
    }

    /**
     * 修改客供入库
     * 
     * @param awCsmtdmtlsstinwlview 客供入库
     * @return 结果
     */
    @Override
    public int updateAwCsmtdmtlsstinwlview(AwCsmtdmtlsstinwlview awCsmtdmtlsstinwlview)
    {
        return awCsmtdmtlsstinwlviewMapper.updateAwCsmtdmtlsstinwlview(awCsmtdmtlsstinwlview);
    }

    /**
     * 批量删除客供入库
     * 
     * @param warehouseEntryIDs 需要删除的客供入库主键
     * @return 结果
     */
    @Override
    public int deleteAwCsmtdmtlsstinwlviewByWarehouseEntryIDs(String[] warehouseEntryIDs)
    {
        return awCsmtdmtlsstinwlviewMapper.deleteAwCsmtdmtlsstinwlviewByWarehouseEntryIDs(warehouseEntryIDs);
    }

    /**
     * 删除客供入库信息
     * 
     * @param warehouseEntryID 客供入库主键
     * @return 结果
     */
    @Override
    public int deleteAwCsmtdmtlsstinwlviewByWarehouseEntryID(String warehouseEntryID)
    {
        return awCsmtdmtlsstinwlviewMapper.deleteAwCsmtdmtlsstinwlviewByWarehouseEntryID(warehouseEntryID);
    }
}
