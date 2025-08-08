package com.awise.storage.mapper;

import java.util.List;
import com.awise.storage.domain.AwMatloutbounddet;

/**
 * 材料出库详细Mapper接口
 * 
 * @author awise
 * @date 2023-10-25
 */
public interface AwMatloutbounddetMapper 
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
     * 删除材料出库详细
     * 
     * @param id 材料出库详细主键
     * @return 结果
     */
    public int deleteAwMatloutbounddetById(Long id);

    /**
     * 批量删除材料出库详细
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwMatloutbounddetByIds(Long[] ids);
}
