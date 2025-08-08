package com.awise.produce.service;

import java.util.List;
import com.awise.produce.domain.AwDetprodproc;

/**
 * 生产工艺工序详细Service接口
 * 
 * @author awise
 * @date 2023-11-02
 */
public interface IAwDetprodprocService 
{
    /**
     * 查询生产工艺工序详细
     * 
     * @param productionTasksFormID 生产工艺工序详细主键
     * @return 生产工艺工序详细
     */
    public AwDetprodproc selectAwDetprodprocByProductionTasksFormID(Long productionTasksFormID);

    /**
     * 查询生产工艺工序详细列表
     * 
     * @param awDetprodproc 生产工艺工序详细
     * @return 生产工艺工序详细集合
     */
    public List<AwDetprodproc> selectAwDetprodprocList(AwDetprodproc awDetprodproc);

    /**
     * 查询生产工艺工序详细列表
     *
     * @param awDetprodproc 生产工艺工序详细
     * @return 生产工艺工序详细
     */
    public AwDetprodproc selectAwDetprodproc(AwDetprodproc awDetprodproc);


    /**
     * 新增生产工艺工序详细
     * 
     * @param awDetprodproc 生产工艺工序详细
     * @return 结果
     */
    public int insertAwDetprodproc(AwDetprodproc awDetprodproc);

    /**
     * 修改生产工艺工序详细
     * 
     * @param awDetprodproc 生产工艺工序详细
     * @return 结果
     */
    public int updateAwDetprodproc(AwDetprodproc awDetprodproc);

    /**
     * 批量删除生产工艺工序详细
     * 
     * @param productionTasksFormIDs 需要删除的生产工艺工序详细主键集合
     * @return 结果
     */
    public int deleteAwDetprodprocByProductionTasksFormIDs(Long[] productionTasksFormIDs);

    /**
     * 删除生产工艺工序详细信息
     * 
     * @param productionTasksFormID 生产工艺工序详细主键
     * @return 结果
     */
    public int deleteAwDetprodprocByProductionTasksFormID(Long productionTasksFormID);
}
