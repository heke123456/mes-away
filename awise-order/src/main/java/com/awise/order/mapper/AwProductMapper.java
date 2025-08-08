package com.awise.order.mapper;

import java.util.List;
import com.awise.order.domain.AwProduct;

/**
 * 产品存储Mapper接口
 * 
 * @author awise
 * @date 2023-08-03
 */
public interface AwProductMapper 
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
     * 删除产品存储
     * 
     * @param id 产品存储主键
     * @return 结果
     */
    public int deleteAwProductById(String id);

    /**
     * 批量删除产品存储
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwProductByIds(String[] ids);
}
