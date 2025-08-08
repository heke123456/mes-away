package com.awise.produce.mapper;

import java.util.List;
import com.awise.produce.domain.AwDetailproductmanhour;

/**
 * 工时统计详细Mapper接口
 * 
 * @author awise
 * @date 2024-04-14
 */
public interface AwDetailproductmanhourMapper 
{
    /**
     * 查询工时统计详细
     * 
     * @param id 工时统计详细主键
     * @return 工时统计详细
     */
    public AwDetailproductmanhour selectAwDetailproductmanhourById(Long id);

    /**
     * 查询工时统计详细列表
     * 
     * @param awDetailproductmanhour 工时统计详细
     * @return 工时统计详细集合
     */
    public List<AwDetailproductmanhour> selectAwDetailproductmanhourList(AwDetailproductmanhour awDetailproductmanhour);

    /**
     * 新增工时统计详细
     * 
     * @param awDetailproductmanhour 工时统计详细
     * @return 结果
     */
    public int insertAwDetailproductmanhour(AwDetailproductmanhour awDetailproductmanhour);

    /**
     * 修改工时统计详细
     * 
     * @param awDetailproductmanhour 工时统计详细
     * @return 结果
     */
    public int updateAwDetailproductmanhour(AwDetailproductmanhour awDetailproductmanhour);

    /**
     * 删除工时统计详细
     * 
     * @param id 工时统计详细主键
     * @return 结果
     */
    public int deleteAwDetailproductmanhourById(Long id);

    /**
     * 批量删除工时统计详细
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwDetailproductmanhourByIds(Long[] ids);
}
