package com.awise.storage.service;

import java.util.List;
import com.awise.storage.domain.AwDetailsoftooldelivery;

/**
 * 刀具出库详细Service接口
 * 
 * @author awise
 * @date 2023-12-08
 */
public interface IAwDetailsoftooldeliveryService 
{
    /**
     * 查询刀具出库详细
     * 
     * @param id 刀具出库详细主键
     * @return 刀具出库详细
     */
    public AwDetailsoftooldelivery selectAwDetailsoftooldeliveryById(Long id);

    /**
     * 查询刀具出库详细列表
     * 
     * @param awDetailsoftooldelivery 刀具出库详细
     * @return 刀具出库详细集合
     */
    public List<AwDetailsoftooldelivery> selectAwDetailsoftooldeliveryList(AwDetailsoftooldelivery awDetailsoftooldelivery);

    /**
     * 新增刀具出库详细
     * 
     * @param awDetailsoftooldelivery 刀具出库详细
     * @return 结果
     */
    public int insertAwDetailsoftooldelivery(AwDetailsoftooldelivery awDetailsoftooldelivery);

    /**
     * 修改刀具出库详细
     * 
     * @param awDetailsoftooldelivery 刀具出库详细
     * @return 结果
     */
    public int updateAwDetailsoftooldelivery(AwDetailsoftooldelivery awDetailsoftooldelivery);

    /**
     * 批量删除刀具出库详细
     * 
     * @param ids 需要删除的刀具出库详细主键集合
     * @return 结果
     */
    public int deleteAwDetailsoftooldeliveryByIds(Long[] ids);

    /**
     * 删除刀具出库详细信息
     * 
     * @param id 刀具出库详细主键
     * @return 结果
     */
    public int deleteAwDetailsoftooldeliveryById(Long id);
}
