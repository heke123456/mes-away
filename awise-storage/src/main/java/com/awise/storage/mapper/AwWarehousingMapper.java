package com.awise.storage.mapper;

import java.util.List;
import com.awise.storage.domain.AwWarehousing;

/**
 * 入库单Mapper接口
 * 
 * @author ruoyi
 * @date 2023-10-14
 */
public interface AwWarehousingMapper 
{
    /**
     * 查询入库单
     * 
     * @param warehouseEntryID 入库单主键
     * @return 入库单
     */
    public AwWarehousing selectAwWarehousingByWarehouseEntryID(String warehouseEntryID);

    /**
     * 查询入库单列表
     * 
     * @param awWarehousing 入库单
     * @return 入库单集合
     */
    public List<AwWarehousing> selectAwWarehousingList(AwWarehousing awWarehousing);

    /**
     * 新增入库单
     * 
     * @param awWarehousing 入库单
     * @return 结果
     */
    public int insertAwWarehousing(AwWarehousing awWarehousing);

    /**
     * 修改入库单
     * 
     * @param awWarehousing 入库单
     * @return 结果
     */
    public int updateAwWarehousing(AwWarehousing awWarehousing);

    /**
     * 删除入库单
     * 
     * @param warehouseEntryID 入库单主键
     * @return 结果
     */
    public int deleteAwWarehousingByWarehouseEntryID(String warehouseEntryID);

    /**
     * 批量删除入库单
     * 
     * @param warehouseEntryIDs 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwWarehousingByWarehouseEntryIDs(String[] warehouseEntryIDs);
}
