package com.awise.storage.mapper;

import java.util.List;
import com.awise.storage.domain.AwCsmtdmtlsstinwlview;

/**
 * 客供入库Mapper接口
 * 
 * @author awise
 * @date 2023-12-21
 */
public interface AwCsmtdmtlsstinwlviewMapper 
{
    /**
     * 查询客供入库
     * 
     * @param warehouseEntryID 客供入库主键
     * @return 客供入库
     */
    public AwCsmtdmtlsstinwlview selectAwCsmtdmtlsstinwlviewByWarehouseEntryID(String warehouseEntryID);

    /**
     * 查询客供入库列表
     * 
     * @param awCsmtdmtlsstinwlview 客供入库
     * @return 客供入库集合
     */
    public List<AwCsmtdmtlsstinwlview> selectAwCsmtdmtlsstinwlviewList(AwCsmtdmtlsstinwlview awCsmtdmtlsstinwlview);

    /**
     * 新增客供入库
     * 
     * @param awCsmtdmtlsstinwlview 客供入库
     * @return 结果
     */
    public int insertAwCsmtdmtlsstinwlview(AwCsmtdmtlsstinwlview awCsmtdmtlsstinwlview);

    /**
     * 修改客供入库
     * 
     * @param awCsmtdmtlsstinwlview 客供入库
     * @return 结果
     */
    public int updateAwCsmtdmtlsstinwlview(AwCsmtdmtlsstinwlview awCsmtdmtlsstinwlview);

    /**
     * 删除客供入库
     * 
     * @param warehouseEntryID 客供入库主键
     * @return 结果
     */
    public int deleteAwCsmtdmtlsstinwlviewByWarehouseEntryID(String warehouseEntryID);

    /**
     * 批量删除客供入库
     * 
     * @param warehouseEntryIDs 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwCsmtdmtlsstinwlviewByWarehouseEntryIDs(String[] warehouseEntryIDs);
}
