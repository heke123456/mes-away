package com.awise.order.mapper;

import java.util.List;
import com.awise.order.domain.AwAdditional;

/**
 * 订单附加信息Mapper接口
 * 
 * @author awise
 * @date 2023-08-14
 */
public interface AwAdditionalMapper 
{
    /**
     * 查询订单附加信息
     * 
     * @param id 订单附加信息主键
     * @return 订单附加信息
     */
    public AwAdditional selectAwAdditionalById(Long id);

    /**
     * 查询订单附加信息列表
     * 
     * @param awAdditional 订单附加信息
     * @return 订单附加信息集合
     */
    public List<AwAdditional> selectAwAdditionalList(AwAdditional awAdditional);

    /**
     * 新增订单附加信息
     * 
     * @param awAdditional 订单附加信息
     * @return 结果
     */
    public int insertAwAdditional(AwAdditional awAdditional);

    /**
     * 修改订单附加信息
     * 
     * @param awAdditional 订单附加信息
     * @return 结果
     */
    public int updateAwAdditional(AwAdditional awAdditional);

    /**
     * 删除订单附加信息
     * 
     * @param id 订单附加信息主键
     * @return 结果
     */
    public int deleteAwAdditionalById(Long id);

    /**
     * 批量删除订单附加信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwAdditionalByIds(Long[] ids);
}
