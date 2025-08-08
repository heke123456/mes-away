package com.awise.produce.service;

import java.util.List;
import com.awise.produce.domain.AwMateriallistoftechnology;

/**
 * 需求材料Service接口
 * 
 * @author awise
 * @date 2023-10-15
 */
public interface IAwMateriallistoftechnologyService 
{
    /**
     * 查询需求材料
     * 
     * @param id 需求材料主键
     * @return 需求材料
     */
    public AwMateriallistoftechnology selectAwMateriallistoftechnologyById(Long id);

    /**
     * 查询需求材料列表
     * 
     * @param awMateriallistoftechnology 需求材料
     * @return 需求材料集合
     */
    public List<AwMateriallistoftechnology> selectAwMateriallistoftechnologyList(AwMateriallistoftechnology awMateriallistoftechnology);

    /**
     * 新增需求材料
     * 
     * @param awMateriallistoftechnology 需求材料
     * @return 结果
     */
    public int insertAwMateriallistoftechnology(AwMateriallistoftechnology awMateriallistoftechnology);

    /**
     * 修改需求材料
     * 
     * @param awMateriallistoftechnology 需求材料
     * @return 结果
     */
    public int updateAwMateriallistoftechnology(AwMateriallistoftechnology awMateriallistoftechnology);

    /**
     * 批量删除需求材料
     * 
     * @param ids 需要删除的需求材料主键集合
     * @return 结果
     */
    public int deleteAwMateriallistoftechnologyByIds(Long[] ids);

    /**
     * 删除需求材料信息
     * 
     * @param id 需求材料主键
     * @return 结果
     */
    public int deleteAwMateriallistoftechnologyById(Long id);
}
