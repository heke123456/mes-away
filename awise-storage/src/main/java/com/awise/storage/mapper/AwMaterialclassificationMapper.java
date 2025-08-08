package com.awise.storage.mapper;

import java.util.List;
import com.awise.storage.domain.AwMaterialclassification;

/**
 * 材料分类Mapper接口
 * 
 * @author awise
 * @date 2023-08-02
 */
public interface AwMaterialclassificationMapper 
{
    /**
     * 查询材料分类
     * 
     * @param id 材料分类主键
     * @return 材料分类
     */
    public AwMaterialclassification selectAwMaterialclassificationById(Long id);

    /**
     * 查询材料分类列表
     * 
     * @param awMaterialclassification 材料分类
     * @return 材料分类集合
     */
    public List<AwMaterialclassification> selectAwMaterialclassificationList(AwMaterialclassification awMaterialclassification);

    /**
     * 新增材料分类
     * 
     * @param awMaterialclassification 材料分类
     * @return 结果
     */
    public int insertAwMaterialclassification(AwMaterialclassification awMaterialclassification);

    /**
     * 修改材料分类
     * 
     * @param awMaterialclassification 材料分类
     * @return 结果
     */
    public int updateAwMaterialclassification(AwMaterialclassification awMaterialclassification);

    /**
     * 删除材料分类
     * 
     * @param id 材料分类主键
     * @return 结果
     */
    public int deleteAwMaterialclassificationById(Long id);

    /**
     * 批量删除材料分类
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwMaterialclassificationByIds(Long[] ids);
}
