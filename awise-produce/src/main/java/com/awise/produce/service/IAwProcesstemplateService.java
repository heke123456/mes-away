package com.awise.produce.service;

import java.util.List;
import com.awise.produce.domain.AwProcesstemplate;

/**
 * 工序模板Service接口
 * 
 * @author awise
 * @date 2023-09-07
 */
public interface IAwProcesstemplateService 
{
    /**
     * 查询工序模板
     * 
     * @param id 工序模板主键
     * @return 工序模板
     */
    public AwProcesstemplate selectAwProcesstemplateById(Long id);

    /**
     * 查询工序模板列表
     * 
     * @param awProcesstemplate 工序模板
     * @return 工序模板集合
     */
    public List<AwProcesstemplate> selectAwProcesstemplateList(AwProcesstemplate awProcesstemplate);

    /**
     * 新增工序模板
     * 
     * @param awProcesstemplate 工序模板
     * @return 结果
     */
    public int insertAwProcesstemplate(AwProcesstemplate awProcesstemplate);

    /**
     * 修改工序模板
     * 
     * @param awProcesstemplate 工序模板
     * @return 结果
     */
    public int updateAwProcesstemplate(AwProcesstemplate awProcesstemplate);

    /**
     * 批量删除工序模板
     * 
     * @param ids 需要删除的工序模板主键集合
     * @return 结果
     */
    public int deleteAwProcesstemplateByIds(Long[] ids);

    /**
     * 删除工序模板信息
     * 
     * @param id 工序模板主键
     * @return 结果
     */
    public int deleteAwProcesstemplateById(Long id);
}
