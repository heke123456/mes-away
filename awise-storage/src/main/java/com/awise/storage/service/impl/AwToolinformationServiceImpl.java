package com.awise.storage.service.impl;

import java.util.List;

import com.awise.storage.domain.AwToolinformationEn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.storage.mapper.AwToolinformationMapper;
import com.awise.storage.domain.AwToolinformation;
import com.awise.storage.service.IAwToolinformationService;

/**
 * 刀具信息Service业务层处理
 * 
 * @author awise
 * @date 2023-07-27
 */
@Service
public class AwToolinformationServiceImpl implements IAwToolinformationService
{
    @Autowired
    private AwToolinformationMapper awToolinformationMapper;

    /**
     * 查询刀具信息
     * 
     * @param id 刀具信息主键
     * @return 刀具信息
     */
    @Override
    public AwToolinformation selectAwToolinformationById(String id)
    {
        return awToolinformationMapper.selectAwToolinformationById(id);
    }

    /**
     * 查询刀具信息列表实体
     *
     * @param awToolinformation 刀具信息
     * @return 刀具信息
     */
    @Override
    public List<AwToolinformationEn> selectAwToolinformationEnList(AwToolinformationEn awToolinformationEn)
    {
        return awToolinformationMapper.selectAwToolinformationEnList(awToolinformationEn);
    }

    /**
     * 查询刀具信息列表
     * 
     * @param awToolinformation 刀具信息
     * @return 刀具信息
     */
    @Override
    public List<AwToolinformation> selectAwToolinformationList(AwToolinformation awToolinformation)
    {
        return awToolinformationMapper.selectAwToolinformationList(awToolinformation);
    }

    /**
     * 新增刀具信息
     * 
     * @param awToolinformation 刀具信息
     * @return 结果
     */
    @Override
    public int insertAwToolinformation(AwToolinformation awToolinformation)
    {
        return awToolinformationMapper.insertAwToolinformation(awToolinformation);
    }

    /**
     * 修改刀具信息
     * 
     * @param awToolinformation 刀具信息
     * @return 结果
     */
    @Override
    public int updateAwToolinformation(AwToolinformation awToolinformation)
    {
        return awToolinformationMapper.updateAwToolinformation(awToolinformation);
    }

    /**
     * 批量删除刀具信息
     * 
     * @param ids 需要删除的刀具信息主键
     * @return 结果
     */
    @Override
    public int deleteAwToolinformationByIds(String[] ids)
    {
        return awToolinformationMapper.deleteAwToolinformationByIds(ids);
    }

    /**
     * 删除刀具信息信息
     * 
     * @param id 刀具信息主键
     * @return 结果
     */
    @Override
    public int deleteAwToolinformationById(String id)
    {
        return awToolinformationMapper.deleteAwToolinformationById(id);
    }
}
