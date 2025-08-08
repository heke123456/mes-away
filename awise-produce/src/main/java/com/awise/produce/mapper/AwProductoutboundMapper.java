package com.awise.produce.mapper;

import java.util.List;
import com.awise.produce.domain.AwProductoutbound;

/**
 * 产品出库Mapper接口
 * 
 * @author awise
 * @date 2023-10-16
 */
public interface AwProductoutboundMapper 
{
    /**
     * 查询产品出库
     * 
     * @param id 产品出库主键
     * @return 产品出库
     */
    public AwProductoutbound selectAwProductoutboundById(Long id);

    /**
     * 查询产品出库列表
     * 
     * @param awProductoutbound 产品出库
     * @return 产品出库集合
     */
    public List<AwProductoutbound> selectAwProductoutboundList(AwProductoutbound awProductoutbound);

    /**
     * 新增产品出库
     * 
     * @param awProductoutbound 产品出库
     * @return 结果
     */
    public int insertAwProductoutbound(AwProductoutbound awProductoutbound);

    /**
     * 修改产品出库
     * 
     * @param awProductoutbound 产品出库
     * @return 结果
     */
    public int updateAwProductoutbound(AwProductoutbound awProductoutbound);

    /**
     * 删除产品出库
     * 
     * @param id 产品出库主键
     * @return 结果
     */
    public int deleteAwProductoutboundById(Long id);

    /**
     * 批量删除产品出库
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwProductoutboundByIds(Long[] ids);
}
