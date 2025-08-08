package com.awise.finance.mapper;

import java.util.List;
import com.awise.finance.domain.AwReconciliation;

/**
 * 对账Mapper接口
 * 
 * @author awise
 * @date 2023-12-22
 */
public interface AwReconciliationMapper 
{
    /**
     * 查询对账
     * 
     * @param id 对账主键
     * @return 对账
     */
    public AwReconciliation selectAwReconciliationById(Long id);

    /**
     * 查询对账列表
     * 
     * @param awReconciliation 对账
     * @return 对账集合
     */
    public List<AwReconciliation> selectAwReconciliationList(AwReconciliation awReconciliation);

    /**
     * 新增对账
     * 
     * @param awReconciliation 对账
     * @return 结果
     */
    public int insertAwReconciliation(AwReconciliation awReconciliation);

    /**
     * 修改对账
     * 
     * @param awReconciliation 对账
     * @return 结果
     */
    public int updateAwReconciliation(AwReconciliation awReconciliation);

    /**
     * 删除对账
     * 
     * @param id 对账主键
     * @return 结果
     */
    public int deleteAwReconciliationById(Long id);

    /**
     * 批量删除对账
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwReconciliationByIds(Long[] ids);
}
