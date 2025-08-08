package com.awise.finance.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.finance.mapper.AwStatementofaccountMapper;
import com.awise.finance.domain.AwStatementofaccount;
import com.awise.finance.service.IAwStatementofaccountService;

/**
 * 对账单Service业务层处理
 * 
 * @author awise
 * @date 2023-12-22
 */
@Service
public class AwStatementofaccountServiceImpl implements IAwStatementofaccountService 
{
    @Autowired
    private AwStatementofaccountMapper awStatementofaccountMapper;

    /**
     * 查询对账单
     * 
     * @param statementOfAccountID 对账单主键
     * @return 对账单
     */
    @Override
    public AwStatementofaccount selectAwStatementofaccountByStatementOfAccountID(String statementOfAccountID)
    {
        return awStatementofaccountMapper.selectAwStatementofaccountByStatementOfAccountID(statementOfAccountID);
    }

    /**
     * 查询对账单列表
     * 
     * @param awStatementofaccount 对账单
     * @return 对账单
     */
    @Override
    public List<AwStatementofaccount> selectAwStatementofaccountList(AwStatementofaccount awStatementofaccount)
    {
        return awStatementofaccountMapper.selectAwStatementofaccountList(awStatementofaccount);
    }

    /**
     * 新增对账单
     * 
     * @param awStatementofaccount 对账单
     * @return 结果
     */
    @Override
    public int insertAwStatementofaccount(AwStatementofaccount awStatementofaccount)
    {
        return awStatementofaccountMapper.insertAwStatementofaccount(awStatementofaccount);
    }

    /**
     * 修改对账单
     * 
     * @param awStatementofaccount 对账单
     * @return 结果
     */
    @Override
    public int updateAwStatementofaccount(AwStatementofaccount awStatementofaccount)
    {
        return awStatementofaccountMapper.updateAwStatementofaccount(awStatementofaccount);
    }

    /**
     * 批量删除对账单
     * 
     * @param statementOfAccountIDs 需要删除的对账单主键
     * @return 结果
     */
    @Override
    public int deleteAwStatementofaccountByStatementOfAccountIDs(String[] statementOfAccountIDs)
    {
        return awStatementofaccountMapper.deleteAwStatementofaccountByStatementOfAccountIDs(statementOfAccountIDs);
    }

    /**
     * 删除对账单信息
     * 
     * @param statementOfAccountID 对账单主键
     * @return 结果
     */
    @Override
    public int deleteAwStatementofaccountByStatementOfAccountID(String statementOfAccountID)
    {
        return awStatementofaccountMapper.deleteAwStatementofaccountByStatementOfAccountID(statementOfAccountID);
    }


}
