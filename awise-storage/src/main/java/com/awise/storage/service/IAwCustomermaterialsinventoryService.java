package com.awise.storage.service;

import java.util.List;
import java.util.Map;

import com.awise.storage.domain.AwCustomermaterialsinventory;
import org.springframework.transaction.annotation.Transactional;

/**
 * 客供材料实时库存Service接口
 * 
 * @author awise
 * @date 2024-04-22
 */
public interface IAwCustomermaterialsinventoryService 
{
    /**
     * 查询客供材料实时库存
     * 
     * @param id 客供材料实时库存主键
     * @return 客供材料实时库存
     */
    public AwCustomermaterialsinventory selectAwCustomermaterialsinventoryById(Long id);

    /**
     * 查询客供材料实时库存列表
     * 
     * @param awCustomermaterialsinventory 客供材料实时库存
     * @return 客供材料实时库存集合
     */
    public List<AwCustomermaterialsinventory> selectAwCustomermaterialsinventoryList(AwCustomermaterialsinventory awCustomermaterialsinventory);

    /**
     * 新增客供材料实时库存
     * 
     * @param awCustomermaterialsinventory 客供材料实时库存
     * @return 结果
     */
    public int insertAwCustomermaterialsinventory(AwCustomermaterialsinventory awCustomermaterialsinventory);

    /**
     * 修改客供材料实时库存
     * 
     * @param awCustomermaterialsinventory 客供材料实时库存
     * @return 结果
     */
    public int updateAwCustomermaterialsinventory(AwCustomermaterialsinventory awCustomermaterialsinventory);

    /**
     * 批量删除客供材料实时库存
     * 
     * @param ids 需要删除的客供材料实时库存主键集合
     * @return 结果
     */
    public int deleteAwCustomermaterialsinventoryByIds(Long[] ids);

    /**
     * 删除客供材料实时库存信息
     *
     * @param id 客供材料实时库存主键
     * @return 结果
     */
    public int deleteAwCustomermaterialsinventoryById(Long id);


    @Transactional
    boolean addByNumber(List<Map<String, String>> lmlist);


    @Transactional
    boolean reduceByNumber(List<Map<String, String>> lmlist);
}
