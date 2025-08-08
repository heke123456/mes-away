package com.awise.produce.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.produce.mapper.AwProductdeliveryformMapper;
import com.awise.produce.domain.AwProductdeliveryform;
import com.awise.produce.service.IAwProductdeliveryformService;

/**
 * 产品出库单Service业务层处理
 * 
 * @author awise
 * @date 2023-10-14
 */
@Service
public class AwProductdeliveryformServiceImpl implements IAwProductdeliveryformService 
{
    @Autowired
    private AwProductdeliveryformMapper awProductdeliveryformMapper;

    /**
     * 查询产品出库单
     * 
     * @param deliveryNoteID 产品出库单主键
     * @return 产品出库单
     */
    @Override
    public AwProductdeliveryform selectAwProductdeliveryformByDeliveryNoteID(String deliveryNoteID)
    {
        return awProductdeliveryformMapper.selectAwProductdeliveryformByDeliveryNoteID(deliveryNoteID);
    }

    /**
     * 查询产品出库单列表
     * 
     * @param awProductdeliveryform 产品出库单
     * @return 产品出库单
     */
    @Override
    public List<AwProductdeliveryform> selectAwProductdeliveryformList(AwProductdeliveryform awProductdeliveryform)
    {
        return awProductdeliveryformMapper.selectAwProductdeliveryformList(awProductdeliveryform);
    }

    /**
     * 新增产品出库单
     * 
     * @param awProductdeliveryform 产品出库单
     * @return 结果
     */
    @Override
    public int insertAwProductdeliveryform(AwProductdeliveryform awProductdeliveryform)
    {
        return awProductdeliveryformMapper.insertAwProductdeliveryform(awProductdeliveryform);
    }

    /**
     * 修改产品出库单
     * 
     * @param awProductdeliveryform 产品出库单
     * @return 结果
     */
    @Override
    public int updateAwProductdeliveryform(AwProductdeliveryform awProductdeliveryform)
    {
        return awProductdeliveryformMapper.updateAwProductdeliveryform(awProductdeliveryform);
    }

    /**
     * 批量删除产品出库单
     * 
     * @param deliveryNoteIDs 需要删除的产品出库单主键
     * @return 结果
     */
    @Override
    public int deleteAwProductdeliveryformByDeliveryNoteIDs(String[] deliveryNoteIDs)
    {
        return awProductdeliveryformMapper.deleteAwProductdeliveryformByDeliveryNoteIDs(deliveryNoteIDs);
    }

    /**
     * 删除产品出库单信息
     * 
     * @param deliveryNoteID 产品出库单主键
     * @return 结果
     */
    @Override
    public int deleteAwProductdeliveryformByDeliveryNoteID(String deliveryNoteID)
    {
        return awProductdeliveryformMapper.deleteAwProductdeliveryformByDeliveryNoteID(deliveryNoteID);
    }
}
