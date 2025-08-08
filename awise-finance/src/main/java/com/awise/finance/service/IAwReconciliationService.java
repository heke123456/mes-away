package com.awise.finance.service;

import java.util.List;
import com.awise.finance.domain.AwReconciliation;

/**
 * 对账Service接口
 * 
 * @author awise
 * @date 2023-12-22
 */
public interface IAwReconciliationService 
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
     * 批量删除对账
     * 
     * @param ids 需要删除的对账主键集合
     * @return 结果
     */
    public int deleteAwReconciliationByIds(Long[] ids);

    /**
     * 删除对账信息
     * 
     * @param id 对账主键
     * @return 结果
     */
    public int deleteAwReconciliationById(Long id);
}
