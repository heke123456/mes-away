package com.awise.storage.service;

import java.util.List;
import com.awise.storage.domain.AwTooloutbound;

/**
 * 刀具出库Service接口
 * 
 * @author awise
 * @date 2023-12-08
 */
public interface IAwTooloutboundService 
{
    /**
     * 查询刀具出库
     * 
     * @param id 刀具出库主键
     * @return 刀具出库
     */
    public AwTooloutbound selectAwTooloutboundById(Long id);

    /**
     * 查询刀具出库列表
     * 
     * @param awTooloutbound 刀具出库
     * @return 刀具出库集合
     */
    public List<AwTooloutbound> selectAwTooloutboundList(AwTooloutbound awTooloutbound);

    /**
     * 新增刀具出库
     * 
     * @param awTooloutbound 刀具出库
     * @return 结果
     */
    public int insertAwTooloutbound(AwTooloutbound awTooloutbound);

    /**
     * 修改刀具出库
     * 
     * @param awTooloutbound 刀具出库
     * @return 结果
     */
    public int updateAwTooloutbound(AwTooloutbound awTooloutbound);

    /**
     * 批量删除刀具出库
     * 
     * @param ids 需要删除的刀具出库主键集合
     * @return 结果
     */
    public int deleteAwTooloutboundByIds(Long[] ids);

    /**
     * 删除刀具出库信息
     * 
     * @param id 刀具出库主键
     * @return 结果
     */
    public int deleteAwTooloutboundById(Long id);
}
