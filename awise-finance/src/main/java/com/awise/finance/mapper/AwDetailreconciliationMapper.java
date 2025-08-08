package com.awise.finance.mapper;

import com.awise.finance.domain.AwDetailreconciliation;

import java.util.List;

/**
 * 对账详细Mapper接口
 * 
 * @author awise
 * @date 2023-12-22
 */
public interface AwDetailreconciliationMapper 
{
    /**
     * 查询对账详细
     * 
     * @param id 对账详细主键
     * @return 对账详细
     */
    public AwDetailreconciliation selectAwDetailreconciliationById(Long id);

    /**
     * 查询对账详细列表
     * 
     * @param awDetailreconciliation 对账详细
     * @return 对账详细集合
     */
    public List<AwDetailreconciliation> selectAwDetailreconciliationList(AwDetailreconciliation awDetailreconciliation);

    /**
     * 新增对账详细
     * 
     * @param awDetailreconciliation 对账详细
     * @return 结果
     */
    public int insertAwDetailreconciliation(AwDetailreconciliation awDetailreconciliation);

    /**
     * 修改对账详细
     * 
     * @param awDetailreconciliation 对账详细
     * @return 结果
     */
    public int updateAwDetailreconciliation(AwDetailreconciliation awDetailreconciliation);

    /**
     * 删除对账详细
     * 
     * @param id 对账详细主键
     * @return 结果
     */
    public int deleteAwDetailreconciliationById(Long id);

    /**
     * 批量删除对账详细
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwDetailreconciliationByIds(Long[] ids);

    List<AwDetailreconciliation> selectAll();
}
