package com.awise.comprehensive.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.comprehensive.mapper.AwCustomMapper;
import com.awise.comprehensive.domain.AwCustom;
import com.awise.comprehensive.service.IAwCustomService;

/**
 * 客户信息Service业务层处理
 * 
 * @author awise
 * @date 2023-08-02
 */
@Service
public class AwCustomServiceImpl implements IAwCustomService 
{
    @Autowired
    private AwCustomMapper awCustomMapper;

    /**
     * 查询客户信息
     * 
     * @param ID 客户信息主键
     * @return 客户信息
     */
    @Override
    public AwCustom selectAwCustomByID(String ID)
    {
        return awCustomMapper.selectAwCustomByID(ID);
    }

    /**
     * 查询客户信息列表
     * 
     * @param awCustom 客户信息
     * @return 客户信息
     */
    @Override
    public List<AwCustom> selectAwCustomList(AwCustom awCustom)
    {
        return awCustomMapper.selectAwCustomList(awCustom);
    }

    /**
     * 新增客户信息
     * 
     * @param awCustom 客户信息
     * @return 结果
     */
    @Override
    public int insertAwCustom(AwCustom awCustom)
    {
        return awCustomMapper.insertAwCustom(awCustom);
    }

    /**
     * 修改客户信息
     * 
     * @param awCustom 客户信息
     * @return 结果
     */
    @Override
    public int updateAwCustom(AwCustom awCustom)
    {
        return awCustomMapper.updateAwCustom(awCustom);
    }

    /**
     * 批量删除客户信息
     * 
     * @param IDs 需要删除的客户信息主键
     * @return 结果
     */
    @Override
    public int deleteAwCustomByIDs(String[] IDs)
    {
        return awCustomMapper.deleteAwCustomByIDs(IDs);
    }

    /**
     * 删除客户信息信息
     * 
     * @param ID 客户信息主键
     * @return 结果
     */
    @Override
    public int deleteAwCustomByID(String ID)
    {
        return awCustomMapper.deleteAwCustomByID(ID);
    }
}
