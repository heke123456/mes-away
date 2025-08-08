package com.awise.storage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.storage.mapper.AwBasictoolinformationMapper;
import com.awise.storage.domain.AwBasictoolinformation;
import com.awise.storage.service.IAwBasictoolinformationService;

/**
 * BasicToolInformationService业务层处理
 * 
 * @author awise
 * @date 2023-12-06
 */
@Service
public class AwBasictoolinformationServiceImpl implements IAwBasictoolinformationService 
{
    @Autowired
    private AwBasictoolinformationMapper awBasictoolinformationMapper;

    /**
     * 查询BasicToolInformation
     * 
     * @param id BasicToolInformation主键
     * @return BasicToolInformation
     */
    @Override
    public AwBasictoolinformation selectAwBasictoolinformationById(String id)
    {
        return awBasictoolinformationMapper.selectAwBasictoolinformationById(id);
    }

    /**
     * 查询BasicToolInformation列表
     * 
     * @param awBasictoolinformation BasicToolInformation
     * @return BasicToolInformation
     */
    @Override
    public List<AwBasictoolinformation> selectAwBasictoolinformationList(AwBasictoolinformation awBasictoolinformation)
    {
        return awBasictoolinformationMapper.selectAwBasictoolinformationList(awBasictoolinformation);
    }

    /**
     * 新增BasicToolInformation
     * 
     * @param awBasictoolinformation BasicToolInformation
     * @return 结果
     */
    @Override
    public int insertAwBasictoolinformation(AwBasictoolinformation awBasictoolinformation)
    {
        return awBasictoolinformationMapper.insertAwBasictoolinformation(awBasictoolinformation);
    }

    /**
     * 修改BasicToolInformation
     * 
     * @param awBasictoolinformation BasicToolInformation
     * @return 结果
     */
    @Override
    public int updateAwBasictoolinformation(AwBasictoolinformation awBasictoolinformation)
    {
        return awBasictoolinformationMapper.updateAwBasictoolinformation(awBasictoolinformation);
    }

    /**
     * 批量删除BasicToolInformation
     * 
     * @param ids 需要删除的BasicToolInformation主键
     * @return 结果
     */
    @Override
    public int deleteAwBasictoolinformationByIds(String[] ids)
    {
        return awBasictoolinformationMapper.deleteAwBasictoolinformationByIds(ids);
    }

    /**
     * 删除BasicToolInformation信息
     * 
     * @param id BasicToolInformation主键
     * @return 结果
     */
    @Override
    public int deleteAwBasictoolinformationById(String id)
    {
        return awBasictoolinformationMapper.deleteAwBasictoolinformationById(id);
    }
}
