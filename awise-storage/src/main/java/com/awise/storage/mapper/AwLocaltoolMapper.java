package com.awise.storage.mapper;

import java.util.List;
import com.awise.storage.domain.AwLocaltool;

/**
 * 刀具库存Mapper接口
 *
 * @author awise
 * @date 2023-12-18
 */
public interface AwLocaltoolMapper
{
    /**
     * 查询刀具库存
     *
     * @param id 刀具库存主键
     * @return 刀具库存
     */
    public AwLocaltool selectAwLocaltoolById(Long id);

    /**
     * 查询刀具库存列表
     *
     * @param awLocaltool 刀具库存
     * @return 刀具库存集合
     */
    public List<AwLocaltool> selectAwLocaltoolList(AwLocaltool awLocaltool);

    /**
     * 新增刀具库存
     *
     * @param awLocaltool 刀具库存
     * @return 结果
     */
    public int insertAwLocaltool(AwLocaltool awLocaltool);

    /**
     * 修改刀具库存
     *
     * @param awLocaltool 刀具库存
     * @return 结果
     */
    public int updateAwLocaltool(AwLocaltool awLocaltool);

    /**
     * 删除刀具库存
     *
     * @param id 刀具库存主键
     * @return 结果
     */
    public int deleteAwLocaltoolById(Long id);

    /**
     * 批量删除刀具库存
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwLocaltoolByIds(Long[] ids);
}
