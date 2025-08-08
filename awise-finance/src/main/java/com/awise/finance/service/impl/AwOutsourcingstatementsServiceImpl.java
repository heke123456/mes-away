package com.awise.finance.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.finance.mapper.AwOutsourcingstatementsMapper;
import com.awise.finance.domain.AwOutsourcingstatements;
import com.awise.finance.service.IAwOutsourcingstatementsService;

/**
 * 外协对账Service业务层处理
 * 
 * @author awise
 * @date 2023-12-26
 */
@Service
public class AwOutsourcingstatementsServiceImpl implements IAwOutsourcingstatementsService 
{
    @Autowired
    private AwOutsourcingstatementsMapper awOutsourcingstatementsMapper;

    /**
     * 查询外协对账
     * 
     * @param outsourcingStatementsID 外协对账主键
     * @return 外协对账
     */
    @Override
    public AwOutsourcingstatements selectAwOutsourcingstatementsByOutsourcingStatementsID(String outsourcingStatementsID)
    {
        return awOutsourcingstatementsMapper.selectAwOutsourcingstatementsByOutsourcingStatementsID(outsourcingStatementsID);
    }

    /**
     * 查询外协对账列表
     * 
     * @param awOutsourcingstatements 外协对账
     * @return 外协对账
     */
    @Override
    public List<AwOutsourcingstatements> selectAwOutsourcingstatementsList(AwOutsourcingstatements awOutsourcingstatements)
    {
        return awOutsourcingstatementsMapper.selectAwOutsourcingstatementsList(awOutsourcingstatements);
    }

    /**
     * 新增外协对账
     * 
     * @param awOutsourcingstatements 外协对账
     * @return 结果
     */
    @Override
    public int insertAwOutsourcingstatements(AwOutsourcingstatements awOutsourcingstatements)
    {
        return awOutsourcingstatementsMapper.insertAwOutsourcingstatements(awOutsourcingstatements);
    }

    /**
     * 修改外协对账
     * 
     * @param awOutsourcingstatements 外协对账
     * @return 结果
     */
    @Override
    public int updateAwOutsourcingstatements(AwOutsourcingstatements awOutsourcingstatements)
    {
        return awOutsourcingstatementsMapper.updateAwOutsourcingstatements(awOutsourcingstatements);
    }

    /**
     * 批量删除外协对账
     * 
     * @param outsourcingStatementsIDs 需要删除的外协对账主键
     * @return 结果
     */
    @Override
    public int deleteAwOutsourcingstatementsByOutsourcingStatementsIDs(String[] outsourcingStatementsIDs)
    {
        return awOutsourcingstatementsMapper.deleteAwOutsourcingstatementsByOutsourcingStatementsIDs(outsourcingStatementsIDs);
    }

    /**
     * 删除外协对账信息
     * 
     * @param outsourcingStatementsID 外协对账主键
     * @return 结果
     */
    @Override
    public int deleteAwOutsourcingstatementsByOutsourcingStatementsID(String outsourcingStatementsID)
    {
        return awOutsourcingstatementsMapper.deleteAwOutsourcingstatementsByOutsourcingStatementsID(outsourcingStatementsID);
    }
}
