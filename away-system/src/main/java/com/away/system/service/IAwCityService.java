package com.away.system.service;

import java.util.List;
import com.away.system.domain.AwCity;

/**
 * 城市存储   省，市，县区Service接口
 * 
 * @author ruoyi
 * @date 2023-07-26
 */
public interface IAwCityService 
{
    /**
     * 查询城市存储   省，市，县区
     * 
     * @param id 城市存储   省，市，县区主键
     * @return 城市存储   省，市，县区
     */
    public AwCity selectAwCityById(Long id);

    /**
     * 查询城市存储   省，市，县区列表
     * 
     * @param awCity 城市存储   省，市，县区
     * @return 城市存储   省，市，县区集合
     */
    public List<AwCity> selectAwCityList(AwCity awCity);

    /**
     * 查询城市存储json
     *
     * @param awCity 城市存储   省，市，县区
     * @return 城市存储json
     */
    public String selectAwCityJson(AwCity awCity);

    /**
     * 新增城市存储   省，市，县区
     * 
     * @param awCity 城市存储   省，市，县区
     * @return 结果
     */
    public int insertAwCity(AwCity awCity);

    /**
     * 修改城市存储   省，市，县区
     * 
     * @param awCity 城市存储   省，市，县区
     * @return 结果
     */
    public int updateAwCity(AwCity awCity);

    /**
     * 批量删除城市存储   省，市，县区
     * 
     * @param ids 需要删除的城市存储   省，市，县区主键集合
     * @return 结果
     */
    public int deleteAwCityByIds(Long[] ids);

    /**
     * 删除城市存储   省，市，县区信息
     * 
     * @param id 城市存储   省，市，县区主键
     * @return 结果
     */
    public int deleteAwCityById(Long id);
}
