package com.awise.quality.service.impl;

import java.util.List;

import com.awise.quality.domain.Vo.AwProcessinspectionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.quality.mapper.AwProcessinspectionMapper;
import com.awise.quality.domain.AwProcessinspection;
import com.awise.quality.service.IAwProcessinspectionService;

/**
 * 过程检验Service业务层处理
 * 
 * @author awise
 * @date 2023-09-27
 */
@Service
public class AwProcessinspectionServiceImpl implements IAwProcessinspectionService 
{
    @Autowired
    private AwProcessinspectionMapper awProcessinspectionMapper;

    /**
     * 查询过程检验
     * 
     * @param id 过程检验主键
     * @return 过程检验
     */
    @Override
    public AwProcessinspection selectAwProcessinspectionById(Long id)
    {
        return awProcessinspectionMapper.selectAwProcessinspectionById(id);
    }

    /**
     * 查询过程检验列表
     * 
     * @param awProcessinspection 过程检验
     * @return 过程检验
     */
    @Override
    public List<AwProcessinspection> selectAwProcessinspectionList(AwProcessinspection awProcessinspection)
    {
        return awProcessinspectionMapper.selectAwProcessinspectionList(awProcessinspection);
    }

    /**
     * 新增过程检验
     * 
     * @param awProcessinspection 过程检验
     * @return 结果
     */
    @Override
    public int insertAwProcessinspection(AwProcessinspection awProcessinspection)
    {
        return awProcessinspectionMapper.insertAwProcessinspection(awProcessinspection);
    }

    /**
     * 修改过程检验
     * 
     * @param awProcessinspection 过程检验
     * @return 结果
     */
    @Override
    public int updateAwProcessinspection(AwProcessinspection awProcessinspection)
    {
        return awProcessinspectionMapper.updateAwProcessinspection(awProcessinspection);
    }

    /**
     * 批量删除过程检验
     * 
     * @param ids 需要删除的过程检验主键
     * @return 结果
     */
    @Override
    public int deleteAwProcessinspectionByIds(Long[] ids)
    {
        return awProcessinspectionMapper.deleteAwProcessinspectionByIds(ids);
    }

    /**
     * 删除过程检验信息
     * 
     * @param id 过程检验主键
     * @return 结果
     */
    @Override
    public int deleteAwProcessinspectionById(Long id)
    {
        return awProcessinspectionMapper.deleteAwProcessinspectionById(id);
    }

    @Override
    public List<AwProcessinspectionVo> selectAwProcessinspectionVoList(AwProcessinspectionVo awProcessinspectionVo) {
        return awProcessinspectionMapper.selectAwProcessinspectionVoList(awProcessinspectionVo);
    }
}
