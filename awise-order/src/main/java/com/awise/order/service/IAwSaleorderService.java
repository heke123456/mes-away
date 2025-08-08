package com.awise.order.service;

import java.util.List;
import com.awise.order.domain.AwSaleorder;

/**
 * 订单Service接口
 * 
 * @author awise
 * @date 2023-08-03
 */
public interface IAwSaleorderService
{
    /**
     * 查询订单
     * 
     * @param id 订单主键
     * @return 订单
     */
    public AwSaleorder selectAwSaleorderById(String id);

    /**
     * 查询订单列表
     * 
     * @param awSaleorder 订单
     * @return 订单集合
     */
    public List<AwSaleorder> selectAwSaleorderList(AwSaleorder awSaleorder);

    /**
     * 新增订单
     * 
     * @param awSaleorder 订单
     * @return 结果
     */
    public int insertAwSaleorder(AwSaleorder awSaleorder);

    /**
     * 修改订单
     * 
     * @param awSaleorder 订单
     * @return 结果
     */
    public int updateAwSaleorder(AwSaleorder awSaleorder);

    /**
     * 批量删除订单
     * 
     * @param ids 需要删除的订单主键集合
     * @return 结果
     */
    public int deleteAwSaleorderByIds(String[] ids);

    /**
     * 删除订单信息
     * 
     * @param id 订单主键
     * @return 结果
     */
    public int deleteAwSaleorderById(String id);
}
