package com.awise.produce.mapper;

import java.util.List;
import com.awise.produce.domain.AwProcessingprocess;

/**
 * 加工工序信息Mapper接口
 * 
 * @author awise
 * @date 2023-08-21
 */
public interface AwProcessingprocessMapper 
{
    /**
     * 查询加工工序信息
     * 
     * @param id 加工工序信息主键
     * @return 加工工序信息
     */
    public AwProcessingprocess selectAwProcessingprocessById(Long id);

    /**
     * 查询加工工序信息列表
     * 
     * @param awProcessingprocess 加工工序信息
     * @return 加工工序信息集合
     */
    public List<AwProcessingprocess> selectAwProcessingprocessList(AwProcessingprocess awProcessingprocess);

    /**
     * 新增加工工序信息
     * 
     * @param awProcessingprocess 加工工序信息
     * @return 结果
     */
    public int insertAwProcessingprocess(AwProcessingprocess awProcessingprocess);

    /**
     * 修改加工工序信息
     * 
     * @param awProcessingprocess 加工工序信息
     * @return 结果
     */
    public int updateAwProcessingprocess(AwProcessingprocess awProcessingprocess);

    /**
     * 删除加工工序信息
     * 
     * @param id 加工工序信息主键
     * @return 结果
     */
    public int deleteAwProcessingprocessById(Long id);

    /**
     * 批量删除加工工序信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwProcessingprocessByIds(Long[] ids);
}
