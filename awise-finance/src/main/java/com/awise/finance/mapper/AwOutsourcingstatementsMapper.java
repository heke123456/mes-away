package com.awise.finance.mapper;

import java.util.List;
import com.awise.finance.domain.AwOutsourcingstatements;

/**
 * 外协对账Mapper接口
 * 
 * @author awise
 * @date 2023-12-26
 */
public interface AwOutsourcingstatementsMapper 
{
    /**
     * 查询外协对账
     * 
     * @param outsourcingStatementsID 外协对账主键
     * @return 外协对账
     */
    public AwOutsourcingstatements selectAwOutsourcingstatementsByOutsourcingStatementsID(String outsourcingStatementsID);

    /**
     * 查询外协对账列表
     * 
     * @param awOutsourcingstatements 外协对账
     * @return 外协对账集合
     */
    public List<AwOutsourcingstatements> selectAwOutsourcingstatementsList(AwOutsourcingstatements awOutsourcingstatements);

    /**
     * 新增外协对账
     * 
     * @param awOutsourcingstatements 外协对账
     * @return 结果
     */
    public int insertAwOutsourcingstatements(AwOutsourcingstatements awOutsourcingstatements);

    /**
     * 修改外协对账
     * 
     * @param awOutsourcingstatements 外协对账
     * @return 结果
     */
    public int updateAwOutsourcingstatements(AwOutsourcingstatements awOutsourcingstatements);

    /**
     * 删除外协对账
     * 
     * @param outsourcingStatementsID 外协对账主键
     * @return 结果
     */
    public int deleteAwOutsourcingstatementsByOutsourcingStatementsID(String outsourcingStatementsID);

    /**
     * 批量删除外协对账
     * 
     * @param outsourcingStatementsIDs 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwOutsourcingstatementsByOutsourcingStatementsIDs(String[] outsourcingStatementsIDs);
}
