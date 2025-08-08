package com.awise.produce.mapper;

import java.util.List;
import com.awise.produce.domain.AwProductdeliveryform;

/**
 * 产品出库单Mapper接口
 * 
 * @author awise
 * @date 2023-10-14
 */
public interface AwProductdeliveryformMapper 
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
     * 删除产品出库单
     * 
     * @param deliveryNoteID 产品出库单主键
     * @return 结果
     */
    public int deleteAwProductdeliveryformByDeliveryNoteID(String deliveryNoteID);

    /**
     * 批量删除产品出库单
     * 
     * @param deliveryNoteIDs 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwProductdeliveryformByDeliveryNoteIDs(String[] deliveryNoteIDs);
}
