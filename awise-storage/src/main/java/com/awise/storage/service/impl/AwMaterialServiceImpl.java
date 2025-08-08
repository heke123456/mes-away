package com.awise.storage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.storage.mapper.AwMaterialMapper;
import com.awise.storage.domain.AwMaterial;
import com.awise.storage.service.IAwMaterialService;

/**
 * 材料基本信息Service业务层处理
 * 
 * @author awise
 * @date 2023-08-02
 */
@Service
public class AwMaterialServiceImpl implements IAwMaterialService 
{
    @Autowired
    private AwMaterialMapper awMaterialMapper;

    /**
     * 查询材料基本信息
     * 
     * @param id 材料基本信息主键
     * @return 材料基本信息
     */
    @Override
    public AwMaterial selectAwMaterialById(String id)
    {
        return awMaterialMapper.selectAwMaterialById(id);
    }

    /**
     * 查询材料基本信息列表
     * 
     * @param awMaterial 材料基本信息
     * @return 材料基本信息
     */
    @Override
    public List<AwMaterial> selectAwMaterialList(AwMaterial awMaterial)
    {
        return awMaterialMapper.selectAwMaterialList(awMaterial);
    }

    /**
     * 新增材料基本信息
     * 
     * @param awMaterial 材料基本信息
     * @return 结果
     */
    @Override
    public int insertAwMaterial(AwMaterial awMaterial)
    {
        return awMaterialMapper.insertAwMaterial(awMaterial);
    }

    /**
     * 修改材料基本信息
     * 
     * @param awMaterial 材料基本信息
     * @return 结果
     */
    @Override
    public int updateAwMaterial(AwMaterial awMaterial)
    {
        return awMaterialMapper.updateAwMaterial(awMaterial);
    }

    /**
     * 批量删除材料基本信息
     * 
     * @param ids 需要删除的材料基本信息主键
     * @return 结果
     */
    @Override
    public int deleteAwMaterialByIds(String[] ids)
    {
        return awMaterialMapper.deleteAwMaterialByIds(ids);
    }

    /**
     * 删除材料基本信息信息
     * 
     * @param id 材料基本信息主键
     * @return 结果
     */
    @Override
    public int deleteAwMaterialById(String id)
    {
        return awMaterialMapper.deleteAwMaterialById(id);
    }
}
