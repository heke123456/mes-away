package com.awise.order.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.order.mapper.AwProductMapper;
import com.awise.order.domain.AwProduct;
import com.awise.order.service.IAwProductService;

/**
 * 产品存储Service业务层处理
 * 
 * @author awise
 * @date 2023-08-03
 */
@Service
public class AwProductServiceImpl implements IAwProductService 
{
    @Autowired
    private AwProductMapper awProductMapper;

    /**
     * 查询产品存储
     * 
     * @param id 产品存储主键
     * @return 产品存储
     */
    @Override
    public AwProduct selectAwProductById(String id)
    {
        return awProductMapper.selectAwProductById(id);
    }

    /**
     * 查询产品存储列表
     * 
     * @param awProduct 产品存储
     * @return 产品存储
     */
    @Override
    public List<AwProduct> selectAwProductList(AwProduct awProduct)
    {
        return awProductMapper.selectAwProductList(awProduct);
    }

    /**
     * 新增产品存储
     * 
     * @param awProduct 产品存储
     * @return 结果
     */
    @Override
    public int insertAwProduct(AwProduct awProduct)
    {
        return awProductMapper.insertAwProduct(awProduct);
    }

    /**
     * 修改产品存储
     * 
     * @param awProduct 产品存储
     * @return 结果
     */
    @Override
    public int updateAwProduct(AwProduct awProduct)
    {
        return awProductMapper.updateAwProduct(awProduct);
    }

    /**
     * 批量删除产品存储
     * 
     * @param ids 需要删除的产品存储主键
     * @return 结果
     */
    @Override
    public int deleteAwProductByIds(String[] ids)
    {
        return awProductMapper.deleteAwProductByIds(ids);
    }

    /**
     * 删除产品存储信息
     * 
     * @param id 产品存储主键
     * @return 结果
     */
    @Override
    public int deleteAwProductById(String id)
    {
        return awProductMapper.deleteAwProductById(id);
    }
}
