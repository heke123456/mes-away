package com.awise.produce.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.produce.mapper.AwMateriallistoftechnologyMapper;
import com.awise.produce.domain.AwMateriallistoftechnology;
import com.awise.produce.service.IAwMateriallistoftechnologyService;

/**
 * 需求材料Service业务层处理
 * 
 * @author awise
 * @date 2023-10-15
 */
@Service
public class AwMateriallistoftechnologyServiceImpl implements IAwMateriallistoftechnologyService 
{
    @Autowired
    private AwMateriallistoftechnologyMapper awMateriallistoftechnologyMapper;

    /**
     * 查询需求材料
     * 
     * @param id 需求材料主键
     * @return 需求材料
     */
    @Override
    public AwMateriallistoftechnology selectAwMateriallistoftechnologyById(Long id)
    {
        return awMateriallistoftechnologyMapper.selectAwMateriallistoftechnologyById(id);
    }

    /**
     * 查询需求材料列表
     * 
     * @param awMateriallistoftechnology 需求材料
     * @return 需求材料
     */
    @Override
    public List<AwMateriallistoftechnology> selectAwMateriallistoftechnologyList(AwMateriallistoftechnology awMateriallistoftechnology)
    {
        return awMateriallistoftechnologyMapper.selectAwMateriallistoftechnologyList(awMateriallistoftechnology);
    }

    /**
     * 新增需求材料
     * 
     * @param awMateriallistoftechnology 需求材料
     * @return 结果
     */
    @Override
    public int insertAwMateriallistoftechnology(AwMateriallistoftechnology awMateriallistoftechnology)
    {
        return awMateriallistoftechnologyMapper.insertAwMateriallistoftechnology(awMateriallistoftechnology);
    }

    /**
     * 修改需求材料
     * 
     * @param awMateriallistoftechnology 需求材料
     * @return 结果
     */
    @Override
    public int updateAwMateriallistoftechnology(AwMateriallistoftechnology awMateriallistoftechnology)
    {
        return awMateriallistoftechnologyMapper.updateAwMateriallistoftechnology(awMateriallistoftechnology);
    }

    /**
     * 批量删除需求材料
     * 
     * @param ids 需要删除的需求材料主键
     * @return 结果
     */
    @Override
    public int deleteAwMateriallistoftechnologyByIds(Long[] ids)
    {
        return awMateriallistoftechnologyMapper.deleteAwMateriallistoftechnologyByIds(ids);
    }

    /**
     * 删除需求材料信息
     * 
     * @param id 需求材料主键
     * @return 结果
     */
    @Override
    public int deleteAwMateriallistoftechnologyById(Long id)
    {
        return awMateriallistoftechnologyMapper.deleteAwMateriallistoftechnologyById(id);
    }
}
