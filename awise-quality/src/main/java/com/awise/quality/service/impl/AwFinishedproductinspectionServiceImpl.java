package com.awise.quality.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.quality.mapper.AwFinishedproductinspectionMapper;
import com.awise.quality.domain.AwFinishedproductinspection;
import com.awise.quality.service.IAwFinishedproductinspectionService;

/**
 * 成品检验Service业务层处理
 * 
 * @author awise
 * @date 2023-10-16
 */
@Service
public class AwFinishedproductinspectionServiceImpl implements IAwFinishedproductinspectionService 
{
    @Autowired
    private AwFinishedproductinspectionMapper awFinishedproductinspectionMapper;

    /**
     * 查询成品检验
     * 
     * @param id 成品检验主键
     * @return 成品检验
     */
    @Override
    public AwFinishedproductinspection selectAwFinishedproductinspectionById(String id)
    {
        return awFinishedproductinspectionMapper.selectAwFinishedproductinspectionById(id);
    }

    /**
     * 查询成品检验列表
     * 
     * @param awFinishedproductinspection 成品检验
     * @return 成品检验
     */
    @Override
    public List<AwFinishedproductinspection> selectAwFinishedproductinspectionList(AwFinishedproductinspection awFinishedproductinspection)
    {
        return awFinishedproductinspectionMapper.selectAwFinishedproductinspectionList(awFinishedproductinspection);
    }

    /**
     * 新增成品检验
     * 
     * @param awFinishedproductinspection 成品检验
     * @return 结果
     */
    @Override
    public int insertAwFinishedproductinspection(AwFinishedproductinspection awFinishedproductinspection)
    {
        return awFinishedproductinspectionMapper.insertAwFinishedproductinspection(awFinishedproductinspection);
    }

    /**
     * 修改成品检验
     * 
     * @param awFinishedproductinspection 成品检验
     * @return 结果
     */
    @Override
    public int updateAwFinishedproductinspection(AwFinishedproductinspection awFinishedproductinspection)
    {
        return awFinishedproductinspectionMapper.updateAwFinishedproductinspection(awFinishedproductinspection);
    }

    /**
     * 批量删除成品检验
     * 
     * @param ids 需要删除的成品检验主键
     * @return 结果
     */
    @Override
    public int deleteAwFinishedproductinspectionByIds(String[] ids)
    {
        return awFinishedproductinspectionMapper.deleteAwFinishedproductinspectionByIds(ids);
    }

    /**
     * 删除成品检验信息
     * 
     * @param id 成品检验主键
     * @return 结果
     */
    @Override
    public int deleteAwFinishedproductinspectionById(String id)
    {
        return awFinishedproductinspectionMapper.deleteAwFinishedproductinspectionById(id);
    }
}
