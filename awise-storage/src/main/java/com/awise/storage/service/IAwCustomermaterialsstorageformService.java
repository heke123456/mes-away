package com.awise.storage.service;

import java.util.List;
import com.awise.storage.domain.AwCustomermaterialsstorageform;

/**
 * 客供入库单Service接口
 * 
 * @author awise
 * @date 2024-04-21
 */
public interface IAwCustomermaterialsstorageformService 
{
    /**
     * 查询客供入库单
     * 
     * @param warehouseEntryID 客供入库单主键
     * @return 客供入库单
     */
    public AwCustomermaterialsstorageform selectAwCustomermaterialsstorageformByWarehouseEntryID(String warehouseEntryID);

    /**
     * 查询客供入库单列表
     * 
     * @param awCustomermaterialsstorageform 客供入库单
     * @return 客供入库单集合
     */
    public List<AwCustomermaterialsstorageform> selectAwCustomermaterialsstorageformList(AwCustomermaterialsstorageform awCustomermaterialsstorageform);

    /**
     * 新增客供入库单
     * 
     * @param awCustomermaterialsstorageform 客供入库单
     * @return 结果
     */
    public int insertAwCustomermaterialsstorageform(AwCustomermaterialsstorageform awCustomermaterialsstorageform);

    /**
     * 修改客供入库单
     * 
     * @param awCustomermaterialsstorageform 客供入库单
     * @return 结果
     */
    public int updateAwCustomermaterialsstorageform(AwCustomermaterialsstorageform awCustomermaterialsstorageform);

    /**
     * 批量删除客供入库单
     * 
     * @param warehouseEntryIDs 需要删除的客供入库单主键集合
     * @return 结果
     */
    public int deleteAwCustomermaterialsstorageformByWarehouseEntryIDs(String[] warehouseEntryIDs);

    /**
     * 删除客供入库单信息
     * 
     * @param warehouseEntryID 客供入库单主键
     * @return 结果
     */
    public int deleteAwCustomermaterialsstorageformByWarehouseEntryID(String warehouseEntryID);
}
