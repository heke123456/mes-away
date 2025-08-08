package com.awise.storage.service;

import java.util.List;
import com.awise.storage.domain.AwToolclassification;

/**
 * 刀具分类Service接口
 * 
 * @author awise
 * @date 2023-07-27
 */
public interface IAwToolclassificationService 
{
    /**
     * 查询刀具分类
     * 
     * @param id 刀具分类主键
     * @return 刀具分类
     */
    public AwToolclassification selectAwToolclassificationById(Long id);

    /**
     * 查询刀具分类列表
     * 
     * @param awToolclassification 刀具分类
     * @return 刀具分类集合
     */
    public List<AwToolclassification> selectAwToolclassificationList(AwToolclassification awToolclassification);

    /**
     * 新增刀具分类
     * 
     * @param awToolclassification 刀具分类
     * @return 结果
     */
    public int insertAwToolclassification(AwToolclassification awToolclassification);

    /**
     * 修改刀具分类
     * 
     * @param awToolclassification 刀具分类
     * @return 结果
     */
    public int updateAwToolclassification(AwToolclassification awToolclassification);

    /**
     * 批量删除刀具分类
     * 
     * @param ids 需要删除的刀具分类主键集合
     * @return 结果
     */
    public int deleteAwToolclassificationByIds(Long[] ids);

    /**
     * 删除刀具分类信息
     * 
     * @param id 刀具分类主键
     * @return 结果
     */
    public int deleteAwToolclassificationById(Long id);
}
