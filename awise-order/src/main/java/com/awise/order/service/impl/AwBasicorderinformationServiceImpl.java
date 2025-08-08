package com.awise.order.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.order.mapper.AwBasicorderinformationMapper;
import com.awise.order.domain.AwBasicorderinformation;
import com.awise.order.service.IAwBasicorderinformationService;

/**
 * VIEWService业务层处理
 * 
 * @author awise
 * @date 2023-12-22
 */
@Service
public class AwBasicorderinformationServiceImpl implements IAwBasicorderinformationService 
{
    @Autowired
    private AwBasicorderinformationMapper awBasicorderinformationMapper;

    /**
     * 查询VIEW
     * 
     * @param id VIEW主键
     * @return VIEW
     */
    @Override
    public AwBasicorderinformation selectAwBasicorderinformationById(String id)
    {
        return awBasicorderinformationMapper.selectAwBasicorderinformationById(id);
    }

    /**
     * 查询VIEW列表
     * 
     * @param awBasicorderinformation VIEW
     * @return VIEW
     */
    @Override
    public List<AwBasicorderinformation> selectAwBasicorderinformationList(AwBasicorderinformation awBasicorderinformation)
    {
        return awBasicorderinformationMapper.selectAwBasicorderinformationList(awBasicorderinformation);
    }

    /**
     * 新增VIEW
     * 
     * @param awBasicorderinformation VIEW
     * @return 结果
     */
    @Override
    public int insertAwBasicorderinformation(AwBasicorderinformation awBasicorderinformation)
    {
        return awBasicorderinformationMapper.insertAwBasicorderinformation(awBasicorderinformation);
    }

    /**
     * 修改VIEW
     * 
     * @param awBasicorderinformation VIEW
     * @return 结果
     */
    @Override
    public int updateAwBasicorderinformation(AwBasicorderinformation awBasicorderinformation)
    {
        return awBasicorderinformationMapper.updateAwBasicorderinformation(awBasicorderinformation);
    }

    /**
     * 批量删除VIEW
     * 
     * @param ids 需要删除的VIEW主键
     * @return 结果
     */
    @Override
    public int deleteAwBasicorderinformationByIds(String[] ids)
    {
        return awBasicorderinformationMapper.deleteAwBasicorderinformationByIds(ids);
    }

    /**
     * 删除VIEW信息
     * 
     * @param id VIEW主键
     * @return 结果
     */
    @Override
    public int deleteAwBasicorderinformationById(String id)
    {
        return awBasicorderinformationMapper.deleteAwBasicorderinformationById(id);
    }
}
