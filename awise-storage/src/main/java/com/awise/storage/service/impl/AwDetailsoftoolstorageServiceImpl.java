package com.awise.storage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.storage.mapper.AwDetailsoftoolstorageMapper;
import com.awise.storage.domain.AwDetailsoftoolstorage;
import com.awise.storage.service.IAwDetailsoftoolstorageService;

/**
 * DetailsOfToolStorageService业务层处理
 * 
 * @author awise
 * @date 2023-12-06
 */
@Service
public class AwDetailsoftoolstorageServiceImpl implements IAwDetailsoftoolstorageService 
{
    @Autowired
    private AwDetailsoftoolstorageMapper awDetailsoftoolstorageMapper;

    /**
     * 查询DetailsOfToolStorage
     * 
     * @param id DetailsOfToolStorage主键
     * @return DetailsOfToolStorage
     */
    @Override
    public AwDetailsoftoolstorage selectAwDetailsoftoolstorageById(Long id)
    {
        return awDetailsoftoolstorageMapper.selectAwDetailsoftoolstorageById(id);
    }

    /**
     * 查询DetailsOfToolStorage列表
     * 
     * @param awDetailsoftoolstorage DetailsOfToolStorage
     * @return DetailsOfToolStorage
     */
    @Override
    public List<AwDetailsoftoolstorage> selectAwDetailsoftoolstorageList(AwDetailsoftoolstorage awDetailsoftoolstorage)
    {
        return awDetailsoftoolstorageMapper.selectAwDetailsoftoolstorageList(awDetailsoftoolstorage);
    }

    /**
     * 新增DetailsOfToolStorage
     * 
     * @param awDetailsoftoolstorage DetailsOfToolStorage
     * @return 结果
     */
    @Override
    public int insertAwDetailsoftoolstorage(AwDetailsoftoolstorage awDetailsoftoolstorage)
    {
        return awDetailsoftoolstorageMapper.insertAwDetailsoftoolstorage(awDetailsoftoolstorage);
    }

    /**
     * 修改DetailsOfToolStorage
     * 
     * @param awDetailsoftoolstorage DetailsOfToolStorage
     * @return 结果
     */
    @Override
    public int updateAwDetailsoftoolstorage(AwDetailsoftoolstorage awDetailsoftoolstorage)
    {
        return awDetailsoftoolstorageMapper.updateAwDetailsoftoolstorage(awDetailsoftoolstorage);
    }

    /**
     * 批量删除DetailsOfToolStorage
     * 
     * @param ids 需要删除的DetailsOfToolStorage主键
     * @return 结果
     */
    @Override
    public int deleteAwDetailsoftoolstorageByIds(Long[] ids)
    {
        return awDetailsoftoolstorageMapper.deleteAwDetailsoftoolstorageByIds(ids);
    }

    /**
     * 删除DetailsOfToolStorage信息
     * 
     * @param id DetailsOfToolStorage主键
     * @return 结果
     */
    @Override
    public int deleteAwDetailsoftoolstorageById(Long id)
    {
        return awDetailsoftoolstorageMapper.deleteAwDetailsoftoolstorageById(id);
    }
}
