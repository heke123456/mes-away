package com.awise.produce.service;

import java.util.List;
import com.awise.produce.domain.AwProductiontasklist;

/**
 * 生产任务单Service接口
 * 
 * @author awise
 * @date 2023-08-15
 */
public interface IAwProductiontasklistService 
{
    /**
     * 查询生产任务单
     * 
     * @param id 生产任务单主键
     * @return 生产任务单
     */
    public AwProductiontasklist selectAwProductiontasklistById(Long id);

    /**
     * 查询生产任务单列表
     * 
     * @param awProductiontasklist 生产任务单
     * @return 生产任务单集合
     */
    public List<AwProductiontasklist> selectAwProductiontasklistList(AwProductiontasklist awProductiontasklist);

    /**
     * 新增生产任务单
     * 
     * @param awProductiontasklist 生产任务单
     * @return 结果
     */
    public int insertAwProductiontasklist(AwProductiontasklist awProductiontasklist);

    /**
     * 修改生产任务单
     * 
     * @param awProductiontasklist 生产任务单
     * @return 结果
     */
    public int updateAwProductiontasklist(AwProductiontasklist awProductiontasklist);

    /**
     * 批量删除生产任务单
     * 
     * @param ids 需要删除的生产任务单主键集合
     * @return 结果
     */
    public int deleteAwProductiontasklistByIds(Long[] ids);

    /**
     * 删除生产任务单信息
     * 
     * @param id 生产任务单主键
     * @return 结果
     */
    public int deleteAwProductiontasklistById(Long id);



}
