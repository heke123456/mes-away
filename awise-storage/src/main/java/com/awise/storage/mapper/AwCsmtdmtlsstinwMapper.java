package com.awise.storage.mapper;

import java.util.List;
import com.awise.storage.domain.AwCsmtdmtlsstinw;

/**
 * 客供材料入库Mapper接口
 * 
 * @author awise
 * @date 2023-12-26
 */
public interface AwCsmtdmtlsstinwMapper 
{
    /**
     * 查询客供材料入库
     * 
     * @param id 客供材料入库主键
     * @return 客供材料入库
     */
    public AwCsmtdmtlsstinw selectAwCsmtdmtlsstinwById(Long id);

    /**
     * 查询客供材料入库列表
     * 
     * @param awCsmtdmtlsstinw 客供材料入库
     * @return 客供材料入库集合
     */
    public List<AwCsmtdmtlsstinw> selectAwCsmtdmtlsstinwList(AwCsmtdmtlsstinw awCsmtdmtlsstinw);

    /**
     * 新增客供材料入库
     * 
     * @param awCsmtdmtlsstinw 客供材料入库
     * @return 结果
     */
    public int insertAwCsmtdmtlsstinw(AwCsmtdmtlsstinw awCsmtdmtlsstinw);

    /**
     * 修改客供材料入库
     * 
     * @param awCsmtdmtlsstinw 客供材料入库
     * @return 结果
     */
    public int updateAwCsmtdmtlsstinw(AwCsmtdmtlsstinw awCsmtdmtlsstinw);

    /**
     * 删除客供材料入库
     * 
     * @param id 客供材料入库主键
     * @return 结果
     */
    public int deleteAwCsmtdmtlsstinwById(Long id);

    /**
     * 批量删除客供材料入库
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwCsmtdmtlsstinwByIds(Long[] ids);
}
