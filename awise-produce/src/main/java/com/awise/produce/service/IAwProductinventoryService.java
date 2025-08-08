package com.awise.produce.service;

import java.util.List;
import java.util.Map;

import com.awise.produce.domain.AwProductinventory;
import org.springframework.transaction.annotation.Transactional;

/**
 * 产品库存Service接口
 * 
 * @author awise
 * @date 2024-04-28
 */
public interface IAwProductinventoryService 
{
    /**
     * 查询产品库存
     * 
     * @param id 产品库存主键
     * @return 产品库存
     */
    public AwProductinventory selectAwProductinventoryById(Long id);

    /**
     * 查询产品库存列表
     * 
     * @param awProductinventory 产品库存
     * @return 产品库存集合
     */
    public List<AwProductinventory> selectAwProductinventoryList(AwProductinventory awProductinventory);

    /**
     * 新增产品库存
     * 
     * @param awProductinventory 产品库存
     * @return 结果
     */
    public int insertAwProductinventory(AwProductinventory awProductinventory);

    /**
     * 修改产品库存
     * 
     * @param awProductinventory 产品库存
     * @return 结果
     */
    public int updateAwProductinventory(AwProductinventory awProductinventory);

    /**
     * 批量删除产品库存
     * 
     * @param ids 需要删除的产品库存主键集合
     * @return 结果
     */
    public int deleteAwProductinventoryByIds(Long[] ids);

    /**
     * 删除产品库存信息
     * 
     * @param id 产品库存主键
     * @return 结果
     */
    public int deleteAwProductinventoryById(Long id);

    @Transactional

    boolean addByNumber(List<Map<String, String>> lmlist);


    @Transactional

    boolean reduceByNumber(List<Map<String, String>> lmlist);

}
