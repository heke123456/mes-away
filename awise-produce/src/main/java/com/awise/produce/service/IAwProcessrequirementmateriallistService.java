package com.awise.produce.service;

import java.util.List;
import com.awise.produce.domain.AwProcessrequirementmateriallist;

/**
 * 工艺需求材料Service接口
 * 
 * @author awise
 * @date 2023-10-15
 */
public interface IAwProcessrequirementmateriallistService 
{
    /**
     * 查询工艺需求材料
     * 
     * @param id 工艺需求材料主键
     * @return 工艺需求材料
     */
    public AwProcessrequirementmateriallist selectAwProcessrequirementmateriallistById(Long id);

    /**
     * 查询工艺需求材料列表
     * 
     * @param awProcessrequirementmateriallist 工艺需求材料
     * @return 工艺需求材料集合
     */
    public List<AwProcessrequirementmateriallist> selectAwProcessrequirementmateriallistList(AwProcessrequirementmateriallist awProcessrequirementmateriallist);

    /**
     * 新增工艺需求材料
     * 
     * @param awProcessrequirementmateriallist 工艺需求材料
     * @return 结果
     */
    public int insertAwProcessrequirementmateriallist(AwProcessrequirementmateriallist awProcessrequirementmateriallist);

    /**
     * 修改工艺需求材料
     * 
     * @param awProcessrequirementmateriallist 工艺需求材料
     * @return 结果
     */
    public int updateAwProcessrequirementmateriallist(AwProcessrequirementmateriallist awProcessrequirementmateriallist);

    /**
     * 批量删除工艺需求材料
     * 
     * @param ids 需要删除的工艺需求材料主键集合
     * @return 结果
     */
    public int deleteAwProcessrequirementmateriallistByIds(Long[] ids);

    /**
     * 删除工艺需求材料信息
     * 
     * @param id 工艺需求材料主键
     * @return 结果
     */
    public int deleteAwProcessrequirementmateriallistById(Long id);
}
