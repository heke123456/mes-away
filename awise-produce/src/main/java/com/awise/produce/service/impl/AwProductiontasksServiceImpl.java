package com.awise.produce.service.impl;

import java.util.List;

import com.awise.produce.domain.Vo.AwProductiontasksVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.produce.mapper.AwProductiontasksMapper;
import com.awise.produce.domain.AwProductiontasks;
import com.awise.produce.service.IAwProductiontasksService;

/**
 * 生产任务Service业务层处理
 * 
 * @author awise
 * @date 2023-08-15
 */
@Service
public class AwProductiontasksServiceImpl implements IAwProductiontasksService 
{
    @Autowired
    private AwProductiontasksMapper awProductiontasksMapper;

    /**
     * 查询生产任务
     * 
     * @param id 生产任务主键
     * @return 生产任务
     */
    @Override
    public AwProductiontasks selectAwProductiontasksById(Long id)
    {
        AwProductiontasks awProductiontasks = awProductiontasksMapper.selectAwProductiontasksById(id);
        return awProductiontasks;
    }

    /**
     * 查询生产任务列表
     * 
     * @param awProductiontasks 生产任务
     * @return 生产任务
     */
    @Override
    public List<AwProductiontasks> selectAwProductiontasksList(AwProductiontasks awProductiontasks)
    {
        return awProductiontasksMapper.selectAwProductiontasksList(awProductiontasks);
    }

    /**
     * 新增生产任务
     * 
     * @param awProductiontasks 生产任务
     * @return 结果
     */
    @Override
    public int insertAwProductiontasks(AwProductiontasks awProductiontasks)
    {
        return awProductiontasksMapper.insertAwProductiontasks(awProductiontasks);
    }

    /**
     * 修改生产任务
     * 
     * @param awProductiontasks 生产任务
     * @return 结果
     */
    @Override
    public int updateAwProductiontasks(AwProductiontasks awProductiontasks)
    {
        return awProductiontasksMapper.updateAwProductiontasks(awProductiontasks);
    }

    /**
     * 批量删除生产任务
     * 
     * @param ids 需要删除的生产任务主键
     * @return 结果
     */
    @Override
    public int deleteAwProductiontasksByIds(Long[] ids)
    {
        return awProductiontasksMapper.deleteAwProductiontasksByIds(ids);
    }

    /**
     * 删除生产任务信息
     * 
     * @param id 生产任务主键
     * @return 结果
     */
    @Override
    public int deleteAwProductiontasksById(Long id)
    {
        return awProductiontasksMapper.deleteAwProductiontasksById(id);
    }

    /**
     * 删除生产任务信息
     *
     * @param ProductionTasksFormIDs 生产任务任务单id
     * @return 结果
     */
    public int deleteAwProductiontasksByProductionTasksFormIDs(Long[] ProductionTasksFormIDs)
    {
        return awProductiontasksMapper.deleteAwProductiontasksByProductionTasksFormIDs(ProductionTasksFormIDs);
    }


    //导出时，查出订单和客户相关信息
    @Override
    public List<AwProductiontasksVo> selectAwProductiontasksVo(AwProductiontasksVo awProductiontasksVo) {
        return awProductiontasksMapper.selectAwProductiontasksListVo(awProductiontasksVo);
    }




}
