package com.awise.storage.service;

import java.util.List;
import com.awise.storage.domain.AwDetailcsmtdmtlsstinw;

/**
 * 客供入库详细Service接口
 * 
 * @author awise
 * @date 2023-12-26
 */
public interface IAwDetailcsmtdmtlsstinwService 
{
    /**
     * 查询客供入库详细
     * 
     * @param id 客供入库详细主键
     * @return 客供入库详细
     */
    public AwDetailcsmtdmtlsstinw selectAwDetailcsmtdmtlsstinwById(Long id);

    /**
     * 查询客供入库详细列表
     * 
     * @param awDetailcsmtdmtlsstinw 客供入库详细
     * @return 客供入库详细集合
     */
    public List<AwDetailcsmtdmtlsstinw> selectAwDetailcsmtdmtlsstinwList(AwDetailcsmtdmtlsstinw awDetailcsmtdmtlsstinw);

    /**
     * 新增客供入库详细
     * 
     * @param awDetailcsmtdmtlsstinw 客供入库详细
     * @return 结果
     */
    public int insertAwDetailcsmtdmtlsstinw(AwDetailcsmtdmtlsstinw awDetailcsmtdmtlsstinw);

    /**
     * 修改客供入库详细
     * 
     * @param awDetailcsmtdmtlsstinw 客供入库详细
     * @return 结果
     */
    public int updateAwDetailcsmtdmtlsstinw(AwDetailcsmtdmtlsstinw awDetailcsmtdmtlsstinw);

    /**
     * 批量删除客供入库详细
     * 
     * @param ids 需要删除的客供入库详细主键集合
     * @return 结果
     */
    public int deleteAwDetailcsmtdmtlsstinwByIds(Long[] ids);

    /**
     * 删除客供入库详细信息
     * 
     * @param id 客供入库详细主键
     * @return 结果
     */
    public int deleteAwDetailcsmtdmtlsstinwById(Long id);
}
