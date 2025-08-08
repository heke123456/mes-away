package com.awise.storage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.storage.mapper.AwOutboundorderMapper;
import com.awise.storage.domain.AwOutboundorder;
import com.awise.storage.service.IAwOutboundorderService;

/**
 * 出库单Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-10-14
 */
@Service
public class AwOutboundorderServiceImpl implements IAwOutboundorderService 
{
    @Autowired
    private AwOutboundorderMapper awOutboundorderMapper;

    /**
     * 查询出库单
     * 
     * @param deliveryNoteID 出库单主键
     * @return 出库单
     */
    @Override
    public AwOutboundorder selectAwOutboundorderByDeliveryNoteID(String deliveryNoteID)
    {
        return awOutboundorderMapper.selectAwOutboundorderByDeliveryNoteID(deliveryNoteID);
    }

    /**
     * 查询出库单列表
     * 
     * @param awOutboundorder 出库单
     * @return 出库单
     */
    @Override
    public List<AwOutboundorder> selectAwOutboundorderList(AwOutboundorder awOutboundorder)
    {
        return awOutboundorderMapper.selectAwOutboundorderList(awOutboundorder);
    }

    /**
     * 新增出库单
     * 
     * @param awOutboundorder 出库单
     * @return 结果
     */
    @Override
    public int insertAwOutboundorder(AwOutboundorder awOutboundorder)
    {
        return awOutboundorderMapper.insertAwOutboundorder(awOutboundorder);
    }

    /**
     * 修改出库单
     * 
     * @param awOutboundorder 出库单
     * @return 结果
     */
    @Override
    public int updateAwOutboundorder(AwOutboundorder awOutboundorder)
    {
        return awOutboundorderMapper.updateAwOutboundorder(awOutboundorder);
    }

    /**
     * 批量删除出库单
     * 
     * @param deliveryNoteIDs 需要删除的出库单主键
     * @return 结果
     */
    @Override
    public int deleteAwOutboundorderByDeliveryNoteIDs(String[] deliveryNoteIDs)
    {
        return awOutboundorderMapper.deleteAwOutboundorderByDeliveryNoteIDs(deliveryNoteIDs);
    }

    /**
     * 删除出库单信息
     * 
     * @param deliveryNoteID 出库单主键
     * @return 结果
     */
    @Override
    public int deleteAwOutboundorderByDeliveryNoteID(String deliveryNoteID)
    {
        return awOutboundorderMapper.deleteAwOutboundorderByDeliveryNoteID(deliveryNoteID);
    }
}
