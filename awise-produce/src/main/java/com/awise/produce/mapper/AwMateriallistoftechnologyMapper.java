package com.awise.produce.mapper;

import java.util.List;
import com.awise.produce.domain.AwMateriallistoftechnology;

/**
 * 需求材料Mapper接口
 * 
 * @author awise
 * @date 2023-10-15
 */
public interface AwMateriallistoftechnologyMapper 
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
     * 删除需求材料
     * 
     * @param id 需求材料主键
     * @return 结果
     */
    public int deleteAwMateriallistoftechnologyById(Long id);

    /**
     * 批量删除需求材料
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwMateriallistoftechnologyByIds(Long[] ids);
}
