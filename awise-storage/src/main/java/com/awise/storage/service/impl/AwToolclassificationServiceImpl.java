package com.awise.storage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.storage.mapper.AwToolclassificationMapper;
import com.awise.storage.domain.AwToolclassification;
import com.awise.storage.service.IAwToolclassificationService;

/**
 * 刀具分类Service业务层处理
 * 
 * @author awise
 * @date 2023-07-27
 */
@Service
public class AwToolclassificationServiceImpl implements IAwToolclassificationService 
{
    @Autowired
    private AwToolclassificationMapper awToolclassificationMapper;

    /**
     * 查询刀具分类
     * 
     * @param id 刀具分类主键
     * @return 刀具分类
     */
    @Override
    public AwToolclassification selectAwToolclassificationById(Long id)
    {
        return awToolclassificationMapper.selectAwToolclassificationById(id);
    }

    /**
     * 查询刀具分类列表
     * 
     * @param awToolclassification 刀具分类
     * @return 刀具分类
     */
    @Override
    public List<AwToolclassification> selectAwToolclassificationList(AwToolclassification awToolclassification)
    {
        return awToolclassificationMapper.selectAwToolclassificationList(awToolclassification);
    }

    /**
     * 新增刀具分类
     * 
     * @param awToolclassification 刀具分类
     * @return 结果
     */
    @Override
    public int insertAwToolclassification(AwToolclassification awToolclassification)
    {
        return awToolclassificationMapper.insertAwToolclassification(awToolclassification);
    }

    /**
     * 修改刀具分类
     * 
     * @param awToolclassification 刀具分类
     * @return 结果
     */
    @Override
    public int updateAwToolclassification(AwToolclassification awToolclassification)
    {
        return awToolclassificationMapper.updateAwToolclassification(awToolclassification);
    }

    /**
     * 批量删除刀具分类
     * 
     * @param ids 需要删除的刀具分类主键
     * @return 结果
     */
    @Override
    public int deleteAwToolclassificationByIds(Long[] ids)
    {
        return awToolclassificationMapper.deleteAwToolclassificationByIds(ids);
    }

    /**
     * 删除刀具分类信息
     * 
     * @param id 刀具分类主键
     * @return 结果
     */
    @Override
    public int deleteAwToolclassificationById(Long id)
    {
        return awToolclassificationMapper.deleteAwToolclassificationById(id);
    }
}
