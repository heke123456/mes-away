package com.awise.produce.mapper;

import java.util.List;
import com.awise.produce.domain.AwDetailproductwarehousing;

/**
 * 产品入库详单Mapper接口
 * 
 * @author awise
 * @date 2023-10-24
 */
public interface AwDetailproductwarehousingMapper 
{
    /**
     * 查询产品入库详单
     * 
     * @param id 产品入库详单主键
     * @return 产品入库详单
     */
    public AwDetailproductwarehousing selectAwDetailproductwarehousingById(Long id);

    /**
     * 查询产品入库详单列表
     * 
     * @param awDetailproductwarehousing 产品入库详单
     * @return 产品入库详单集合
     */
    public List<AwDetailproductwarehousing> selectAwDetailproductwarehousingList(AwDetailproductwarehousing awDetailproductwarehousing);

    /**
     * 新增产品入库详单
     * 
     * @param awDetailproductwarehousing 产品入库详单
     * @return 结果
     */
    public int insertAwDetailproductwarehousing(AwDetailproductwarehousing awDetailproductwarehousing);

    /**
     * 修改产品入库详单
     * 
     * @param awDetailproductwarehousing 产品入库详单
     * @return 结果
     */
    public int updateAwDetailproductwarehousing(AwDetailproductwarehousing awDetailproductwarehousing);

    /**
     * 删除产品入库详单
     * 
     * @param id 产品入库详单主键
     * @return 结果
     */
    public int deleteAwDetailproductwarehousingById(Long id);

    /**
     * 批量删除产品入库详单
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwDetailproductwarehousingByIds(Long[] ids);
}
