package com.awise.storage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.storage.mapper.AwMaterialclassificationMapper;
import com.awise.storage.domain.AwMaterialclassification;
import com.awise.storage.service.IAwMaterialclassificationService;

/**
 * 材料分类Service业务层处理
 * 
 * @author awise
 * @date 2023-08-02
 */
@Service
public class AwMaterialclassificationServiceImpl implements IAwMaterialclassificationService 
{
    @Autowired
    private AwMaterialclassificationMapper awMaterialclassificationMapper;

    /**
     * 查询材料分类
     * 
     * @param id 材料分类主键
     * @return 材料分类
     */
    @Override
    public AwMaterialclassification selectAwMaterialclassificationById(Long id)
    {
        return awMaterialclassificationMapper.selectAwMaterialclassificationById(id);
    }

    /**
     * 查询材料分类列表
     * 
     * @param awMaterialclassification 材料分类
     * @return 材料分类
     */
    @Override
    public List<AwMaterialclassification> selectAwMaterialclassificationList(AwMaterialclassification awMaterialclassification)
    {
        return awMaterialclassificationMapper.selectAwMaterialclassificationList(awMaterialclassification);
    }

    /**
     * 新增材料分类
     * 
     * @param awMaterialclassification 材料分类
     * @return 结果
     */
    @Override
    public int insertAwMaterialclassification(AwMaterialclassification awMaterialclassification)
    {
        return awMaterialclassificationMapper.insertAwMaterialclassification(awMaterialclassification);
    }

    /**
     * 修改材料分类
     * 
     * @param awMaterialclassification 材料分类
     * @return 结果
     */
    @Override
    public int updateAwMaterialclassification(AwMaterialclassification awMaterialclassification)
    {
        return awMaterialclassificationMapper.updateAwMaterialclassification(awMaterialclassification);
    }

    /**
     * 批量删除材料分类
     * 
     * @param ids 需要删除的材料分类主键
     * @return 结果
     */
    @Override
    public int deleteAwMaterialclassificationByIds(Long[] ids)
    {
        return awMaterialclassificationMapper.deleteAwMaterialclassificationByIds(ids);
    }

    /**
     * 删除材料分类信息
     * 
     * @param id 材料分类主键
     * @return 结果
     */
    @Override
    public int deleteAwMaterialclassificationById(Long id)
    {
        return awMaterialclassificationMapper.deleteAwMaterialclassificationById(id);
    }
}
