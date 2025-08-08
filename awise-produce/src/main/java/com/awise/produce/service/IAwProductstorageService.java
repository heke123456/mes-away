package com.awise.produce.service;

import java.util.List;
import com.awise.produce.domain.AwProductstorage;

/**
 * 产品入库Service接口
 * 
 * @author awise
 * @date 2023-10-16
 */
public interface IAwProductstorageService 
{
    /**
     * 查询产品入库
     * 
     * @param id 产品入库主键
     * @return 产品入库
     */
    public AwProductstorage selectAwProductstorageById(Long id);

    /**
     * 查询产品入库列表
     * 
     * @param awProductstorage 产品入库
     * @return 产品入库集合
     */
    public List<AwProductstorage> selectAwProductstorageList(AwProductstorage awProductstorage);

    /**
     * 新增产品入库
     * 
     * @param awProductstorage 产品入库
     * @return 结果
     */
    public int insertAwProductstorage(AwProductstorage awProductstorage);

    /**
     * 修改产品入库
     * 
     * @param awProductstorage 产品入库
     * @return 结果
     */
    public int updateAwProductstorage(AwProductstorage awProductstorage);

    /**
     * 批量删除产品入库
     * 
     * @param ids 需要删除的产品入库主键集合
     * @return 结果
     */
    public int deleteAwProductstorageByIds(Long[] ids);

    /**
     * 删除产品入库信息
     * 
     * @param id 产品入库主键
     * @return 结果
     */
    public int deleteAwProductstorageById(Long id);
}
