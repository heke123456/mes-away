package com.awise.finance.mapper;

import java.util.List;
import com.awise.finance.domain.AwStatementofaccount;

/**
 * 对账单Mapper接口
 * 
 * @author awise
 * @date 2023-12-22
 */
public interface AwStatementofaccountMapper 
{
    /**
     * 查询对账单
     * 
     * @param statementOfAccountID 对账单主键
     * @return 对账单
     */
    public AwStatementofaccount selectAwStatementofaccountByStatementOfAccountID(String statementOfAccountID);

    /**
     * 查询对账单列表
     * 
     * @param awStatementofaccount 对账单
     * @return 对账单集合
     */
    public List<AwStatementofaccount> selectAwStatementofaccountList(AwStatementofaccount awStatementofaccount);

    /**
     * 新增对账单
     * 
     * @param awStatementofaccount 对账单
     * @return 结果
     */
    public int insertAwStatementofaccount(AwStatementofaccount awStatementofaccount);

    /**
     * 修改对账单
     * 
     * @param awStatementofaccount 对账单
     * @return 结果
     */
    public int updateAwStatementofaccount(AwStatementofaccount awStatementofaccount);

    /**
     * 删除对账单
     * 
     * @param statementOfAccountID 对账单主键
     * @return 结果
     */
    public int deleteAwStatementofaccountByStatementOfAccountID(String statementOfAccountID);

    /**
     * 批量删除对账单
     * 
     * @param statementOfAccountIDs 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwStatementofaccountByStatementOfAccountIDs(String[] statementOfAccountIDs);
}
