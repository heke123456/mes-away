package com.awise.storage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.storage.mapper.AwTooloutboundorderMapper;
import com.awise.storage.domain.AwTooloutboundorder;
import com.awise.storage.service.IAwTooloutboundorderService;

/**
 * 刀具出库单Service业务层处理
 * 
 * @author awise
 * @date 2023-12-08
 */
@Service
public class AwTooloutboundorderServiceImpl implements IAwTooloutboundorderService 
{
    @Autowired
    private AwTooloutboundorderMapper awTooloutboundorderMapper;

    /**
     * 查询刀具出库单
     * 
     * @param deliveryNoteID 刀具出库单主键
     * @return 刀具出库单
     */
    @Override
    public AwTooloutboundorder selectAwTooloutboundorderByDeliveryNoteID(String deliveryNoteID)
    {
        return awTooloutboundorderMapper.selectAwTooloutboundorderByDeliveryNoteID(deliveryNoteID);
    }

    /**
     * 查询刀具出库单列表
     * 
     * @param awTooloutboundorder 刀具出库单
     * @return 刀具出库单
     */
    @Override
    public List<AwTooloutboundorder> selectAwTooloutboundorderList(AwTooloutboundorder awTooloutboundorder)
    {
        return awTooloutboundorderMapper.selectAwTooloutboundorderList(awTooloutboundorder);
    }

    /**
     * 新增刀具出库单
     * 
     * @param awTooloutboundorder 刀具出库单
     * @return 结果
     */
    @Override
    public int insertAwTooloutboundorder(AwTooloutboundorder awTooloutboundorder)
    {
        return awTooloutboundorderMapper.insertAwTooloutboundorder(awTooloutboundorder);
    }

    /**
     * 修改刀具出库单
     * 
     * @param awTooloutboundorder 刀具出库单
     * @return 结果
     */
    @Override
    public int updateAwTooloutboundorder(AwTooloutboundorder awTooloutboundorder)
    {
        return awTooloutboundorderMapper.updateAwTooloutboundorder(awTooloutboundorder);
    }

    /**
     * 批量删除刀具出库单
     * 
     * @param deliveryNoteIDs 需要删除的刀具出库单主键
     * @return 结果
     */
    @Override
    public int deleteAwTooloutboundorderByDeliveryNoteIDs(String[] deliveryNoteIDs)
    {
        return awTooloutboundorderMapper.deleteAwTooloutboundorderByDeliveryNoteIDs(deliveryNoteIDs);
    }

    /**
     * 删除刀具出库单信息
     * 
     * @param deliveryNoteID 刀具出库单主键
     * @return 结果
     */
    @Override
    public int deleteAwTooloutboundorderByDeliveryNoteID(String deliveryNoteID)
    {
        return awTooloutboundorderMapper.deleteAwTooloutboundorderByDeliveryNoteID(deliveryNoteID);
    }
}
