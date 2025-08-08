package com.awise.storage.mapper;

import java.util.List;
import com.awise.storage.domain.AwToolstorageform;

/**
 * 刀具入库单Mapper接口
 * 
 * @author awise
 * @date 2023-12-06
 */
public interface AwToolstorageformMapper 
{
    /**
     * 查询刀具入库单
     * 
     * @param warehouseEntryID 刀具入库单主键
     * @return 刀具入库单
     */
    public AwToolstorageform selectAwToolstorageformByWarehouseEntryID(String warehouseEntryID);

    /**
     * 查询刀具入库单列表
     * 
     * @param awToolstorageform 刀具入库单
     * @return 刀具入库单集合
     */
    public List<AwToolstorageform> selectAwToolstorageformList(AwToolstorageform awToolstorageform);

    /**
     * 新增刀具入库单
     * 
     * @param awToolstorageform 刀具入库单
     * @return 结果
     */
    public int insertAwToolstorageform(AwToolstorageform awToolstorageform);

    /**
     * 修改刀具入库单
     * 
     * @param awToolstorageform 刀具入库单
     * @return 结果
     */
    public int updateAwToolstorageform(AwToolstorageform awToolstorageform);

    /**
     * 删除刀具入库单
     * 
     * @param warehouseEntryID 刀具入库单主键
     * @return 结果
     */
    public int deleteAwToolstorageformByWarehouseEntryID(String warehouseEntryID);

    /**
     * 批量删除刀具入库单
     * 
     * @param warehouseEntryIDs 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwToolstorageformByWarehouseEntryIDs(String[] warehouseEntryIDs);
}
