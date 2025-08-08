package com.awise.storage.mapper;

import java.util.List;
import com.awise.storage.domain.AwUnits;

/**
 * 计量单位Mapper接口
 * 
 * @author ruoyi
 * @date 2023-07-27
 */
public interface AwUnitsMapper 
{
    /**
     * 查询计量单位
     * 
     * @param id 计量单位主键
     * @return 计量单位
     */
    public AwUnits selectAwUnitsById(Long id);

    /**
     * 查询计量单位列表
     * 
     * @param awUnits 计量单位
     * @return 计量单位集合
     */
    public List<AwUnits> selectAwUnitsList(AwUnits awUnits);

    /**
     * 新增计量单位
     * 
     * @param awUnits 计量单位
     * @return 结果
     */
    public int insertAwUnits(AwUnits awUnits);

    /**
     * 修改计量单位
     * 
     * @param awUnits 计量单位
     * @return 结果
     */
    public int updateAwUnits(AwUnits awUnits);

    /**
     * 删除计量单位
     * 
     * @param id 计量单位主键
     * @return 结果
     */
    public int deleteAwUnitsById(Long id);

    /**
     * 批量删除计量单位
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwUnitsByIds(Long[] ids);
}
