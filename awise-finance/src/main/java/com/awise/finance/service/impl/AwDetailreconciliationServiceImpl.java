package com.awise.finance.service.impl;

import com.awise.finance.domain.AwDetailreconciliation;
import com.awise.finance.mapper.AwDetailreconciliationMapper;
import com.awise.finance.service.IAwDetailreconciliationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 对账详细Service业务层处理
 * 
 * @author awise
 * @date 2023-12-22
 */
@Service
public class AwDetailreconciliationServiceImpl implements IAwDetailreconciliationService 
{
    @Autowired
    private AwDetailreconciliationMapper awDetailreconciliationMapper;

    /**
     * 查询对账详细
     * 
     * @param id 对账详细主键
     * @return 对账详细
     */
    @Override
    public AwDetailreconciliation selectAwDetailreconciliationById(Long id)
    {
        return awDetailreconciliationMapper.selectAwDetailreconciliationById(id);
    }

    /**
     * 查询对账详细列表
     * 
     * @param awDetailreconciliation 对账详细
     * @return 对账详细
     */
    @Override
    public List<AwDetailreconciliation> selectAwDetailreconciliationList(AwDetailreconciliation awDetailreconciliation)
    {
        return awDetailreconciliationMapper.selectAwDetailreconciliationList(awDetailreconciliation);
    }

    /**
     * 新增对账详细
     * 
     * @param awDetailreconciliation 对账详细
     * @return 结果
     */
    @Override
    public int insertAwDetailreconciliation(AwDetailreconciliation awDetailreconciliation)
    {
        return awDetailreconciliationMapper.insertAwDetailreconciliation(awDetailreconciliation);
    }

    /**
     * 修改对账详细
     * 
     * @param awDetailreconciliation 对账详细
     * @return 结果
     */
    @Override
    public int updateAwDetailreconciliation(AwDetailreconciliation awDetailreconciliation)
    {
        return awDetailreconciliationMapper.updateAwDetailreconciliation(awDetailreconciliation);
    }

    /**
     * 批量删除对账详细
     * 
     * @param ids 需要删除的对账详细主键
     * @return 结果
     */
    @Override
    public int deleteAwDetailreconciliationByIds(Long[] ids)
    {
        return awDetailreconciliationMapper.deleteAwDetailreconciliationByIds(ids);
    }

    /**
     * 删除对账详细信息
     * 
     * @param id 对账详细主键
     * @return 结果
     */
    @Override
    public int deleteAwDetailreconciliationById(Long id)
    {
        return awDetailreconciliationMapper.deleteAwDetailreconciliationById(id);
    }

    @Override
    public List<AwDetailreconciliation> selectAll() {
        return awDetailreconciliationMapper.selectAll();
    }
}
