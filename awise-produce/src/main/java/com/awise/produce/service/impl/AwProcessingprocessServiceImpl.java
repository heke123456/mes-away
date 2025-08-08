package com.awise.produce.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.produce.mapper.AwProcessingprocessMapper;
import com.awise.produce.domain.AwProcessingprocess;
import com.awise.produce.service.IAwProcessingprocessService;

/**
 * 加工工序信息Service业务层处理
 * 
 * @author awise
 * @date 2023-08-21
 */
@Service
public class AwProcessingprocessServiceImpl implements IAwProcessingprocessService 
{
    @Autowired
    private AwProcessingprocessMapper awProcessingprocessMapper;

    /**
     * 查询加工工序信息
     * 
     * @param id 加工工序信息主键
     * @return 加工工序信息
     */
    @Override
    public AwProcessingprocess selectAwProcessingprocessById(Long id)
    {
        return awProcessingprocessMapper.selectAwProcessingprocessById(id);
    }

    /**
     * 查询加工工序信息列表
     * 
     * @param awProcessingprocess 加工工序信息
     * @return 加工工序信息
     */
    @Override
    public List<AwProcessingprocess> selectAwProcessingprocessList(AwProcessingprocess awProcessingprocess)
    {
        return awProcessingprocessMapper.selectAwProcessingprocessList(awProcessingprocess);
    }

    /**
     * 新增加工工序信息
     * 
     * @param awProcessingprocess 加工工序信息
     * @return 结果
     */
    @Override
    public int insertAwProcessingprocess(AwProcessingprocess awProcessingprocess)
    {
        return awProcessingprocessMapper.insertAwProcessingprocess(awProcessingprocess);
    }

    /**
     * 修改加工工序信息
     * 
     * @param awProcessingprocess 加工工序信息
     * @return 结果
     */
    @Override
    public int updateAwProcessingprocess(AwProcessingprocess awProcessingprocess)
    {
        return awProcessingprocessMapper.updateAwProcessingprocess(awProcessingprocess);
    }

    /**
     * 批量删除加工工序信息
     * 
     * @param ids 需要删除的加工工序信息主键
     * @return 结果
     */
    @Override
    public int deleteAwProcessingprocessByIds(Long[] ids)
    {
        return awProcessingprocessMapper.deleteAwProcessingprocessByIds(ids);
    }

    /**
     * 删除加工工序信息信息
     * 
     * @param id 加工工序信息主键
     * @return 结果
     */
    @Override
    public int deleteAwProcessingprocessById(Long id)
    {
        return awProcessingprocessMapper.deleteAwProcessingprocessById(id);
    }
}
