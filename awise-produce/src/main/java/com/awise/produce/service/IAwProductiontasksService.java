package com.awise.produce.service;

import java.util.List;
import com.awise.produce.domain.AwProductiontasks;
import com.awise.produce.domain.Vo.AwProductiontasksVo;

/**
 * 生产任务Service接口
 * 
 * @author awise
 * @date 2023-08-15
 */
public interface IAwProductiontasksService 
{
    /**
     * 查询生产任务
     * 
     * @param id 生产任务主键
     * @return 生产任务
     */
    public AwProductiontasks selectAwProductiontasksById(Long id);

    /**
     * 查询生产任务列表
     * 
     * @param awProductiontasks 生产任务
     * @return 生产任务集合
     */
    public List<AwProductiontasks> selectAwProductiontasksList(AwProductiontasks awProductiontasks);

    /**
     * 新增生产任务
     * 
     * @param awProductiontasks 生产任务
     * @return 结果
     */
    public int insertAwProductiontasks(AwProductiontasks awProductiontasks);

    /**
     * 修改生产任务
     * 
     * @param awProductiontasks 生产任务
     * @return 结果
     */
    public int updateAwProductiontasks(AwProductiontasks awProductiontasks);

    /**
     * 批量删除生产任务
     * 
     * @param ids 需要删除的生产任务主键集合
     * @return 结果
     */
    public int deleteAwProductiontasksByIds(Long[] ids);

    /**
     * 删除生产任务信息
     * 
     * @param id 生产任务主键
     * @return 结果
     */
    public int deleteAwProductiontasksById(Long id);

    /**
     * 删除生产任务信息
     *
     * @param productionTasksFormIDs 生产任务任务单id
     * @return 结果
     */
    public int deleteAwProductiontasksByProductionTasksFormIDs(Long[] productionTasksFormIDs);


    //导出时，查出订单和客户相关信息

    public List<AwProductiontasksVo> selectAwProductiontasksVo(AwProductiontasksVo awProductiontasksVo);
}
