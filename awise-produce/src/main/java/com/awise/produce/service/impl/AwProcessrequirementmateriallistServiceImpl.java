package com.awise.produce.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.produce.mapper.AwProcessrequirementmateriallistMapper;
import com.awise.produce.domain.AwProcessrequirementmateriallist;
import com.awise.produce.service.IAwProcessrequirementmateriallistService;

/**
 * 工艺需求材料Service业务层处理
 * 
 * @author awise
 * @date 2023-10-15
 */
@Service
public class AwProcessrequirementmateriallistServiceImpl implements IAwProcessrequirementmateriallistService 
{
    @Autowired
    private AwProcessrequirementmateriallistMapper awProcessrequirementmateriallistMapper;

    /**
     * 查询工艺需求材料
     * 
     * @param id 工艺需求材料主键
     * @return 工艺需求材料
     */
    @Override
    public AwProcessrequirementmateriallist selectAwProcessrequirementmateriallistById(Long id)
    {
        return awProcessrequirementmateriallistMapper.selectAwProcessrequirementmateriallistById(id);
    }

    /**
     * 查询工艺需求材料列表
     * 
     * @param awProcessrequirementmateriallist 工艺需求材料
     * @return 工艺需求材料
     */
    @Override
    public List<AwProcessrequirementmateriallist> selectAwProcessrequirementmateriallistList(AwProcessrequirementmateriallist awProcessrequirementmateriallist)
    {
        return awProcessrequirementmateriallistMapper.selectAwProcessrequirementmateriallistList(awProcessrequirementmateriallist);
    }

    /**
     * 新增工艺需求材料
     * 
     * @param awProcessrequirementmateriallist 工艺需求材料
     * @return 结果
     */
    @Override
    public int insertAwProcessrequirementmateriallist(AwProcessrequirementmateriallist awProcessrequirementmateriallist)
    {
        return awProcessrequirementmateriallistMapper.insertAwProcessrequirementmateriallist(awProcessrequirementmateriallist);
    }

    /**
     * 修改工艺需求材料
     * 
     * @param awProcessrequirementmateriallist 工艺需求材料
     * @return 结果
     */
    @Override
    public int updateAwProcessrequirementmateriallist(AwProcessrequirementmateriallist awProcessrequirementmateriallist)
    {
        return awProcessrequirementmateriallistMapper.updateAwProcessrequirementmateriallist(awProcessrequirementmateriallist);
    }

    /**
     * 批量删除工艺需求材料
     * 
     * @param ids 需要删除的工艺需求材料主键
     * @return 结果
     */
    @Override
    public int deleteAwProcessrequirementmateriallistByIds(Long[] ids)
    {
        return awProcessrequirementmateriallistMapper.deleteAwProcessrequirementmateriallistByIds(ids);
    }

    /**
     * 删除工艺需求材料信息
     * 
     * @param id 工艺需求材料主键
     * @return 结果
     */
    @Override
    public int deleteAwProcessrequirementmateriallistById(Long id)
    {
        return awProcessrequirementmateriallistMapper.deleteAwProcessrequirementmateriallistById(id);
    }
}
