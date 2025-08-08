package com.awise.produce.service;

import java.util.List;
import com.awise.produce.domain.AwProductdeliveryform;

/**
 * 产品出库单Service接口
 * 
 * @author awise
 * @date 2023-10-14
 */
public interface IAwProductdeliveryformService 
{
    /**
     * 查询产品出库单
     * 
     * @param deliveryNoteID 产品出库单主键
     * @return 产品出库单
     */
    public AwProductdeliveryform selectAwProductdeliveryformByDeliveryNoteID(String deliveryNoteID);

    /**
     * 查询产品出库单列表
     * 
     * @param awProductdeliveryform 产品出库单
     * @return 产品出库单集合
     */
    public List<AwProductdeliveryform> selectAwProductdeliveryformList(AwProductdeliveryform awProductdeliveryform);

    /**
     * 新增产品出库单
     * 
     * @param awProductdeliveryform 产品出库单
     * @return 结果
     */
    public int insertAwProductdeliveryform(AwProductdeliveryform awProductdeliveryform);

    /**
     * 修改产品出库单
     * 
     * @param awProductdeliveryform 产品出库单
     * @return 结果
     */
    public int updateAwProductdeliveryform(AwProductdeliveryform awProductdeliveryform);

    /**
     * 批量删除产品出库单
     * 
     * @param deliveryNoteIDs 需要删除的产品出库单主键集合
     * @return 结果
     */
    public int deleteAwProductdeliveryformByDeliveryNoteIDs(String[] deliveryNoteIDs);

    /**
     * 删除产品出库单信息
     * 
     * @param deliveryNoteID 产品出库单主键
     * @return 结果
     */
    public int deleteAwProductdeliveryformByDeliveryNoteID(String deliveryNoteID);
}
