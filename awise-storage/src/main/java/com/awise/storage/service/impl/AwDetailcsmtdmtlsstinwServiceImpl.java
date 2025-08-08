package com.awise.storage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.storage.mapper.AwDetailcsmtdmtlsstinwMapper;
import com.awise.storage.domain.AwDetailcsmtdmtlsstinw;
import com.awise.storage.service.IAwDetailcsmtdmtlsstinwService;

/**
 * 客供入库详细Service业务层处理
 * 
 * @author awise
 * @date 2023-12-26
 */
@Service
public class AwDetailcsmtdmtlsstinwServiceImpl implements IAwDetailcsmtdmtlsstinwService 
{
    @Autowired
    private AwDetailcsmtdmtlsstinwMapper awDetailcsmtdmtlsstinwMapper;

    /**
     * 查询客供入库详细
     * 
     * @param id 客供入库详细主键
     * @return 客供入库详细
     */
    @Override
    public AwDetailcsmtdmtlsstinw selectAwDetailcsmtdmtlsstinwById(Long id)
    {
        return awDetailcsmtdmtlsstinwMapper.selectAwDetailcsmtdmtlsstinwById(id);
    }

    /**
     * 查询客供入库详细列表
     * 
     * @param awDetailcsmtdmtlsstinw 客供入库详细
     * @return 客供入库详细
     */
    @Override
    public List<AwDetailcsmtdmtlsstinw> selectAwDetailcsmtdmtlsstinwList(AwDetailcsmtdmtlsstinw awDetailcsmtdmtlsstinw)
    {
        return awDetailcsmtdmtlsstinwMapper.selectAwDetailcsmtdmtlsstinwList(awDetailcsmtdmtlsstinw);
    }

    /**
     * 新增客供入库详细
     * 
     * @param awDetailcsmtdmtlsstinw 客供入库详细
     * @return 结果
     */
    @Override
    public int insertAwDetailcsmtdmtlsstinw(AwDetailcsmtdmtlsstinw awDetailcsmtdmtlsstinw)
    {
        return awDetailcsmtdmtlsstinwMapper.insertAwDetailcsmtdmtlsstinw(awDetailcsmtdmtlsstinw);
    }

    /**
     * 修改客供入库详细
     * 
     * @param awDetailcsmtdmtlsstinw 客供入库详细
     * @return 结果
     */
    @Override
    public int updateAwDetailcsmtdmtlsstinw(AwDetailcsmtdmtlsstinw awDetailcsmtdmtlsstinw)
    {
        return awDetailcsmtdmtlsstinwMapper.updateAwDetailcsmtdmtlsstinw(awDetailcsmtdmtlsstinw);
    }

    /**
     * 批量删除客供入库详细
     * 
     * @param ids 需要删除的客供入库详细主键
     * @return 结果
     */
    @Override
    public int deleteAwDetailcsmtdmtlsstinwByIds(Long[] ids)
    {
        return awDetailcsmtdmtlsstinwMapper.deleteAwDetailcsmtdmtlsstinwByIds(ids);
    }

    /**
     * 删除客供入库详细信息
     * 
     * @param id 客供入库详细主键
     * @return 结果
     */
    @Override
    public int deleteAwDetailcsmtdmtlsstinwById(Long id)
    {
        return awDetailcsmtdmtlsstinwMapper.deleteAwDetailcsmtdmtlsstinwById(id);
    }
}
