package com.awise.storage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.storage.mapper.AwDetailsoftooldeliveryMapper;
import com.awise.storage.domain.AwDetailsoftooldelivery;
import com.awise.storage.service.IAwDetailsoftooldeliveryService;

/**
 * 刀具出库详细Service业务层处理
 * 
 * @author awise
 * @date 2023-12-08
 */
@Service
public class AwDetailsoftooldeliveryServiceImpl implements IAwDetailsoftooldeliveryService 
{
    @Autowired
    private AwDetailsoftooldeliveryMapper awDetailsoftooldeliveryMapper;

    /**
     * 查询刀具出库详细
     * 
     * @param id 刀具出库详细主键
     * @return 刀具出库详细
     */
    @Override
    public AwDetailsoftooldelivery selectAwDetailsoftooldeliveryById(Long id)
    {
        return awDetailsoftooldeliveryMapper.selectAwDetailsoftooldeliveryById(id);
    }

    /**
     * 查询刀具出库详细列表
     * 
     * @param awDetailsoftooldelivery 刀具出库详细
     * @return 刀具出库详细
     */
    @Override
    public List<AwDetailsoftooldelivery> selectAwDetailsoftooldeliveryList(AwDetailsoftooldelivery awDetailsoftooldelivery)
    {
        return awDetailsoftooldeliveryMapper.selectAwDetailsoftooldeliveryList(awDetailsoftooldelivery);
    }

    /**
     * 新增刀具出库详细
     * 
     * @param awDetailsoftooldelivery 刀具出库详细
     * @return 结果
     */
    @Override
    public int insertAwDetailsoftooldelivery(AwDetailsoftooldelivery awDetailsoftooldelivery)
    {
        return awDetailsoftooldeliveryMapper.insertAwDetailsoftooldelivery(awDetailsoftooldelivery);
    }

    /**
     * 修改刀具出库详细
     * 
     * @param awDetailsoftooldelivery 刀具出库详细
     * @return 结果
     */
    @Override
    public int updateAwDetailsoftooldelivery(AwDetailsoftooldelivery awDetailsoftooldelivery)
    {
        return awDetailsoftooldeliveryMapper.updateAwDetailsoftooldelivery(awDetailsoftooldelivery);
    }

    /**
     * 批量删除刀具出库详细
     * 
     * @param ids 需要删除的刀具出库详细主键
     * @return 结果
     */
    @Override
    public int deleteAwDetailsoftooldeliveryByIds(Long[] ids)
    {
        return awDetailsoftooldeliveryMapper.deleteAwDetailsoftooldeliveryByIds(ids);
    }

    /**
     * 删除刀具出库详细信息
     * 
     * @param id 刀具出库详细主键
     * @return 结果
     */
    @Override
    public int deleteAwDetailsoftooldeliveryById(Long id)
    {
        return awDetailsoftooldeliveryMapper.deleteAwDetailsoftooldeliveryById(id);
    }
}
