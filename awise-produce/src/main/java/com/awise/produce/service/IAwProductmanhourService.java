package com.awise.produce.service;

import com.awise.produce.domain.AwProductmanhour;

import java.util.List;

/**
 * 生产工时Service接口
 * 
 * @author awise
 * @date 2024-03-19
 */
public interface IAwProductmanhourService 
{
    /**
     * 查询生产工时
     * 
     * @param id 生产工时主键
     * @return 生产工时
     */
    public AwProductmanhour selectAwProductmanhourById(Long id);

    /**
     * 查询生产工时列表
     * 
     * @param awProductmanhour 生产工时
     * @return 生产工时集合
     */
    public List<AwProductmanhour> selectAwProductmanhourList(AwProductmanhour awProductmanhour);

    /**
     * 新增生产工时
     * 
     * @param awProductmanhour 生产工时
     * @return 结果
     */
    public int insertAwProductmanhour(AwProductmanhour awProductmanhour);

    /**
     * 修改生产工时
     * 
     * @param awProductmanhour 生产工时
     * @return 结果
     */
    public int updateAwProductmanhour(AwProductmanhour awProductmanhour);

    /**
     * 批量删除生产工时
     * 
     * @param ids 需要删除的生产工时主键集合
     * @return 结果
     */
    public int deleteAwProductmanhourByIds(Long[] ids);

    /**
     * 删除生产工时信息
     * 
     * @param id 生产工时主键
     * @return 结果
     */
    public int deleteAwProductmanhourById(Long id);








}
