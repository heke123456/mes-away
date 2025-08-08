package com.awise.order.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.order.mapper.AwAdditionalMapper;
import com.awise.order.domain.AwAdditional;
import com.awise.order.service.IAwAdditionalService;

/**
 * 订单附加信息Service业务层处理
 * 
 * @author awise
 * @date 2023-08-14
 */
@Service
public class AwAdditionalServiceImpl implements IAwAdditionalService 
{
    @Autowired
    private AwAdditionalMapper awAdditionalMapper;

    /**
     * 查询订单附加信息
     * 
     * @param id 订单附加信息主键
     * @return 订单附加信息
     */
    @Override
    public AwAdditional selectAwAdditionalById(Long id)
    {
        return awAdditionalMapper.selectAwAdditionalById(id);
    }

    /**
     * 查询订单附加信息列表
     * 
     * @param awAdditional 订单附加信息
     * @return 订单附加信息
     */
    @Override
    public List<AwAdditional> selectAwAdditionalList(AwAdditional awAdditional)
    {
        return awAdditionalMapper.selectAwAdditionalList(awAdditional);
    }

    /**
     * 新增订单附加信息
     * 
     * @param awAdditional 订单附加信息
     * @return 结果
     */
    @Override
    public int insertAwAdditional(AwAdditional awAdditional)
    {
        return awAdditionalMapper.insertAwAdditional(awAdditional);
    }

    /**
     * 修改订单附加信息
     * 
     * @param awAdditional 订单附加信息
     * @return 结果
     */
    @Override
    public int updateAwAdditional(AwAdditional awAdditional)
    {
        return awAdditionalMapper.updateAwAdditional(awAdditional);
    }

    /**
     * 批量删除订单附加信息
     * 
     * @param ids 需要删除的订单附加信息主键
     * @return 结果
     */
    @Override
    public int deleteAwAdditionalByIds(Long[] ids)
    {
        return awAdditionalMapper.deleteAwAdditionalByIds(ids);
    }

    /**
     * 删除订单附加信息信息
     * 
     * @param id 订单附加信息主键
     * @return 结果
     */
    @Override
    public int deleteAwAdditionalById(Long id)
    {
        return awAdditionalMapper.deleteAwAdditionalById(id);
    }
}
