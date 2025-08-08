package com.awise.produce.service.impl;

import com.away.common.utils.DateUtils;
import com.awise.produce.domain.AwOrderhoursdetailed;
import com.awise.produce.mapper.AwOrderhoursdetailedMapper;
import com.awise.produce.service.IAwOrderhoursdetailedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 工时统计Service业务层处理
 * 
 * @author awise
 * @date 2024-03-15
 */
@Service
public class AwOrderhoursdetailedServiceImpl implements IAwOrderhoursdetailedService 
{
    @Autowired
    private AwOrderhoursdetailedMapper awOrderhoursdetailedMapper;

    /**
     * 查询工时统计
     * 
     * @param id 工时统计主键
     * @return 工时统计
     */
    @Override
    public AwOrderhoursdetailed selectAwOrderhoursdetailedById(String id)
    {
        return awOrderhoursdetailedMapper.selectAwOrderhoursdetailedById(id);
    }

    /**
     * 查询工时统计列表
     * 
     * @param awOrderhoursdetailed 工时统计
     * @return 工时统计
     */
    @Override
    public List<AwOrderhoursdetailed> selectAwOrderhoursdetailedList(AwOrderhoursdetailed awOrderhoursdetailed)
    {
        return awOrderhoursdetailedMapper.selectAwOrderhoursdetailedList(awOrderhoursdetailed);
    }

    /**
     * 新增工时统计
     * 
     * @param awOrderhoursdetailed 工时统计
     * @return 结果
     */
    @Override
    public int insertAwOrderhoursdetailed(AwOrderhoursdetailed awOrderhoursdetailed)
    {
        awOrderhoursdetailed.setCreateTime(DateUtils.getNowDate());
        return awOrderhoursdetailedMapper.insertAwOrderhoursdetailed(awOrderhoursdetailed);
    }

    /**
     * 修改工时统计
     * 
     * @param awOrderhoursdetailed 工时统计
     * @return 结果
     */
    @Override
    public int updateAwOrderhoursdetailed(AwOrderhoursdetailed awOrderhoursdetailed)
    {
        return awOrderhoursdetailedMapper.updateAwOrderhoursdetailed(awOrderhoursdetailed);
    }

    /**
     * 批量删除工时统计
     * 
     * @param ids 需要删除的工时统计主键
     * @return 结果
     */
    @Override
    public int deleteAwOrderhoursdetailedByIds(String[] ids)
    {
        return awOrderhoursdetailedMapper.deleteAwOrderhoursdetailedByIds(ids);
    }

    /**
     * 删除工时统计信息
     * 
     * @param id 工时统计主键
     * @return 结果
     */
    @Override
    public int deleteAwOrderhoursdetailedById(String id)
    {
        return awOrderhoursdetailedMapper.deleteAwOrderhoursdetailedById(id);
    }
}
