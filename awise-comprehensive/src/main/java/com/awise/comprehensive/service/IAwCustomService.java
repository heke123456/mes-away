package com.awise.comprehensive.service;

import java.util.List;
import com.awise.comprehensive.domain.AwCustom;

/**
 * 客户信息Service接口
 * 
 * @author awise
 * @date 2023-08-02
 */
public interface IAwCustomService 
{
    /**
     * 查询客户信息
     * 
     * @param ID 客户信息主键
     * @return 客户信息
     */
    public AwCustom selectAwCustomByID(String ID);

    /**
     * 查询客户信息列表
     * 
     * @param awCustom 客户信息
     * @return 客户信息集合
     */
    public List<AwCustom> selectAwCustomList(AwCustom awCustom);

    /**
     * 新增客户信息
     * 
     * @param awCustom 客户信息
     * @return 结果
     */
    public int insertAwCustom(AwCustom awCustom);

    /**
     * 修改客户信息
     * 
     * @param awCustom 客户信息
     * @return 结果
     */
    public int updateAwCustom(AwCustom awCustom);

    /**
     * 批量删除客户信息
     * 
     * @param IDs 需要删除的客户信息主键集合
     * @return 结果
     */
    public int deleteAwCustomByIDs(String[] IDs);

    /**
     * 删除客户信息信息
     * 
     * @param ID 客户信息主键
     * @return 结果
     */
    public int deleteAwCustomByID(String ID);
}
