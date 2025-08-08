package com.awise.order.mapper;

import java.util.List;
import com.awise.order.domain.AwContract;

/**
 * 合同存储Mapper接口
 * 
 * @author awise
 * @date 2023-08-03
 */
public interface AwContractMapper 
{
    /**
     * 查询合同存储
     * 
     * @param id 合同存储主键
     * @return 合同存储
     */
    public AwContract selectAwContractById(String id);

    /**
     * 查询合同存储列表
     * 
     * @param awContract 合同存储
     * @return 合同存储集合
     */
    public List<AwContract> selectAwContractList(AwContract awContract);

    /**
     * 新增合同存储
     * 
     * @param awContract 合同存储
     * @return 结果
     */
    public int insertAwContract(AwContract awContract);

    /**
     * 修改合同存储
     * 
     * @param awContract 合同存储
     * @return 结果
     */
    public int updateAwContract(AwContract awContract);

    /**
     * 删除合同存储
     * 
     * @param id 合同存储主键
     * @return 结果
     */
    public int deleteAwContractById(String id);

    /**
     * 批量删除合同存储
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwContractByIds(String[] ids);
}
