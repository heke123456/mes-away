package com.awise.storage.mapper;

import java.util.List;
import com.awise.storage.domain.AwDetailsoftoolstorage;

/**
 * DetailsOfToolStorageMapper接口
 * 
 * @author awise
 * @date 2023-12-06
 */
public interface AwDetailsoftoolstorageMapper 
{
    /**
     * 查询DetailsOfToolStorage
     * 
     * @param id DetailsOfToolStorage主键
     * @return DetailsOfToolStorage
     */
    public AwDetailsoftoolstorage selectAwDetailsoftoolstorageById(Long id);

    /**
     * 查询DetailsOfToolStorage列表
     * 
     * @param awDetailsoftoolstorage DetailsOfToolStorage
     * @return DetailsOfToolStorage集合
     */
    public List<AwDetailsoftoolstorage> selectAwDetailsoftoolstorageList(AwDetailsoftoolstorage awDetailsoftoolstorage);

    /**
     * 新增DetailsOfToolStorage
     * 
     * @param awDetailsoftoolstorage DetailsOfToolStorage
     * @return 结果
     */
    public int insertAwDetailsoftoolstorage(AwDetailsoftoolstorage awDetailsoftoolstorage);

    /**
     * 修改DetailsOfToolStorage
     * 
     * @param awDetailsoftoolstorage DetailsOfToolStorage
     * @return 结果
     */
    public int updateAwDetailsoftoolstorage(AwDetailsoftoolstorage awDetailsoftoolstorage);

    /**
     * 删除DetailsOfToolStorage
     * 
     * @param id DetailsOfToolStorage主键
     * @return 结果
     */
    public int deleteAwDetailsoftoolstorageById(Long id);

    /**
     * 批量删除DetailsOfToolStorage
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAwDetailsoftoolstorageByIds(Long[] ids);
}
