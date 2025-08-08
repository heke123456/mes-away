package com.awise.order.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.order.mapper.AwPurchaserequisitionMapper;
import com.awise.order.domain.AwPurchaserequisition;
import com.awise.order.service.IAwPurchaserequisitionService;

/**
 * 材料申购Service业务层处理
 * 
 * @author awise
 * @date 2023-10-17
 */
@Service
public class AwPurchaserequisitionServiceImpl implements IAwPurchaserequisitionService 
{
    @Autowired
    private AwPurchaserequisitionMapper awPurchaserequisitionMapper;

    /**
     * 查询材料申购
     * 
     * @param subscribeID 材料申购主键
     * @return 材料申购
     */
    @Override
    public AwPurchaserequisition selectAwPurchaserequisitionBySubscribeID(String subscribeID)
    {
        return awPurchaserequisitionMapper.selectAwPurchaserequisitionBySubscribeID(subscribeID);
    }

    /**
     * 查询材料申购列表
     * 
     * @param awPurchaserequisition 材料申购
     * @return 材料申购
     */
    @Override
    public List<AwPurchaserequisition> selectAwPurchaserequisitionList(AwPurchaserequisition awPurchaserequisition)
    {
        return awPurchaserequisitionMapper.selectAwPurchaserequisitionList(awPurchaserequisition);
    }

    /**
     * 新增材料申购
     * 
     * @param awPurchaserequisition 材料申购
     * @return 结果
     */
    @Override
    public int insertAwPurchaserequisition(AwPurchaserequisition awPurchaserequisition)
    {
        return awPurchaserequisitionMapper.insertAwPurchaserequisition(awPurchaserequisition);
    }

    /**
     * 修改材料申购
     * 
     * @param awPurchaserequisition 材料申购
     * @return 结果
     */
    @Override
    public int updateAwPurchaserequisition(AwPurchaserequisition awPurchaserequisition)
    {
        return awPurchaserequisitionMapper.updateAwPurchaserequisition(awPurchaserequisition);
    }

    /**
     * 批量删除材料申购
     * 
     * @param subscribeIDs 需要删除的材料申购主键
     * @return 结果
     */
    @Override
    public int deleteAwPurchaserequisitionBySubscribeIDs(String[] subscribeIDs)
    {
        return awPurchaserequisitionMapper.deleteAwPurchaserequisitionBySubscribeIDs(subscribeIDs);
    }

    /**
     * 删除材料申购信息
     * 
     * @param subscribeID 材料申购主键
     * @return 结果
     */
    @Override
    public int deleteAwPurchaserequisitionBySubscribeID(String subscribeID)
    {
        return awPurchaserequisitionMapper.deleteAwPurchaserequisitionBySubscribeID(subscribeID);
    }
}
