package com.awise.produce.service.impl;

import com.awise.produce.domain.AwProductmanhour;
import com.awise.produce.mapper.AwProductmanhourMapper;
import com.awise.produce.service.IAwProductmanhourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 生产工时Service业务层处理
 * 
 * @author awise
 * @date 2024-03-19
 */
@Service
public class AwProductmanhourServiceImpl implements IAwProductmanhourService 
{
    @Autowired
    private AwProductmanhourMapper awProductmanhourMapper;

    /**
     * 查询生产工时
     * 
     * @param id 生产工时主键
     * @return 生产工时
     */
    @Override
    public AwProductmanhour selectAwProductmanhourById(Long id)
    {
        return awProductmanhourMapper.selectAwProductmanhourById(id);
    }

    /**
     * 查询生产工时列表
     * 
     * @param awProductmanhour 生产工时
     * @return 生产工时
     */
    @Override
    public List<AwProductmanhour> selectAwProductmanhourList(AwProductmanhour awProductmanhour)
    {
        return awProductmanhourMapper.selectAwProductmanhourList(awProductmanhour);
    }

    /**
     * 新增生产工时
     * 
     * @param awProductmanhour 生产工时
     * @return 结果
     */
    @Override
    public int insertAwProductmanhour(AwProductmanhour awProductmanhour)
    {
        return awProductmanhourMapper.insertAwProductmanhour(awProductmanhour);
    }

    /**
     * 修改生产工时
     * 
     * @param awProductmanhour 生产工时
     * @return 结果
     */
    @Override
    public int updateAwProductmanhour(AwProductmanhour awProductmanhour)
    {
        return awProductmanhourMapper.updateAwProductmanhour(awProductmanhour);
    }

    /**
     * 批量删除生产工时
     * 
     * @param ids 需要删除的生产工时主键
     * @return 结果
     */
    @Override
    public int deleteAwProductmanhourByIds(Long[] ids)
    {
        return awProductmanhourMapper.deleteAwProductmanhourByIds(ids);
    }

    /**
     * 删除生产工时信息
     * 
     * @param id 生产工时主键
     * @return 结果
     */
    @Override
    public int deleteAwProductmanhourById(Long id)
    {
        return awProductmanhourMapper.deleteAwProductmanhourById(id);
    }




}
