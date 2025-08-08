package com.awise.produce.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.produce.mapper.AwDetprodprocMapper;
import com.awise.produce.domain.AwDetprodproc;
import com.awise.produce.service.IAwDetprodprocService;

/**
 * 生产工艺工序详细Service业务层处理
 * 
 * @author awise
 * @date 2023-11-02
 */
@Service
public class AwDetprodprocServiceImpl implements IAwDetprodprocService 
{
    @Autowired
    private AwDetprodprocMapper awDetprodprocMapper;

    /**
     * 查询生产工艺工序详细
     * 
     * @param productionTasksFormID 生产工艺工序详细主键
     * @return 生产工艺工序详细
     */
    @Override
    public AwDetprodproc selectAwDetprodprocByProductionTasksFormID(Long productionTasksFormID)
    {
        return awDetprodprocMapper.selectAwDetprodprocByProductionTasksFormID(productionTasksFormID);
    }

    /**
     * 查询生产工艺工序详细列表
     * 
     * @param awDetprodproc 生产工艺工序详细
     * @return 生产工艺工序详细
     */
    @Override
    public List<AwDetprodproc> selectAwDetprodprocList(AwDetprodproc awDetprodproc)
    {
        return awDetprodprocMapper.selectAwDetprodprocList(awDetprodproc);
    }

    /**
     * 查询生产工艺工序详细列表
     *
     * @param awDetprodproc 生产工艺工序详细
     * @return 生产工艺工序详细
     */
    @Override
    public AwDetprodproc selectAwDetprodproc(AwDetprodproc awDetprodproc)
    {
        return awDetprodprocMapper.selectAwDetprodproc(awDetprodproc);
    }

    /**
     * 新增生产工艺工序详细
     * 
     * @param awDetprodproc 生产工艺工序详细
     * @return 结果
     */
    @Override
    public int insertAwDetprodproc(AwDetprodproc awDetprodproc)
    {
        return awDetprodprocMapper.insertAwDetprodproc(awDetprodproc);
    }

    /**
     * 修改生产工艺工序详细
     * 
     * @param awDetprodproc 生产工艺工序详细
     * @return 结果
     */
    @Override
    public int updateAwDetprodproc(AwDetprodproc awDetprodproc)
    {
        return awDetprodprocMapper.updateAwDetprodproc(awDetprodproc);
    }

    /**
     * 批量删除生产工艺工序详细
     * 
     * @param productionTasksFormIDs 需要删除的生产工艺工序详细主键
     * @return 结果
     */
    @Override
    public int deleteAwDetprodprocByProductionTasksFormIDs(Long[] productionTasksFormIDs)
    {
        return awDetprodprocMapper.deleteAwDetprodprocByProductionTasksFormIDs(productionTasksFormIDs);
    }

    /**
     * 删除生产工艺工序详细信息
     * 
     * @param productionTasksFormID 生产工艺工序详细主键
     * @return 结果
     */
    @Override
    public int deleteAwDetprodprocByProductionTasksFormID(Long productionTasksFormID)
    {
        return awDetprodprocMapper.deleteAwDetprodprocByProductionTasksFormID(productionTasksFormID);
    }
}
