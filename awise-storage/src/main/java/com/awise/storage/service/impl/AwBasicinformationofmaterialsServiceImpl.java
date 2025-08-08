package com.awise.storage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.storage.mapper.AwBasicinformationofmaterialsMapper;
import com.awise.storage.domain.AwBasicinformationofmaterials;
import com.awise.storage.service.IAwBasicinformationofmaterialsService;

/**
 * 材料信息详细单Service业务层处理
 * 
 * @author awise
 * @date 2023-10-15
 */
@Service
public class AwBasicinformationofmaterialsServiceImpl implements IAwBasicinformationofmaterialsService 
{
    @Autowired
    private AwBasicinformationofmaterialsMapper awBasicinformationofmaterialsMapper;

    /**
     * 查询材料信息详细单
     * 
     * @param id 材料信息详细单主键
     * @return 材料信息详细单
     */
    @Override
    public AwBasicinformationofmaterials selectAwBasicinformationofmaterialsById(String id)
    {
        return awBasicinformationofmaterialsMapper.selectAwBasicinformationofmaterialsById(id);
    }

    /**
     * 查询材料信息详细单列表
     * 
     * @param awBasicinformationofmaterials 材料信息详细单
     * @return 材料信息详细单
     */
    @Override
    public List<AwBasicinformationofmaterials> selectAwBasicinformationofmaterialsList(AwBasicinformationofmaterials awBasicinformationofmaterials)
    {
        return awBasicinformationofmaterialsMapper.selectAwBasicinformationofmaterialsList(awBasicinformationofmaterials);
    }

    /**
     * 新增材料信息详细单
     * 
     * @param awBasicinformationofmaterials 材料信息详细单
     * @return 结果
     */
    @Override
    public int insertAwBasicinformationofmaterials(AwBasicinformationofmaterials awBasicinformationofmaterials)
    {
        return awBasicinformationofmaterialsMapper.insertAwBasicinformationofmaterials(awBasicinformationofmaterials);
    }

    /**
     * 修改材料信息详细单
     * 
     * @param awBasicinformationofmaterials 材料信息详细单
     * @return 结果
     */
    @Override
    public int updateAwBasicinformationofmaterials(AwBasicinformationofmaterials awBasicinformationofmaterials)
    {
        return awBasicinformationofmaterialsMapper.updateAwBasicinformationofmaterials(awBasicinformationofmaterials);
    }

    /**
     * 批量删除材料信息详细单
     * 
     * @param ids 需要删除的材料信息详细单主键
     * @return 结果
     */
    @Override
    public int deleteAwBasicinformationofmaterialsByIds(String[] ids)
    {
        return awBasicinformationofmaterialsMapper.deleteAwBasicinformationofmaterialsByIds(ids);
    }

    /**
     * 删除材料信息详细单信息
     * 
     * @param id 材料信息详细单主键
     * @return 结果
     */
    @Override
    public int deleteAwBasicinformationofmaterialsById(String id)
    {
        return awBasicinformationofmaterialsMapper.deleteAwBasicinformationofmaterialsById(id);
    }
}
