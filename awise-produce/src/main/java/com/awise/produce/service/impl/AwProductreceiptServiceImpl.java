package com.awise.produce.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.produce.mapper.AwProductreceiptMapper;
import com.awise.produce.domain.AwProductreceipt;
import com.awise.produce.service.IAwProductreceiptService;

/**
 * 产品入库单Service业务层处理
 * 
 * @author awise
 * @date 2023-10-14
 */
@Service
public class AwProductreceiptServiceImpl implements IAwProductreceiptService 
{
    @Autowired
    private AwProductreceiptMapper awProductreceiptMapper;

    /**
     * 查询产品入库单
     * 
     * @param warehouseEntryID 产品入库单主键
     * @return 产品入库单
     */
    @Override
    public AwProductreceipt selectAwProductreceiptByWarehouseEntryID(String warehouseEntryID)
    {
        return awProductreceiptMapper.selectAwProductreceiptByWarehouseEntryID(warehouseEntryID);
    }

    /**
     * 查询产品入库单列表
     * 
     * @param awProductreceipt 产品入库单
     * @return 产品入库单
     */
    @Override
    public List<AwProductreceipt> selectAwProductreceiptList(AwProductreceipt awProductreceipt)
    {
        return awProductreceiptMapper.selectAwProductreceiptList(awProductreceipt);
    }

    /**
     * 新增产品入库单
     * 
     * @param awProductreceipt 产品入库单
     * @return 结果
     */
    @Override
    public int insertAwProductreceipt(AwProductreceipt awProductreceipt)
    {
        return awProductreceiptMapper.insertAwProductreceipt(awProductreceipt);
    }

    /**
     * 修改产品入库单
     * 
     * @param awProductreceipt 产品入库单
     * @return 结果
     */
    @Override
    public int updateAwProductreceipt(AwProductreceipt awProductreceipt)
    {
        return awProductreceiptMapper.updateAwProductreceipt(awProductreceipt);
    }

    /**
     * 批量删除产品入库单
     * 
     * @param warehouseEntryIDs 需要删除的产品入库单主键
     * @return 结果
     */
    @Override
    public int deleteAwProductreceiptByWarehouseEntryIDs(String[] warehouseEntryIDs)
    {
        return awProductreceiptMapper.deleteAwProductreceiptByWarehouseEntryIDs(warehouseEntryIDs);
    }

    /**
     * 删除产品入库单信息
     * 
     * @param warehouseEntryID 产品入库单主键
     * @return 结果
     */
    @Override
    public int deleteAwProductreceiptByWarehouseEntryID(String warehouseEntryID)
    {
        return awProductreceiptMapper.deleteAwProductreceiptByWarehouseEntryID(warehouseEntryID);
    }
}
