package com.awise.storage.mapper;

import java.util.List;
import com.awise.storage.domain.AwToolstorage;

/**
 * 刀具入库Mapper接口
 * 
 * @author awise
 * @date 2023-12-06
 */
public interface AwToolstorageMapper 
{
    /**
     * 查询刀具入库
     * 
     * @param id 刀具入库主键
     * @return 刀具入库
     */
    public AwToolstorage selectAwToolstorageById(String id);

    /**
     * 查询刀具入库列表
     * 
     * @param awToolstorage 刀具入库
     * @return 刀具入库集合
     */
    public List<AwToolstorage> selectAwToolstorageList(AwToolstorage awToolstorage);

    /**
     * 新增刀具入库
     * 
     * @param awToolstorage 刀具入库
     * @return 结果
     */
    public int insertAwToolstorage(AwToolstorage awToolstorage);

    /**
     * 修改刀具入库
     * 
     * @param awToolstorage 刀具入库
     * @return 结果
     */
    public int updateAwToolstorage(AwToolstorage awToolstorage);

    /**
     * 删除刀具入库
     * 
     * @param id 刀具入库主键
     * @return 结果
     */
    public int deleteAwToolstorageById(String id);

    /**
     * 批量删除刀具入库
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwToolstorageByIds(String[] ids);
}
