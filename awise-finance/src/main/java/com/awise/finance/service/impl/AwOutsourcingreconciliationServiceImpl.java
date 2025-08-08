package com.awise.finance.service.impl;

import com.awise.finance.domain.AwOutsourcingreconciliation;
import com.awise.finance.mapper.AwOutsourcingreconciliationMapper;
import com.awise.finance.service.IAwOutsourcingreconciliationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 外协对账详细Service业务层处理
 * 
 * @author awise
 * @date 2023-12-26
 */
@Service
public class AwOutsourcingreconciliationServiceImpl implements IAwOutsourcingreconciliationService 
{
    @Autowired
    private AwOutsourcingreconciliationMapper awOutsourcingreconciliationMapper;

    /**
     * 查询外协对账详细
     * 
     * @param id 外协对账详细主键
     * @return 外协对账详细
     */
    @Override
    public AwOutsourcingreconciliation selectAwOutsourcingreconciliationById(Long id)
    {
        return awOutsourcingreconciliationMapper.selectAwOutsourcingreconciliationById(id);
    }

    /**
     * 查询外协对账详细列表
     * 
     * @param awOutsourcingreconciliation 外协对账详细
     * @return 外协对账详细
     */
    @Override
    public List<AwOutsourcingreconciliation> selectAwOutsourcingreconciliationList(AwOutsourcingreconciliation awOutsourcingreconciliation)
    {
        return awOutsourcingreconciliationMapper.selectAwOutsourcingreconciliationList(awOutsourcingreconciliation);
    }

    /**
     * 新增外协对账详细
     * 
     * @param awOutsourcingreconciliation 外协对账详细
     * @return 结果
     */
    @Override
    public int insertAwOutsourcingreconciliation(AwOutsourcingreconciliation awOutsourcingreconciliation)
    {
        return awOutsourcingreconciliationMapper.insertAwOutsourcingreconciliation(awOutsourcingreconciliation);
    }

    /**
     * 修改外协对账详细
     * 
     * @param awOutsourcingreconciliation 外协对账详细
     * @return 结果
     */
    @Override
    public int updateAwOutsourcingreconciliation(AwOutsourcingreconciliation awOutsourcingreconciliation)
    {
        return awOutsourcingreconciliationMapper.updateAwOutsourcingreconciliation(awOutsourcingreconciliation);
    }

    /**
     * 批量删除外协对账详细
     * 
     * @param ids 需要删除的外协对账详细主键
     * @return 结果
     */
    @Override
    public int deleteAwOutsourcingreconciliationByIds(Long[] ids)
    {
        return awOutsourcingreconciliationMapper.deleteAwOutsourcingreconciliationByIds(ids);
    }

    /**
     * 删除外协对账详细信息
     * 
     * @param id 外协对账详细主键
     * @return 结果
     */
    @Override
    public int deleteAwOutsourcingreconciliationById(Long id)
    {
        return awOutsourcingreconciliationMapper.deleteAwOutsourcingreconciliationById(id);
    }

    @Override
    public List<AwOutsourcingreconciliation> selectOne() {
        return awOutsourcingreconciliationMapper.selectAll();
    }
}
