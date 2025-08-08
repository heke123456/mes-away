package com.awise.produce.mapper;

import java.util.List;
import com.awise.produce.domain.AwProductiontasks;
import com.awise.produce.domain.Vo.AwProductiontasksVo;

/**
 * 生产任务Mapper接口
 * 
 * @author awise
 * @date 2023-08-15
 */
public interface AwProductiontasksMapper 
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
     * 删除生产任务
     * 
     * @param id 生产任务主键
     * @return 结果
     */
    public int deleteAwProductiontasksById(Long id);

    /**
     * 批量删除生产任务
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwProductiontasksByIds(Long[] ids);

    /**
     * 删除生产任务单任务
     *
     * @param productionTasksFormIDs 生产任务单主键
     * @return 结果
     */
    public int deleteAwProductiontasksByProductionTasksFormIDs(Long[] productionTasksFormIDs);


    List<AwProductiontasksVo> selectAwProductiontasksListVo(AwProductiontasksVo awProductiontasksVo);

}
