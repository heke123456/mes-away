package com.awise.produce.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.produce.mapper.AwDetailproductmanhourMapper;
import com.awise.produce.domain.AwDetailproductmanhour;
import com.awise.produce.service.IAwDetailproductmanhourService;

/**
 * 工时统计详细Service业务层处理
 * 
 * @author awise
 * @date 2024-04-14
 */
@Service
public class AwDetailproductmanhourServiceImpl implements IAwDetailproductmanhourService 
{
    @Autowired
    private AwDetailproductmanhourMapper awDetailproductmanhourMapper;

    /**
     * 查询工时统计详细
     * 
     * @param id 工时统计详细主键
     * @return 工时统计详细
     */
    @Override
    public AwDetailproductmanhour selectAwDetailproductmanhourById(Long id)
    {
        return awDetailproductmanhourMapper.selectAwDetailproductmanhourById(id);
    }

    /**
     * 查询工时统计详细列表
     * 
     * @param awDetailproductmanhour 工时统计详细
     * @return 工时统计详细
     */
    @Override
    public List<AwDetailproductmanhour> selectAwDetailproductmanhourList(AwDetailproductmanhour awDetailproductmanhour)
    {
        return awDetailproductmanhourMapper.selectAwDetailproductmanhourList(awDetailproductmanhour);
    }

    /**
     * 新增工时统计详细
     * 
     * @param awDetailproductmanhour 工时统计详细
     * @return 结果
     */
    @Override
    public int insertAwDetailproductmanhour(AwDetailproductmanhour awDetailproductmanhour)
    {
        return awDetailproductmanhourMapper.insertAwDetailproductmanhour(awDetailproductmanhour);
    }

    /**
     * 修改工时统计详细
     * 
     * @param awDetailproductmanhour 工时统计详细
     * @return 结果
     */
    @Override
    public int updateAwDetailproductmanhour(AwDetailproductmanhour awDetailproductmanhour)
    {
        return awDetailproductmanhourMapper.updateAwDetailproductmanhour(awDetailproductmanhour);
    }

    /**
     * 批量删除工时统计详细
     * 
     * @param ids 需要删除的工时统计详细主键
     * @return 结果
     */
    @Override
    public int deleteAwDetailproductmanhourByIds(Long[] ids)
    {
        return awDetailproductmanhourMapper.deleteAwDetailproductmanhourByIds(ids);
    }

    /**
     * 删除工时统计详细信息
     * 
     * @param id 工时统计详细主键
     * @return 结果
     */
    @Override
    public int deleteAwDetailproductmanhourById(Long id)
    {
        return awDetailproductmanhourMapper.deleteAwDetailproductmanhourById(id);
    }
}
