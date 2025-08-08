package com.awise.storage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.storage.mapper.AwSpecificationsMapper;
import com.awise.storage.domain.AwSpecifications;
import com.awise.storage.service.IAwSpecificationsService;

/**
 * 规格类型Service业务层处理
 * 
 * @author awise
 * @date 2023-08-01
 */
@Service
public class AwSpecificationsServiceImpl implements IAwSpecificationsService 
{
    @Autowired
    private AwSpecificationsMapper awSpecificationsMapper;

    /**
     * 查询规格类型
     * 
     * @param id 规格类型主键
     * @return 规格类型
     */
    @Override
    public AwSpecifications selectAwSpecificationsById(Long id)
    {
        return awSpecificationsMapper.selectAwSpecificationsById(id);
    }

    /**
     * 查询规格类型列表
     * 
     * @param awSpecifications 规格类型
     * @return 规格类型
     */
    @Override
    public List<AwSpecifications> selectAwSpecificationsList(AwSpecifications awSpecifications)
    {
        return awSpecificationsMapper.selectAwSpecificationsList(awSpecifications);
    }

    /**
     * 新增规格类型
     * 
     * @param awSpecifications 规格类型
     * @return 结果
     */
    @Override
    public int insertAwSpecifications(AwSpecifications awSpecifications)
    {
        return awSpecificationsMapper.insertAwSpecifications(awSpecifications);
    }

    /**
     * 修改规格类型
     * 
     * @param awSpecifications 规格类型
     * @return 结果
     */
    @Override
    public int updateAwSpecifications(AwSpecifications awSpecifications)
    {
        return awSpecificationsMapper.updateAwSpecifications(awSpecifications);
    }

    /**
     * 批量删除规格类型
     * 
     * @param ids 需要删除的规格类型主键
     * @return 结果
     */
    @Override
    public int deleteAwSpecificationsByIds(Long[] ids)
    {
        return awSpecificationsMapper.deleteAwSpecificationsByIds(ids);
    }

    /**
     * 删除规格类型信息
     * 
     * @param id 规格类型主键
     * @return 结果
     */
    @Override
    public int deleteAwSpecificationsById(Long id)
    {
        return awSpecificationsMapper.deleteAwSpecificationsById(id);
    }
}
