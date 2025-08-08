package com.awise.produce.service;

import com.awise.produce.domain.AwOrderhoursdetailed;

import java.util.List;

/**
 * 工时统计Service接口
 * 
 * @author awise
 * @date 2024-03-15
 */
public interface IAwOrderhoursdetailedService 
{
    /**
     * 查询工时统计
     * 
     * @param id 工时统计主键
     * @return 工时统计
     */
    public AwOrderhoursdetailed selectAwOrderhoursdetailedById(String id);

    /**
     * 查询工时统计列表
     * 
     * @param awOrderhoursdetailed 工时统计
     * @return 工时统计集合
     */
    public List<AwOrderhoursdetailed> selectAwOrderhoursdetailedList(AwOrderhoursdetailed awOrderhoursdetailed);

    /**
     * 新增工时统计
     * 
     * @param awOrderhoursdetailed 工时统计
     * @return 结果
     */
    public int insertAwOrderhoursdetailed(AwOrderhoursdetailed awOrderhoursdetailed);

    /**
     * 修改工时统计
     * 
     * @param awOrderhoursdetailed 工时统计
     * @return 结果
     */
    public int updateAwOrderhoursdetailed(AwOrderhoursdetailed awOrderhoursdetailed);

    /**
     * 批量删除工时统计
     * 
     * @param ids 需要删除的工时统计主键集合
     * @return 结果
     */
    public int deleteAwOrderhoursdetailedByIds(String[] ids);

    /**
     * 删除工时统计信息
     * 
     * @param id 工时统计主键
     * @return 结果
     */
    public int deleteAwOrderhoursdetailedById(String id);
}
