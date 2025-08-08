package com.away.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.away.system.mapper.AwCityMapper;
import com.away.system.domain.AwCity;
import com.away.system.service.IAwCityService;

/**
 * 城市存储   省，市，县区Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-26
 */
@Service
public class AwCityServiceImpl implements IAwCityService 
{
    @Autowired
    private AwCityMapper awCityMapper;

    /**
     * 查询城市存储   省，市，县区
     * 
     * @param id 城市存储   省，市，县区主键
     * @return 城市存储   省，市，县区
     */
    @Override
    public AwCity selectAwCityById(Long id)
    {
        return awCityMapper.selectAwCityById(id);
    }

    /**
     * 查询城市存储   省，市，县区列表
     * 
     * @param awCity 城市存储   省，市，县区
     * @return 城市存储   省，市，县区
     */
    @Override
    public List<AwCity> selectAwCityList(AwCity awCity)
    {
        return awCityMapper.selectAwCityList(awCity);
    }

    /**
     * 查询城市存储json
     *
     * @param awCity 城市存储   省，市，县区
     * @return 城市存储json
     */
    @Override
    public String selectAwCityJson(AwCity awCity)
    {
        return awCityMapper.selectAwCityJson(awCity);
    }

    /**
     * 新增城市存储   省，市，县区
     * 
     * @param awCity 城市存储   省，市，县区
     * @return 结果
     */
    @Override
    public int insertAwCity(AwCity awCity)
    {
        return awCityMapper.insertAwCity(awCity);
    }

    /**
     * 修改城市存储   省，市，县区
     * 
     * @param awCity 城市存储   省，市，县区
     * @return 结果
     */
    @Override
    public int updateAwCity(AwCity awCity)
    {
        return awCityMapper.updateAwCity(awCity);
    }

    /**
     * 批量删除城市存储   省，市，县区
     * 
     * @param ids 需要删除的城市存储   省，市，县区主键
     * @return 结果
     */
    @Override
    public int deleteAwCityByIds(Long[] ids)
    {
        return awCityMapper.deleteAwCityByIds(ids);
    }

    /**
     * 删除城市存储   省，市，县区信息
     * 
     * @param id 城市存储   省，市，县区主键
     * @return 结果
     */
    @Override
    public int deleteAwCityById(Long id)
    {
        return awCityMapper.deleteAwCityById(id);
    }
}
