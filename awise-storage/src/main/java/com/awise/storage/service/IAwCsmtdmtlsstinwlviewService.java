package com.awise.storage.service;

import java.util.List;
import com.awise.storage.domain.AwCsmtdmtlsstinwlview;

/**
 * 客供入库Service接口
 * 
 * @author awise
 * @date 2023-12-21
 */
public interface IAwCsmtdmtlsstinwlviewService 
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
     * 批量删除客供入库
     * 
     * @param warehouseEntryIDs 需要删除的客供入库主键集合
     * @return 结果
     */
    public int deleteAwCsmtdmtlsstinwlviewByWarehouseEntryIDs(String[] warehouseEntryIDs);

    /**
     * 删除客供入库信息
     * 
     * @param warehouseEntryID 客供入库主键
     * @return 结果
     */
    public int deleteAwCsmtdmtlsstinwlviewByWarehouseEntryID(String warehouseEntryID);
}
