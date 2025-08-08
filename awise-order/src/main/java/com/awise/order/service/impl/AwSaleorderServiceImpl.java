package com.awise.order.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.order.mapper.AwSaleorderMapper;
import com.awise.order.domain.AwSaleorder;
import com.awise.order.service.IAwSaleorderService;

/**
 * 订单Service业务层处理
 * 
 * @author awise
 * @date 2023-08-03
 */
@Service
public class AwSaleorderServiceImpl implements IAwSaleorderService 
{
    @Autowired
    private AwSaleorderMapper awSaleorderMapper;

    /**
     * 查询订单
     * 
     * @param id 订单主键
     * @return 订单
     */
    @Override
    public AwSaleorder selectAwSaleorderById(String id)
    {
        return awSaleorderMapper.selectAwSaleorderById(id);
    }

    /**
     * 查询订单列表
     * 
     * @param awSaleorder 订单
     * @return 订单
     */
    @Override
    public List<AwSaleorder> selectAwSaleorderList(AwSaleorder awSaleorder)
    {
        return awSaleorderMapper.selectAwSaleorderList(awSaleorder);
    }

    /**
     * 新增订单
     * 
     * @param awSaleorder 订单
     * @return 结果
     */
    @Override
    public int insertAwSaleorder(AwSaleorder awSaleorder)
    {
        return awSaleorderMapper.insertAwSaleorder(awSaleorder);
    }

    /**
     * 修改订单
     * 
     * @param awSaleorder 订单
     * @return 结果
     */
    @Override
    public int updateAwSaleorder(AwSaleorder awSaleorder)
    {
        return awSaleorderMapper.updateAwSaleorder(awSaleorder);
    }

    /**
     * 批量删除订单
     * 
     * @param ids 需要删除的订单主键
     * @return 结果
     */
    @Override
    public int deleteAwSaleorderByIds(String[] ids)
    {
        return awSaleorderMapper.deleteAwSaleorderByIds(ids);
    }

    /**
     * 删除订单信息
     * 
     * @param id 订单主键
     * @return 结果
     */
    @Override
    public int deleteAwSaleorderById(String id)
    {
        return awSaleorderMapper.deleteAwSaleorderById(id);
    }
}
