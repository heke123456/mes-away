package com.awise.storage.service;

import java.util.List;
import com.awise.storage.domain.AwDetailsoftoolstorage;

/**
 * DetailsOfToolStorageService接口
 * 
 * @author awise
 * @date 2023-12-06
 */
public interface IAwDetailsoftoolstorageService 
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
     * 批量删除DetailsOfToolStorage
     * 
     * @param ids 需要删除的DetailsOfToolStorage主键集合
     * @return 结果
     */
    public int deleteAwDetailsoftoolstorageByIds(Long[] ids);

    /**
     * 删除DetailsOfToolStorage信息
     * 
     * @param id DetailsOfToolStorage主键
     * @return 结果
     */
    public int deleteAwDetailsoftoolstorageById(Long id);
}
