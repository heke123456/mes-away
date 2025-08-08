package com.awise.order.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.order.mapper.AwContractMapper;
import com.awise.order.domain.AwContract;
import com.awise.order.service.IAwContractService;

/**
 * 合同存储Service业务层处理
 * 
 * @author awise
 * @date 2023-08-03
 */
@Service
public class AwContractServiceImpl implements IAwContractService 
{
    @Autowired
    private AwContractMapper awContractMapper;

    /**
     * 查询合同存储
     * 
     * @param id 合同存储主键
     * @return 合同存储
     */
    @Override
    public AwContract selectAwContractById(String id)
    {
        return awContractMapper.selectAwContractById(id);
    }

    /**
     * 查询合同存储列表
     * 
     * @param awContract 合同存储
     * @return 合同存储
     */
    @Override
    public List<AwContract> selectAwContractList(AwContract awContract)
    {
        return awContractMapper.selectAwContractList(awContract);
    }

    /**
     * 新增合同存储
     * 
     * @param awContract 合同存储
     * @return 结果
     */
    @Override
    public int insertAwContract(AwContract awContract)
    {
        return awContractMapper.insertAwContract(awContract);
    }

    /**
     * 修改合同存储
     * 
     * @param awContract 合同存储
     * @return 结果
     */
    @Override
    public int updateAwContract(AwContract awContract)
    {
        return awContractMapper.updateAwContract(awContract);
    }

    /**
     * 批量删除合同存储
     * 
     * @param ids 需要删除的合同存储主键
     * @return 结果
     */
    @Override
    public int deleteAwContractByIds(String[] ids)
    {
        return awContractMapper.deleteAwContractByIds(ids);
    }

    /**
     * 删除合同存储信息
     * 
     * @param id 合同存储主键
     * @return 结果
     */
    @Override
    public int deleteAwContractById(String id)
    {
        return awContractMapper.deleteAwContractById(id);
    }
}
