package com.awise.produce.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.produce.mapper.AwProductstorageMapper;
import com.awise.produce.domain.AwProductstorage;
import com.awise.produce.service.IAwProductstorageService;

/**
 * 产品入库Service业务层处理
 * 
 * @author awise
 * @date 2023-10-16
 */
@Service
public class AwProductstorageServiceImpl implements IAwProductstorageService 
{
    @Autowired
    private AwProductstorageMapper awProductstorageMapper;

    /**
     * 查询产品入库
     * 
     * @param id 产品入库主键
     * @return 产品入库
     */
    @Override
    public AwProductstorage selectAwProductstorageById(Long id)
    {
        return awProductstorageMapper.selectAwProductstorageById(id);
    }

    /**
     * 查询产品入库列表
     * 
     * @param awProductstorage 产品入库
     * @return 产品入库
     */
    @Override
    public List<AwProductstorage> selectAwProductstorageList(AwProductstorage awProductstorage)
    {
        return awProductstorageMapper.selectAwProductstorageList(awProductstorage);
    }

    /**
     * 新增产品入库
     * 
     * @param awProductstorage 产品入库
     * @return 结果
     */
    @Override
    public int insertAwProductstorage(AwProductstorage awProductstorage)
    {
        return awProductstorageMapper.insertAwProductstorage(awProductstorage);
    }

    /**
     * 修改产品入库
     * 
     * @param awProductstorage 产品入库
     * @return 结果
     */
    @Override
    public int updateAwProductstorage(AwProductstorage awProductstorage)
    {
        return awProductstorageMapper.updateAwProductstorage(awProductstorage);
    }

    /**
     * 批量删除产品入库
     * 
     * @param ids 需要删除的产品入库主键
     * @return 结果
     */
    @Override
    public int deleteAwProductstorageByIds(Long[] ids)
    {
        return awProductstorageMapper.deleteAwProductstorageByIds(ids);
    }

    /**
     * 删除产品入库信息
     * 
     * @param id 产品入库主键
     * @return 结果
     */
    @Override
    public int deleteAwProductstorageById(Long id)
    {
        return awProductstorageMapper.deleteAwProductstorageById(id);
    }
}
