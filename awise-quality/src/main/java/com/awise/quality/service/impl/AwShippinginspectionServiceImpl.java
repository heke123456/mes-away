package com.awise.quality.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.quality.mapper.AwShippinginspectionMapper;
import com.awise.quality.domain.AwShippinginspection;
import com.awise.quality.service.IAwShippinginspectionService;

/**
 * 成品出货检验Service业务层处理
 * 
 * @author awise
 * @date 2023-10-16
 */
@Service
public class AwShippinginspectionServiceImpl implements IAwShippinginspectionService 
{
    @Autowired
    private AwShippinginspectionMapper awShippinginspectionMapper;

    /**
     * 查询成品出货检验
     * 
     * @param id 成品出货检验主键
     * @return 成品出货检验
     */
    @Override
    public AwShippinginspection selectAwShippinginspectionById(String id)
    {
        return awShippinginspectionMapper.selectAwShippinginspectionById(id);
    }

    /**
     * 查询成品出货检验列表
     * 
     * @param awShippinginspection 成品出货检验
     * @return 成品出货检验
     */
    @Override
    public List<AwShippinginspection> selectAwShippinginspectionList(AwShippinginspection awShippinginspection)
    {
        return awShippinginspectionMapper.selectAwShippinginspectionList(awShippinginspection);
    }

    /**
     * 新增成品出货检验
     * 
     * @param awShippinginspection 成品出货检验
     * @return 结果
     */
    @Override
    public int insertAwShippinginspection(AwShippinginspection awShippinginspection)
    {
        return awShippinginspectionMapper.insertAwShippinginspection(awShippinginspection);
    }

    /**
     * 修改成品出货检验
     * 
     * @param awShippinginspection 成品出货检验
     * @return 结果
     */
    @Override
    public int updateAwShippinginspection(AwShippinginspection awShippinginspection)
    {
        return awShippinginspectionMapper.updateAwShippinginspection(awShippinginspection);
    }

    /**
     * 批量删除成品出货检验
     * 
     * @param ids 需要删除的成品出货检验主键
     * @return 结果
     */
    @Override
    public int deleteAwShippinginspectionByIds(String[] ids)
    {
        return awShippinginspectionMapper.deleteAwShippinginspectionByIds(ids);
    }

    /**
     * 删除成品出货检验信息
     * 
     * @param id 成品出货检验主键
     * @return 结果
     */
    @Override
    public int deleteAwShippinginspectionById(String id)
    {
        return awShippinginspectionMapper.deleteAwShippinginspectionById(id);
    }
}
