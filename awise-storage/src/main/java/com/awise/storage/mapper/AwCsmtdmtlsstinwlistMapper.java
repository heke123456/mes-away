package com.awise.storage.mapper;

import java.util.List;
import com.awise.storage.domain.AwCsmtdmtlsstinwlist;

/**
 * 客供材料入库单Mapper接口
 * 
 * @author awise
 * @date 2023-12-21
 */
public interface AwCsmtdmtlsstinwlistMapper 
{
    /**
     * 查询客供材料入库单
     * 
     * @param warehouseEntryID 客供材料入库单主键
     * @return 客供材料入库单
     */
    public AwCsmtdmtlsstinwlist selectAwCsmtdmtlsstinwlistByWarehouseEntryID(String warehouseEntryID);

    /**
     * 查询客供材料入库单列表
     * 
     * @param awCsmtdmtlsstinwlist 客供材料入库单
     * @return 客供材料入库单集合
     */
    public List<AwCsmtdmtlsstinwlist> selectAwCsmtdmtlsstinwlistList(AwCsmtdmtlsstinwlist awCsmtdmtlsstinwlist);

    /**
     * 新增客供材料入库单
     * 
     * @param awCsmtdmtlsstinwlist 客供材料入库单
     * @return 结果
     */
    public int insertAwCsmtdmtlsstinwlist(AwCsmtdmtlsstinwlist awCsmtdmtlsstinwlist);

    /**
     * 修改客供材料入库单
     * 
     * @param awCsmtdmtlsstinwlist 客供材料入库单
     * @return 结果
     */
    public int updateAwCsmtdmtlsstinwlist(AwCsmtdmtlsstinwlist awCsmtdmtlsstinwlist);

    /**
     * 删除客供材料入库单
     * 
     * @param warehouseEntryID 客供材料入库单主键
     * @return 结果
     */
    public int deleteAwCsmtdmtlsstinwlistByWarehouseEntryID(String warehouseEntryID);

    /**
     * 批量删除客供材料入库单
     * 
     * @param warehouseEntryIDs 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwCsmtdmtlsstinwlistByWarehouseEntryIDs(String[] warehouseEntryIDs);
}
