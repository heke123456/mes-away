package com.awise.order.service;

import java.util.List;
import com.awise.order.domain.AwPurchaserequisition;

/**
 * 材料申购Service接口
 * 
 * @author awise
 * @date 2023-10-17
 */
public interface IAwPurchaserequisitionService 
{
    /**
     * 查询材料申购
     * 
     * @param subscribeID 材料申购主键
     * @return 材料申购
     */
    public AwPurchaserequisition selectAwPurchaserequisitionBySubscribeID(String subscribeID);

    /**
     * 查询材料申购列表
     * 
     * @param awPurchaserequisition 材料申购
     * @return 材料申购集合
     */
    public List<AwPurchaserequisition> selectAwPurchaserequisitionList(AwPurchaserequisition awPurchaserequisition);

    /**
     * 新增材料申购
     * 
     * @param awPurchaserequisition 材料申购
     * @return 结果
     */
    public int insertAwPurchaserequisition(AwPurchaserequisition awPurchaserequisition);

    /**
     * 修改材料申购
     * 
     * @param awPurchaserequisition 材料申购
     * @return 结果
     */
    public int updateAwPurchaserequisition(AwPurchaserequisition awPurchaserequisition);

    /**
     * 批量删除材料申购
     * 
     * @param subscribeIDs 需要删除的材料申购主键集合
     * @return 结果
     */
    public int deleteAwPurchaserequisitionBySubscribeIDs(String[] subscribeIDs);

    /**
     * 删除材料申购信息
     * 
     * @param subscribeID 材料申购主键
     * @return 结果
     */
    public int deleteAwPurchaserequisitionBySubscribeID(String subscribeID);
}
