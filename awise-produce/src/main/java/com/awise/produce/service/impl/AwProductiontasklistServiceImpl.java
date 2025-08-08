package com.awise.produce.service.impl;

import java.util.List;
import com.away.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.produce.mapper.AwProductiontasklistMapper;
import com.awise.produce.domain.AwProductiontasklist;
import com.awise.produce.service.IAwProductiontasklistService;

/**
 * 生产任务单Service业务层处理
 * 
 * @author awise
 * @date 2023-08-15
 */
@Service
public class AwProductiontasklistServiceImpl implements IAwProductiontasklistService 
{
    @Autowired
    private AwProductiontasklistMapper awProductiontasklistMapper;

    /**
     * 查询生产任务单
     * 
     * @param id 生产任务单主键
     * @return 生产任务单
     */
    @Override
    public AwProductiontasklist selectAwProductiontasklistById(Long id)
    {
        return awProductiontasklistMapper.selectAwProductiontasklistById(id);
    }

    /**
     * 查询生产任务单列表
     * 
     * @param awProductiontasklist 生产任务单
     * @return 生产任务单
     */
    @Override
    public List<AwProductiontasklist> selectAwProductiontasklistList(AwProductiontasklist awProductiontasklist)
    {
        return awProductiontasklistMapper.selectAwProductiontasklistList(awProductiontasklist);
    }

    /**
     * 新增生产任务单
     * 
     * @param awProductiontasklist 生产任务单
     * @return 结果
     */
    @Override
    public int insertAwProductiontasklist(AwProductiontasklist awProductiontasklist)
    {
        awProductiontasklist.setCreateTime(DateUtils.getNowDate());
        return awProductiontasklistMapper.insertAwProductiontasklist(awProductiontasklist);
    }

    /**
     * 修改生产任务单
     * 
     * @param awProductiontasklist 生产任务单
     * @return 结果
     */
    @Override
    public int updateAwProductiontasklist(AwProductiontasklist awProductiontasklist)
    {
        return awProductiontasklistMapper.updateAwProductiontasklist(awProductiontasklist);
    }

    /**
     * 批量删除生产任务单
     * 
     * @param ids 需要删除的生产任务单主键
     * @return 结果
     */
    @Override
    public int deleteAwProductiontasklistByIds(Long[] ids)
    {
        return awProductiontasklistMapper.deleteAwProductiontasklistByIds(ids);
    }

    /**
     * 删除生产任务单信息
     * 
     * @param id 生产任务单主键
     * @return 结果
     */
    @Override
    public int deleteAwProductiontasklistById(Long id)
    {
        return awProductiontasklistMapper.deleteAwProductiontasklistById(id);
    }
}
