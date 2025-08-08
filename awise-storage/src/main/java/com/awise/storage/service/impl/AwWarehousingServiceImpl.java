package com.awise.storage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.storage.mapper.AwWarehousingMapper;
import com.awise.storage.domain.AwWarehousing;
import com.awise.storage.service.IAwWarehousingService;

/**
 * 入库单Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-10-14
 */
@Service
public class AwWarehousingServiceImpl implements IAwWarehousingService 
{
    @Autowired
    private AwWarehousingMapper awWarehousingMapper;

    /**
     * 查询入库单
     * 
     * @param warehouseEntryID 入库单主键
     * @return 入库单
     */
    @Override
    public AwWarehousing selectAwWarehousingByWarehouseEntryID(String warehouseEntryID)
    {
        return awWarehousingMapper.selectAwWarehousingByWarehouseEntryID(warehouseEntryID);
    }

    /**
     * 查询入库单列表
     * 
     * @param awWarehousing 入库单
     * @return 入库单
     */
    @Override
    public List<AwWarehousing> selectAwWarehousingList(AwWarehousing awWarehousing)
    {
        return awWarehousingMapper.selectAwWarehousingList(awWarehousing);
    }

    /**
     * 新增入库单
     * 
     * @param awWarehousing 入库单
     * @return 结果
     */
    @Override
    public int insertAwWarehousing(AwWarehousing awWarehousing)
    {
        return awWarehousingMapper.insertAwWarehousing(awWarehousing);
    }

    /**
     * 修改入库单
     * 
     * @param awWarehousing 入库单
     * @return 结果
     */
    @Override
    public int updateAwWarehousing(AwWarehousing awWarehousing)
    {
        return awWarehousingMapper.updateAwWarehousing(awWarehousing);
    }

    /**
     * 批量删除入库单
     * 
     * @param warehouseEntryIDs 需要删除的入库单主键
     * @return 结果
     */
    @Override
    public int deleteAwWarehousingByWarehouseEntryIDs(String[] warehouseEntryIDs)
    {
        return awWarehousingMapper.deleteAwWarehousingByWarehouseEntryIDs(warehouseEntryIDs);
    }

    /**
     * 删除入库单信息
     * 
     * @param warehouseEntryID 入库单主键
     * @return 结果
     */
    @Override
    public int deleteAwWarehousingByWarehouseEntryID(String warehouseEntryID)
    {
        return awWarehousingMapper.deleteAwWarehousingByWarehouseEntryID(warehouseEntryID);
    }
}
