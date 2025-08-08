package com.awise.storage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.storage.mapper.AwCsmtinvtdetlsMapper;
import com.awise.storage.domain.AwCsmtinvtdetls;
import com.awise.storage.service.IAwCsmtinvtdetlsService;

/**
 * 客供实时库存Service业务层处理
 * 
 * @author awise
 * @date 2023-12-27
 */
@Service
public class AwCsmtinvtdetlsServiceImpl implements IAwCsmtinvtdetlsService 
{
    @Autowired
    private AwCsmtinvtdetlsMapper awCsmtinvtdetlsMapper;

    /**
     * 查询客供实时库存
     * 
     * @param id 客供实时库存主键
     * @return 客供实时库存
     */
    @Override
    public AwCsmtinvtdetls selectAwCsmtinvtdetlsById(Long id)
    {
        return awCsmtinvtdetlsMapper.selectAwCsmtinvtdetlsById(id);
    }

    /**
     * 查询客供实时库存列表
     * 
     * @param awCsmtinvtdetls 客供实时库存
     * @return 客供实时库存
     */
    @Override
    public List<AwCsmtinvtdetls> selectAwCsmtinvtdetlsList(AwCsmtinvtdetls awCsmtinvtdetls)
    {
        return awCsmtinvtdetlsMapper.selectAwCsmtinvtdetlsList(awCsmtinvtdetls);
    }

    /**
     * 新增客供实时库存
     * 
     * @param awCsmtinvtdetls 客供实时库存
     * @return 结果
     */
    @Override
    public int insertAwCsmtinvtdetls(AwCsmtinvtdetls awCsmtinvtdetls)
    {
        return awCsmtinvtdetlsMapper.insertAwCsmtinvtdetls(awCsmtinvtdetls);
    }

    /**
     * 修改客供实时库存
     * 
     * @param awCsmtinvtdetls 客供实时库存
     * @return 结果
     */
    @Override
    public int updateAwCsmtinvtdetls(AwCsmtinvtdetls awCsmtinvtdetls)
    {
        return awCsmtinvtdetlsMapper.updateAwCsmtinvtdetls(awCsmtinvtdetls);
    }

    /**
     * 批量删除客供实时库存
     * 
     * @param ids 需要删除的客供实时库存主键
     * @return 结果
     */
    @Override
    public int deleteAwCsmtinvtdetlsByIds(Long[] ids)
    {
        return awCsmtinvtdetlsMapper.deleteAwCsmtinvtdetlsByIds(ids);
    }

    /**
     * 删除客供实时库存信息
     * 
     * @param id 客供实时库存主键
     * @return 结果
     */
    @Override
    public int deleteAwCsmtinvtdetlsById(Long id)
    {
        return awCsmtinvtdetlsMapper.deleteAwCsmtinvtdetlsById(id);
    }
}
