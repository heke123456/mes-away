package com.awise.storage.service;

import java.util.List;
import com.awise.storage.domain.AwMatloutbounddet;

/**
 * 材料出库详细Service接口
 * 
 * @author awise
 * @date 2023-10-25
 */
public interface IAwMatloutbounddetService 
{
    /**
     * 查询材料出库详细
     * 
     * @param id 材料出库详细主键
     * @return 材料出库详细
     */
    public AwMatloutbounddet selectAwMatloutbounddetById(Long id);

    /**
     * 查询材料出库详细列表
     * 
     * @param awMatloutbounddet 材料出库详细
     * @return 材料出库详细集合
     */
    public List<AwMatloutbounddet> selectAwMatloutbounddetList(AwMatloutbounddet awMatloutbounddet);

    /**
     * 新增材料出库详细
     * 
     * @param awMatloutbounddet 材料出库详细
     * @return 结果
     */
    public int insertAwMatloutbounddet(AwMatloutbounddet awMatloutbounddet);

    /**
     * 修改材料出库详细
     * 
     * @param awMatloutbounddet 材料出库详细
     * @return 结果
     */
    public int updateAwMatloutbounddet(AwMatloutbounddet awMatloutbounddet);

    /**
     * 批量删除材料出库详细
     * 
     * @param ids 需要删除的材料出库详细主键集合
     * @return 结果
     */
    public int deleteAwMatloutbounddetByIds(Long[] ids);

    /**
     * 删除材料出库详细信息
     * 
     * @param id 材料出库详细主键
     * @return 结果
     */
    public int deleteAwMatloutbounddetById(Long id);
}
