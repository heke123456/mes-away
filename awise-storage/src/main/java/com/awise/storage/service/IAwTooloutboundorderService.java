package com.awise.storage.service;

import java.util.List;
import com.awise.storage.domain.AwTooloutboundorder;

/**
 * 刀具出库单Service接口
 * 
 * @author awise
 * @date 2023-12-08
 */
public interface IAwTooloutboundorderService 
{
    /**
     * 查询刀具出库单
     * 
     * @param deliveryNoteID 刀具出库单主键
     * @return 刀具出库单
     */
    public AwTooloutboundorder selectAwTooloutboundorderByDeliveryNoteID(String deliveryNoteID);

    /**
     * 查询刀具出库单列表
     * 
     * @param awTooloutboundorder 刀具出库单
     * @return 刀具出库单集合
     */
    public List<AwTooloutboundorder> selectAwTooloutboundorderList(AwTooloutboundorder awTooloutboundorder);

    /**
     * 新增刀具出库单
     * 
     * @param awTooloutboundorder 刀具出库单
     * @return 结果
     */
    public int insertAwTooloutboundorder(AwTooloutboundorder awTooloutboundorder);

    /**
     * 修改刀具出库单
     * 
     * @param awTooloutboundorder 刀具出库单
     * @return 结果
     */
    public int updateAwTooloutboundorder(AwTooloutboundorder awTooloutboundorder);

    /**
     * 批量删除刀具出库单
     * 
     * @param deliveryNoteIDs 需要删除的刀具出库单主键集合
     * @return 结果
     */
    public int deleteAwTooloutboundorderByDeliveryNoteIDs(String[] deliveryNoteIDs);

    /**
     * 删除刀具出库单信息
     * 
     * @param deliveryNoteID 刀具出库单主键
     * @return 结果
     */
    public int deleteAwTooloutboundorderByDeliveryNoteID(String deliveryNoteID);
}
