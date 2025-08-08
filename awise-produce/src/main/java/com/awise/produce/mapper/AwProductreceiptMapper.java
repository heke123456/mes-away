package com.awise.produce.mapper;

import java.util.List;
import com.awise.produce.domain.AwProductreceipt;

/**
 * 产品入库单Mapper接口
 * 
 * @author awise
 * @date 2023-10-14
 */
public interface AwProductreceiptMapper 
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
     * 删除产品入库单
     * 
     * @param warehouseEntryID 产品入库单主键
     * @return 结果
     */
    public int deleteAwProductreceiptByWarehouseEntryID(String warehouseEntryID);

    /**
     * 批量删除产品入库单
     * 
     * @param warehouseEntryIDs 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwProductreceiptByWarehouseEntryIDs(String[] warehouseEntryIDs);
}
