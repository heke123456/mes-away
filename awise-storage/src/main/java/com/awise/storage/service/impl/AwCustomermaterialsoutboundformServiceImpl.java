package com.awise.storage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.storage.mapper.AwCustomermaterialsoutboundformMapper;
import com.awise.storage.domain.AwCustomermaterialsoutboundform;
import com.awise.storage.service.IAwCustomermaterialsoutboundformService;

/**
 * 客供材料出库单Service业务层处理
 * 
 * @author awise
 * @date 2024-04-23
 */
@Service
public class AwCustomermaterialsoutboundformServiceImpl implements IAwCustomermaterialsoutboundformService 
{
    @Autowired
    private AwCustomermaterialsoutboundformMapper awCustomermaterialsoutboundformMapper;

    /**
     * 查询客供材料出库单
     * 
     * @param deliveryNoteID 客供材料出库单主键
     * @return 客供材料出库单
     */
    @Override
    public AwCustomermaterialsoutboundform selectAwCustomermaterialsoutboundformByDeliveryNoteID(String deliveryNoteID)
    {
        return awCustomermaterialsoutboundformMapper.selectAwCustomermaterialsoutboundformByDeliveryNoteID(deliveryNoteID);
    }

    /**
     * 查询客供材料出库单列表
     * 
     * @param awCustomermaterialsoutboundform 客供材料出库单
     * @return 客供材料出库单
     */
    @Override
    public List<AwCustomermaterialsoutboundform> selectAwCustomermaterialsoutboundformList(AwCustomermaterialsoutboundform awCustomermaterialsoutboundform)
    {
        return awCustomermaterialsoutboundformMapper.selectAwCustomermaterialsoutboundformList(awCustomermaterialsoutboundform);
    }

    /**
     * 新增客供材料出库单
     * 
     * @param awCustomermaterialsoutboundform 客供材料出库单
     * @return 结果
     */
    @Override
    public int insertAwCustomermaterialsoutboundform(AwCustomermaterialsoutboundform awCustomermaterialsoutboundform)
    {
        return awCustomermaterialsoutboundformMapper.insertAwCustomermaterialsoutboundform(awCustomermaterialsoutboundform);
    }

    /**
     * 修改客供材料出库单
     * 
     * @param awCustomermaterialsoutboundform 客供材料出库单
     * @return 结果
     */
    @Override
    public int updateAwCustomermaterialsoutboundform(AwCustomermaterialsoutboundform awCustomermaterialsoutboundform)
    {
        return awCustomermaterialsoutboundformMapper.updateAwCustomermaterialsoutboundform(awCustomermaterialsoutboundform);
    }

    /**
     * 批量删除客供材料出库单
     * 
     * @param deliveryNoteIDs 需要删除的客供材料出库单主键
     * @return 结果
     */
    @Override
    public int deleteAwCustomermaterialsoutboundformByDeliveryNoteIDs(String[] deliveryNoteIDs)
    {
        return awCustomermaterialsoutboundformMapper.deleteAwCustomermaterialsoutboundformByDeliveryNoteIDs(deliveryNoteIDs);
    }

    /**
     * 删除客供材料出库单信息
     * 
     * @param deliveryNoteID 客供材料出库单主键
     * @return 结果
     */
    @Override
    public int deleteAwCustomermaterialsoutboundformByDeliveryNoteID(String deliveryNoteID)
    {
        return awCustomermaterialsoutboundformMapper.deleteAwCustomermaterialsoutboundformByDeliveryNoteID(deliveryNoteID);
    }
}
