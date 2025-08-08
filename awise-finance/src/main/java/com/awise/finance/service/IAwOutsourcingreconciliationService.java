package com.awise.finance.service;

import com.awise.finance.domain.AwOutsourcingreconciliation;

import java.util.List;

/**
 * 外协对账详细Service接口
 * 
 * @author awise
 * @date 2023-12-26
 */
public interface IAwOutsourcingreconciliationService 
{
    /**
     * 查询外协对账详细
     * 
     * @param id 外协对账详细主键
     * @return 外协对账详细
     */
    public AwOutsourcingreconciliation selectAwOutsourcingreconciliationById(Long id);

    /**
     * 查询外协对账详细列表
     * 
     * @param awOutsourcingreconciliation 外协对账详细
     * @return 外协对账详细集合
     */
    public List<AwOutsourcingreconciliation> selectAwOutsourcingreconciliationList(AwOutsourcingreconciliation awOutsourcingreconciliation);

    /**
     * 新增外协对账详细
     * 
     * @param awOutsourcingreconciliation 外协对账详细
     * @return 结果
     */
    public int insertAwOutsourcingreconciliation(AwOutsourcingreconciliation awOutsourcingreconciliation);

    /**
     * 修改外协对账详细
     * 
     * @param awOutsourcingreconciliation 外协对账详细
     * @return 结果
     */
    public int updateAwOutsourcingreconciliation(AwOutsourcingreconciliation awOutsourcingreconciliation);

    /**
     * 批量删除外协对账详细
     * 
     * @param ids 需要删除的外协对账详细主键集合
     * @return 结果
     */
    public int deleteAwOutsourcingreconciliationByIds(Long[] ids);

    /**
     * 删除外协对账详细信息
     * 
     * @param id 外协对账详细主键
     * @return 结果
     */
    public int deleteAwOutsourcingreconciliationById(Long id);

    List<AwOutsourcingreconciliation> selectOne();
}
