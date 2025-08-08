package com.awise.produce.service;

import java.util.List;
import com.awise.produce.domain.AwProductreceipt;

/**
 * 产品入库单Service接口
 * 
 * @author awise
 * @date 2023-10-14
 */
public interface IAwProductreceiptService 
{
    /**
     * 查询产品入库单
     * 
     * @param warehouseEntryID 产品入库单主键
     * @return 产品入库单
     */
    public AwProductreceipt selectAwProductreceiptByWarehouseEntryID(String warehouseEntryID);

    /**
     * 查询产品入库单列表
     * 
     * @param awProductreceipt 产品入库单
     * @return 产品入库单集合
     */
    public List<AwProductreceipt> selectAwProductreceiptList(AwProductreceipt awProductreceipt);

    /**
     * 新增产品入库单
     * 
     * @param awProductreceipt 产品入库单
     * @return 结果
     */
    public int insertAwProductreceipt(AwProductreceipt awProductreceipt);

    /**
     * 修改产品入库单
     * 
     * @param awProductreceipt 产品入库单
     * @return 结果
     */
    public int updateAwProductreceipt(AwProductreceipt awProductreceipt);

    /**
     * 批量删除产品入库单
     * 
     * @param warehouseEntryIDs 需要删除的产品入库单主键集合
     * @return 结果
     */
    public int deleteAwProductreceiptByWarehouseEntryIDs(String[] warehouseEntryIDs);

    /**
     * 删除产品入库单信息
     * 
     * @param warehouseEntryID 产品入库单主键
     * @return 结果
     */
    public int deleteAwProductreceiptByWarehouseEntryID(String warehouseEntryID);
}
