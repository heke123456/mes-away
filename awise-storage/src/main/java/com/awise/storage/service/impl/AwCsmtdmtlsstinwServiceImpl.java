package com.awise.storage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.storage.mapper.AwCsmtdmtlsstinwMapper;
import com.awise.storage.domain.AwCsmtdmtlsstinw;
import com.awise.storage.service.IAwCsmtdmtlsstinwService;

/**
 * 客供材料入库Service业务层处理
 * 
 * @author awise
 * @date 2023-12-26
 */
@Service
public class AwCsmtdmtlsstinwServiceImpl implements IAwCsmtdmtlsstinwService 
{
    @Autowired
    private AwCsmtdmtlsstinwMapper awCsmtdmtlsstinwMapper;

    /**
     * 查询客供材料入库
     * 
     * @param id 客供材料入库主键
     * @return 客供材料入库
     */
    @Override
    public AwCsmtdmtlsstinw selectAwCsmtdmtlsstinwById(Long id)
    {
        return awCsmtdmtlsstinwMapper.selectAwCsmtdmtlsstinwById(id);
    }

    /**
     * 查询客供材料入库列表
     * 
     * @param awCsmtdmtlsstinw 客供材料入库
     * @return 客供材料入库
     */
    @Override
    public List<AwCsmtdmtlsstinw> selectAwCsmtdmtlsstinwList(AwCsmtdmtlsstinw awCsmtdmtlsstinw)
    {
        return awCsmtdmtlsstinwMapper.selectAwCsmtdmtlsstinwList(awCsmtdmtlsstinw);
    }

    /**
     * 新增客供材料入库
     * 
     * @param awCsmtdmtlsstinw 客供材料入库
     * @return 结果
     */
    @Override
    public int insertAwCsmtdmtlsstinw(AwCsmtdmtlsstinw awCsmtdmtlsstinw)
    {
        return awCsmtdmtlsstinwMapper.insertAwCsmtdmtlsstinw(awCsmtdmtlsstinw);
    }

    /**
     * 修改客供材料入库
     * 
     * @param awCsmtdmtlsstinw 客供材料入库
     * @return 结果
     */
    @Override
    public int updateAwCsmtdmtlsstinw(AwCsmtdmtlsstinw awCsmtdmtlsstinw)
    {
        return awCsmtdmtlsstinwMapper.updateAwCsmtdmtlsstinw(awCsmtdmtlsstinw);
    }

    /**
     * 批量删除客供材料入库
     * 
     * @param ids 需要删除的客供材料入库主键
     * @return 结果
     */
    @Override
    public int deleteAwCsmtdmtlsstinwByIds(Long[] ids)
    {
        return awCsmtdmtlsstinwMapper.deleteAwCsmtdmtlsstinwByIds(ids);
    }

    /**
     * 删除客供材料入库信息
     * 
     * @param id 客供材料入库主键
     * @return 结果
     */
    @Override
    public int deleteAwCsmtdmtlsstinwById(Long id)
    {
        return awCsmtdmtlsstinwMapper.deleteAwCsmtdmtlsstinwById(id);
    }
}
