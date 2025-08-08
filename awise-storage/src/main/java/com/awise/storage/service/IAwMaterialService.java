package com.awise.storage.service;

import java.util.List;
import com.awise.storage.domain.AwMaterial;

/**
 * 材料基本信息Service接口
 * 
 * @author awise
 * @date 2023-08-02
 */
public interface IAwMaterialService 
{
    /**
     * 查询材料基本信息
     * 
     * @param id 材料基本信息主键
     * @return 材料基本信息
     */
    public AwMaterial selectAwMaterialById(String id);

    /**
     * 查询材料基本信息列表
     * 
     * @param awMaterial 材料基本信息
     * @return 材料基本信息集合
     */
    public List<AwMaterial> selectAwMaterialList(AwMaterial awMaterial);

    /**
     * 新增材料基本信息
     * 
     * @param awMaterial 材料基本信息
     * @return 结果
     */
    public int insertAwMaterial(AwMaterial awMaterial);

    /**
     * 修改材料基本信息
     * 
     * @param awMaterial 材料基本信息
     * @return 结果
     */
    public int updateAwMaterial(AwMaterial awMaterial);

    /**
     * 批量删除材料基本信息
     * 
     * @param ids 需要删除的材料基本信息主键集合
     * @return 结果
     */
    public int deleteAwMaterialByIds(String[] ids);

    /**
     * 删除材料基本信息信息
     * 
     * @param id 材料基本信息主键
     * @return 结果
     */
    public int deleteAwMaterialById(String id);
}
