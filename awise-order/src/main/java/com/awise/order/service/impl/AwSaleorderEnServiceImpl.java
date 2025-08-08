package com.awise.order.service.impl;

import com.awise.order.domain.AwSaleorderEn;
import com.awise.order.mapper.AwSaleorderEnMapper;
import com.awise.order.service.IAwSaleorderEnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单Service业务层处理
 * 
 * @author awise
 * @date 2023-08-03
 */
@Service
public class AwSaleorderEnServiceImpl implements IAwSaleorderEnService
{
    @Autowired
    private AwSaleorderEnMapper awSaleorderEnMapper;

    /**
     * 查询订单
     * 
     * @param id 订单主键
     * @return 订单
     */
    @Override
    public AwSaleorderEn selectAwSaleorderEnById(String id)
    {
        return awSaleorderEnMapper.selectAwSaleorderEnById(id);
    }

    /**
     * 查询订单列表
     * 
     * @param awSaleorderEn 订单
     * @return 订单
     */
    @Override
    public List<AwSaleorderEn> selectAwSaleorderEnList(AwSaleorderEn awSaleorderEn)
    {
        return awSaleorderEnMapper.selectAwSaleorderEnList(awSaleorderEn);
    }

    /**
     * 新增订单
     * 
     * @param awSaleorderEn 订单
     * @return 结果
     */
    @Override
    public int insertAwSaleorderEn(AwSaleorderEn awSaleorderEn)
    {
        return awSaleorderEnMapper.insertAwSaleorderEn(awSaleorderEn);
    }

    /**
     * 修改订单
     * 
     * @param awSaleorderEn 订单
     * @return 结果
     */
    @Override
    public int updateAwSaleorderEn(AwSaleorderEn awSaleorderEn)
    {
        return awSaleorderEnMapper.updateAwSaleorderEn(awSaleorderEn);
    }

    /**
     * 批量删除订单
     * 
     * @param ids 需要删除的订单主键
     * @return 结果
     */
    @Override
    public int deleteAwSaleorderEnByIds(String[] ids)
    {
        return awSaleorderEnMapper.deleteAwSaleorderEnByIds(ids);
    }

    /**
     * 删除订单信息
     * 
     * @param id 订单主键
     * @return 结果
     */
    @Override
    public int deleteAwSaleorderEnById(String id)
    {
        return awSaleorderEnMapper.deleteAwSaleorderEnById(id);
    }
}
