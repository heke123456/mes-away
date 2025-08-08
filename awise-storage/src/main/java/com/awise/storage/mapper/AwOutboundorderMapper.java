package com.awise.storage.mapper;

import java.util.List;
import com.awise.storage.domain.AwOutboundorder;

/**
 * 出库单Mapper接口
 * 
 * @author ruoyi
 * @date 2023-10-14
 */
public interface AwOutboundorderMapper 
{
    /**
     * 查询出库单
     * 
     * @param deliveryNoteID 出库单主键
     * @return 出库单
     */
    public AwOutboundorder selectAwOutboundorderByDeliveryNoteID(String deliveryNoteID);

    /**
     * 查询出库单列表
     * 
     * @param awOutboundorder 出库单
     * @return 出库单集合
     */
    public List<AwOutboundorder> selectAwOutboundorderList(AwOutboundorder awOutboundorder);

    /**
     * 新增出库单
     * 
     * @param awOutboundorder 出库单
     * @return 结果
     */
    public int insertAwOutboundorder(AwOutboundorder awOutboundorder);

    /**
     * 修改出库单
     * 
     * @param awOutboundorder 出库单
     * @return 结果
     */
    public int updateAwOutboundorder(AwOutboundorder awOutboundorder);

    /**
     * 删除出库单
     * 
     * @param deliveryNoteID 出库单主键
     * @return 结果
     */
    public int deleteAwOutboundorderByDeliveryNoteID(String deliveryNoteID);

    /**
     * 批量删除出库单
     * 
     * @param deliveryNoteIDs 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwOutboundorderByDeliveryNoteIDs(String[] deliveryNoteIDs);
}
