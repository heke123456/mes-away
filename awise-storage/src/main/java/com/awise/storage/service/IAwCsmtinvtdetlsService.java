package com.awise.storage.service;

import java.util.List;
import com.awise.storage.domain.AwCsmtinvtdetls;

/**
 * 客供实时库存Service接口
 * 
 * @author awise
 * @date 2023-12-27
 */
public interface IAwCsmtinvtdetlsService 
{
    /**
     * 查询客供实时库存
     * 
     * @param id 客供实时库存主键
     * @return 客供实时库存
     */
    public AwCsmtinvtdetls selectAwCsmtinvtdetlsById(Long id);

    /**
     * 查询客供实时库存列表
     * 
     * @param awCsmtinvtdetls 客供实时库存
     * @return 客供实时库存集合
     */
    public List<AwCsmtinvtdetls> selectAwCsmtinvtdetlsList(AwCsmtinvtdetls awCsmtinvtdetls);

    /**
     * 新增客供实时库存
     * 
     * @param awCsmtinvtdetls 客供实时库存
     * @return 结果
     */
    public int insertAwCsmtinvtdetls(AwCsmtinvtdetls awCsmtinvtdetls);

    /**
     * 修改客供实时库存
     * 
     * @param awCsmtinvtdetls 客供实时库存
     * @return 结果
     */
    public int updateAwCsmtinvtdetls(AwCsmtinvtdetls awCsmtinvtdetls);

    /**
     * 批量删除客供实时库存
     * 
     * @param ids 需要删除的客供实时库存主键集合
     * @return 结果
     */
    public int deleteAwCsmtinvtdetlsByIds(Long[] ids);

    /**
     * 删除客供实时库存信息
     * 
     * @param id 客供实时库存主键
     * @return 结果
     */
    public int deleteAwCsmtinvtdetlsById(Long id);
}
