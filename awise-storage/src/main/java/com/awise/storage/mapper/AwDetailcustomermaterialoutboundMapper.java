package com.awise.storage.mapper;

import java.util.List;
import com.awise.storage.domain.AwDetailcustomermaterialoutbound;

/**
 * 客供材料出库详细Mapper接口
 * 
 * @author awise
 * @date 2024-04-23
 */
public interface AwDetailcustomermaterialoutboundMapper 
{
    /**
     * 查询客供材料出库详细
     * 
     * @param id 客供材料出库详细主键
     * @return 客供材料出库详细
     */
    public AwDetailcustomermaterialoutbound selectAwDetailcustomermaterialoutboundById(Long id);

    /**
     * 查询客供材料出库详细列表
     * 
     * @param awDetailcustomermaterialoutbound 客供材料出库详细
     * @return 客供材料出库详细集合
     */
    public List<AwDetailcustomermaterialoutbound> selectAwDetailcustomermaterialoutboundList(AwDetailcustomermaterialoutbound awDetailcustomermaterialoutbound);

    /**
     * 新增客供材料出库详细
     * 
     * @param awDetailcustomermaterialoutbound 客供材料出库详细
     * @return 结果
     */
    public int insertAwDetailcustomermaterialoutbound(AwDetailcustomermaterialoutbound awDetailcustomermaterialoutbound);

    /**
     * 修改客供材料出库详细
     * 
     * @param awDetailcustomermaterialoutbound 客供材料出库详细
     * @return 结果
     */
    public int updateAwDetailcustomermaterialoutbound(AwDetailcustomermaterialoutbound awDetailcustomermaterialoutbound);

    /**
     * 删除客供材料出库详细
     * 
     * @param id 客供材料出库详细主键
     * @return 结果
     */
    public int deleteAwDetailcustomermaterialoutboundById(Long id);

    /**
     * 批量删除客供材料出库详细
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwDetailcustomermaterialoutboundByIds(Long[] ids);
}
