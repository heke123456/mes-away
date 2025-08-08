package com.awise.finance.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.finance.mapper.AwReconciliationMapper;
import com.awise.finance.domain.AwReconciliation;
import com.awise.finance.service.IAwReconciliationService;

/**
 * 对账Service业务层处理
 * 
 * @author awise
 * @date 2023-12-22
 */
@Service
public class AwReconciliationServiceImpl implements IAwReconciliationService 
{
    @Autowired
    private AwReconciliationMapper awReconciliationMapper;

    /**
     * 查询对账
     * 
     * @param id 对账主键
     * @return 对账
     */
    @Override
    public AwReconciliation selectAwReconciliationById(Long id)
    {
        return awReconciliationMapper.selectAwReconciliationById(id);
    }

    /**
     * 查询对账列表
     * 
     * @param awReconciliation 对账
     * @return 对账
     */
    @Override
    public List<AwReconciliation> selectAwReconciliationList(AwReconciliation awReconciliation)
    {
        return awReconciliationMapper.selectAwReconciliationList(awReconciliation);
    }

    /**
     * 新增对账
     * 
     * @param awReconciliation 对账
     * @return 结果
     */
    @Override
    public int insertAwReconciliation(AwReconciliation awReconciliation)
    {
        return awReconciliationMapper.insertAwReconciliation(awReconciliation);
    }

    /**
     * 修改对账
     * 
     * @param awReconciliation 对账
     * @return 结果
     */
    @Override
    public int updateAwReconciliation(AwReconciliation awReconciliation)
    {
        return awReconciliationMapper.updateAwReconciliation(awReconciliation);
    }

    /**
     * 批量删除对账
     * 
     * @param ids 需要删除的对账主键
     * @return 结果
     */
    @Override
    public int deleteAwReconciliationByIds(Long[] ids)
    {
        return awReconciliationMapper.deleteAwReconciliationByIds(ids);
    }

    /**
     * 删除对账信息
     * 
     * @param id 对账主键
     * @return 结果
     */
    @Override
    public int deleteAwReconciliationById(Long id)
    {
        return awReconciliationMapper.deleteAwReconciliationById(id);
    }
}
