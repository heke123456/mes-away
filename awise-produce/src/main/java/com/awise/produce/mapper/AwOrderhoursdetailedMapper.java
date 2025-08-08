package com.awise.produce.mapper;

import com.awise.produce.domain.AwOrderhoursdetailed;

import java.util.List;

/**
 * 工时统计Mapper接口
 * 
 * @author awise
 * @date 2024-03-15
 */
public interface AwOrderhoursdetailedMapper 
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
     * 删除工时统计
     * 
     * @param id 工时统计主键
     * @return 结果
     */
    public int deleteAwOrderhoursdetailedById(String id);

    /**
     * 批量删除工时统计
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwOrderhoursdetailedByIds(String[] ids);
}
