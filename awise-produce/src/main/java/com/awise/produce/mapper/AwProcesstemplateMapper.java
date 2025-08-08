package com.awise.produce.mapper;

import java.util.List;
import com.awise.produce.domain.AwProcesstemplate;

/**
 * 工序模板Mapper接口
 * 
 * @author awise
 * @date 2023-09-07
 */
public interface AwProcesstemplateMapper 
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
     * 删除工序模板
     * 
     * @param id 工序模板主键
     * @return 结果
     */
    public int deleteAwProcesstemplateById(Long id);

    /**
     * 批量删除工序模板
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwProcesstemplateByIds(Long[] ids);
}
