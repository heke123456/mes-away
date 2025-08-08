package com.awise.storage.service;

import java.util.List;
import com.awise.storage.domain.AwBasicinformationofmaterials;

/**
 * 材料信息详细单Service接口
 * 
 * @author awise
 * @date 2023-10-15
 */
public interface IAwBasicinformationofmaterialsService 
{
    /**
     * 查询材料信息详细单
     * 
     * @param id 材料信息详细单主键
     * @return 材料信息详细单
     */
    public AwBasicinformationofmaterials selectAwBasicinformationofmaterialsById(String id);

    /**
     * 查询材料信息详细单列表
     * 
     * @param awBasicinformationofmaterials 材料信息详细单
     * @return 材料信息详细单集合
     */
    public List<AwBasicinformationofmaterials> selectAwBasicinformationofmaterialsList(AwBasicinformationofmaterials awBasicinformationofmaterials);

    /**
     * 新增材料信息详细单
     * 
     * @param awBasicinformationofmaterials 材料信息详细单
     * @return 结果
     */
    public int insertAwBasicinformationofmaterials(AwBasicinformationofmaterials awBasicinformationofmaterials);

    /**
     * 修改材料信息详细单
     * 
     * @param awBasicinformationofmaterials 材料信息详细单
     * @return 结果
     */
    public int updateAwBasicinformationofmaterials(AwBasicinformationofmaterials awBasicinformationofmaterials);

    /**
     * 批量删除材料信息详细单
     * 
     * @param ids 需要删除的材料信息详细单主键集合
     * @return 结果
     */
    public int deleteAwBasicinformationofmaterialsByIds(String[] ids);

    /**
     * 删除材料信息详细单信息
     * 
     * @param id 材料信息详细单主键
     * @return 结果
     */
    public int deleteAwBasicinformationofmaterialsById(String id);
}
