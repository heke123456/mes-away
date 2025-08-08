package com.awise.storage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.storage.mapper.AwUnitsMapper;
import com.awise.storage.domain.AwUnits;
import com.awise.storage.service.IAwUnitsService;

/**
 * 计量单位Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-27
 */
@Service
public class AwUnitsServiceImpl implements IAwUnitsService 
{
    @Autowired
    private AwUnitsMapper awUnitsMapper;

    /**
     * 查询计量单位
     * 
     * @param id 计量单位主键
     * @return 计量单位
     */
    @Override
    public AwUnits selectAwUnitsById(Long id)
    {
        return awUnitsMapper.selectAwUnitsById(id);
    }

    /**
     * 查询计量单位列表
     * 
     * @param awUnits 计量单位
     * @return 计量单位
     */
    @Override
    public List<AwUnits> selectAwUnitsList(AwUnits awUnits)
    {
        return awUnitsMapper.selectAwUnitsList(awUnits);
    }

    /**
     * 新增计量单位
     * 
     * @param awUnits 计量单位
     * @return 结果
     */
    @Override
    public int insertAwUnits(AwUnits awUnits)
    {
        return awUnitsMapper.insertAwUnits(awUnits);
    }

    /**
     * 修改计量单位
     * 
     * @param awUnits 计量单位
     * @return 结果
     */
    @Override
    public int updateAwUnits(AwUnits awUnits)
    {
        return awUnitsMapper.updateAwUnits(awUnits);
    }

    /**
     * 批量删除计量单位
     * 
     * @param ids 需要删除的计量单位主键
     * @return 结果
     */
    @Override
    public int deleteAwUnitsByIds(Long[] ids)
    {
        return awUnitsMapper.deleteAwUnitsByIds(ids);
    }

    /**
     * 删除计量单位信息
     * 
     * @param id 计量单位主键
     * @return 结果
     */
    @Override
    public int deleteAwUnitsById(Long id)
    {
        return awUnitsMapper.deleteAwUnitsById(id);
    }
}
