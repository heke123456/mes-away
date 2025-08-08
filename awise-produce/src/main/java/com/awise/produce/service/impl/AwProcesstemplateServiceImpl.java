package com.awise.produce.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.produce.mapper.AwProcesstemplateMapper;
import com.awise.produce.domain.AwProcesstemplate;
import com.awise.produce.service.IAwProcesstemplateService;

/**
 * 工序模板Service业务层处理
 * 
 * @author awise
 * @date 2023-09-07
 */
@Service
public class AwProcesstemplateServiceImpl implements IAwProcesstemplateService 
{
    @Autowired
    private AwProcesstemplateMapper awProcesstemplateMapper;

    /**
     * 查询工序模板
     * 
     * @param id 工序模板主键
     * @return 工序模板
     */
    @Override
    public AwProcesstemplate selectAwProcesstemplateById(Long id)
    {
        return awProcesstemplateMapper.selectAwProcesstemplateById(id);
    }

    /**
     * 查询工序模板列表
     * 
     * @param awProcesstemplate 工序模板
     * @return 工序模板
     */
    @Override
    public List<AwProcesstemplate> selectAwProcesstemplateList(AwProcesstemplate awProcesstemplate)
    {
        return awProcesstemplateMapper.selectAwProcesstemplateList(awProcesstemplate);
    }

    /**
     * 新增工序模板
     * 
     * @param awProcesstemplate 工序模板
     * @return 结果
     */
    @Override
    public int insertAwProcesstemplate(AwProcesstemplate awProcesstemplate)
    {
        return awProcesstemplateMapper.insertAwProcesstemplate(awProcesstemplate);
    }

    /**
     * 修改工序模板
     * 
     * @param awProcesstemplate 工序模板
     * @return 结果
     */
    @Override
    public int updateAwProcesstemplate(AwProcesstemplate awProcesstemplate)
    {
        return awProcesstemplateMapper.updateAwProcesstemplate(awProcesstemplate);
    }

    /**
     * 批量删除工序模板
     * 
     * @param ids 需要删除的工序模板主键
     * @return 结果
     */
    @Override
    public int deleteAwProcesstemplateByIds(Long[] ids)
    {
        return awProcesstemplateMapper.deleteAwProcesstemplateByIds(ids);
    }

    /**
     * 删除工序模板信息
     * 
     * @param id 工序模板主键
     * @return 结果
     */
    @Override
    public int deleteAwProcesstemplateById(Long id)
    {
        return awProcesstemplateMapper.deleteAwProcesstemplateById(id);
    }
}
