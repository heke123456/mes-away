package com.awise.order.service;

import java.util.List;
import com.awise.order.domain.AwProduct;

/**
 * 产品存储Service接口
 * 
 * @author awise
 * @date 2023-08-03
 */
public interface IAwProductService 
{
    /**
     * 查询产品存储
     * 
     * @param id 产品存储主键
     * @return 产品存储
     */
    public AwProduct selectAwProductById(String id);

    /**
     * 查询产品存储列表
     * 
     * @param awProduct 产品存储
     * @return 产品存储集合
     */
    public List<AwProduct> selectAwProductList(AwProduct awProduct);

    /**
     * 新增产品存储
     * 
     * @param awProduct 产品存储
     * @return 结果
     */
    public int insertAwProduct(AwProduct awProduct);

    /**
     * 修改产品存储
     * 
     * @param awProduct 产品存储
     * @return 结果
     */
    public int updateAwProduct(AwProduct awProduct);

    /**
     * 批量删除产品存储
     * 
     * @param ids 需要删除的产品存储主键集合
     * @return 结果
     */
    public int deleteAwProductByIds(String[] ids);

    /**
     * 删除产品存储信息
     * 
     * @param id 产品存储主键
     * @return 结果
     */
    public int deleteAwProductById(String id);
}
