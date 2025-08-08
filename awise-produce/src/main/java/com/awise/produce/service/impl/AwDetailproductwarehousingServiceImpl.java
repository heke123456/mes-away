package com.awise.produce.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.produce.mapper.AwDetailproductwarehousingMapper;
import com.awise.produce.domain.AwDetailproductwarehousing;
import com.awise.produce.service.IAwDetailproductwarehousingService;

/**
 * 产品入库详单Service业务层处理
 * 
 * @author awise
 * @date 2023-10-24
 */
@Service
public class AwDetailproductwarehousingServiceImpl implements IAwDetailproductwarehousingService 
{
    @Autowired
    private AwDetailproductwarehousingMapper awDetailproductwarehousingMapper;

    /**
     * 查询产品入库详单
     * 
     * @param id 产品入库详单主键
     * @return 产品入库详单
     */
    @Override
    public AwDetailproductwarehousing selectAwDetailproductwarehousingById(Long id)
    {
        return awDetailproductwarehousingMapper.selectAwDetailproductwarehousingById(id);
    }

    /**
     * 查询产品入库详单列表
     * 
     * @param awDetailproductwarehousing 产品入库详单
     * @return 产品入库详单
     */
    @Override
    public List<AwDetailproductwarehousing> selectAwDetailproductwarehousingList(AwDetailproductwarehousing awDetailproductwarehousing)
    {
        return awDetailproductwarehousingMapper.selectAwDetailproductwarehousingList(awDetailproductwarehousing);
    }

    /**
     * 新增产品入库详单
     * 
     * @param awDetailproductwarehousing 产品入库详单
     * @return 结果
     */
    @Override
    public int insertAwDetailproductwarehousing(AwDetailproductwarehousing awDetailproductwarehousing)
    {
        return awDetailproductwarehousingMapper.insertAwDetailproductwarehousing(awDetailproductwarehousing);
    }

    /**
     * 修改产品入库详单
     * 
     * @param awDetailproductwarehousing 产品入库详单
     * @return 结果
     */
    @Override
    public int updateAwDetailproductwarehousing(AwDetailproductwarehousing awDetailproductwarehousing)
    {
        return awDetailproductwarehousingMapper.updateAwDetailproductwarehousing(awDetailproductwarehousing);
    }

    /**
     * 批量删除产品入库详单
     * 
     * @param ids 需要删除的产品入库详单主键
     * @return 结果
     */
    @Override
    public int deleteAwDetailproductwarehousingByIds(Long[] ids)
    {
        return awDetailproductwarehousingMapper.deleteAwDetailproductwarehousingByIds(ids);
    }

    /**
     * 删除产品入库详单信息
     * 
     * @param id 产品入库详单主键
     * @return 结果
     */
    @Override
    public int deleteAwDetailproductwarehousingById(Long id)
    {
        return awDetailproductwarehousingMapper.deleteAwDetailproductwarehousingById(id);
    }
}
