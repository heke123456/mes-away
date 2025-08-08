package com.awise.storage.service;

import java.util.List;
import com.awise.storage.domain.AwCustomermaterialsoutboundform;

/**
 * 客供材料出库单Service接口
 * 
 * @author awise
 * @date 2024-04-23
 */
public interface IAwCustomermaterialsoutboundformService 
{
    /**
     * 查询客供材料出库单
     * 
     * @param deliveryNoteID 客供材料出库单主键
     * @return 客供材料出库单
     */
    public AwCustomermaterialsoutboundform selectAwCustomermaterialsoutboundformByDeliveryNoteID(String deliveryNoteID);

    /**
     * 查询客供材料出库单列表
     * 
     * @param awCustomermaterialsoutboundform 客供材料出库单
     * @return 客供材料出库单集合
     */
    public List<AwCustomermaterialsoutboundform> selectAwCustomermaterialsoutboundformList(AwCustomermaterialsoutboundform awCustomermaterialsoutboundform);

    /**
     * 新增客供材料出库单
     * 
     * @param awCustomermaterialsoutboundform 客供材料出库单
     * @return 结果
     */
    public int insertAwCustomermaterialsoutboundform(AwCustomermaterialsoutboundform awCustomermaterialsoutboundform);

    /**
     * 修改客供材料出库单
     * 
     * @param awCustomermaterialsoutboundform 客供材料出库单
     * @return 结果
     */
    public int updateAwCustomermaterialsoutboundform(AwCustomermaterialsoutboundform awCustomermaterialsoutboundform);

    /**
     * 批量删除客供材料出库单
     * 
     * @param deliveryNoteIDs 需要删除的客供材料出库单主键集合
     * @return 结果
     */
    public int deleteAwCustomermaterialsoutboundformByDeliveryNoteIDs(String[] deliveryNoteIDs);

    /**
     * 删除客供材料出库单信息
     * 
     * @param deliveryNoteID 客供材料出库单主键
     * @return 结果
     */
    public int deleteAwCustomermaterialsoutboundformByDeliveryNoteID(String deliveryNoteID);
}
