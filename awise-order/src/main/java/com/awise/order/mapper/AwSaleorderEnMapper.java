package com.awise.order.mapper;

import com.awise.order.domain.AwSaleorderEn;

import java.util.List;

/**
 * 订单Mapper接口
 * 
 * @author awise
 * @date 2023-08-03
 */
public interface AwSaleorderEnMapper
{
    /**
     * 查询订单
     * 
     * @param id 订单主键
     * @return 订单
     */
    public AwSaleorderEn selectAwSaleorderEnById(String id);

    /**
     * 查询订单列表
     * 
     * @param awSaleorderEn 订单
     * @return 订单集合
     */
    public List<AwSaleorderEn> selectAwSaleorderEnList(AwSaleorderEn awSaleorderEn);

    /**
     * 新增订单
     * 
     * @param awSaleorderEn 订单
     * @return 结果
     */
    public int insertAwSaleorderEn(AwSaleorderEn awSaleorderEn);

    /**
     * 修改订单
     * 
     * @param awSaleorderEn 订单
     * @return 结果
     */
    public int updateAwSaleorderEn(AwSaleorderEn awSaleorderEn);

    /**
     * 删除订单
     * 
     * @param id 订单主键
     * @return 结果
     */
    public int deleteAwSaleorderEnById(String id);

    /**
     * 批量删除订单
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwSaleorderEnByIds(String[] ids);
}
