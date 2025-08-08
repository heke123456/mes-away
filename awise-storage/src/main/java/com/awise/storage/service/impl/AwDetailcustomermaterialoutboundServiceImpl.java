package com.awise.storage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.storage.mapper.AwDetailcustomermaterialoutboundMapper;
import com.awise.storage.domain.AwDetailcustomermaterialoutbound;
import com.awise.storage.service.IAwDetailcustomermaterialoutboundService;

/**
 * 客供材料出库详细Service业务层处理
 * 
 * @author awise
 * @date 2024-04-23
 */
@Service
public class AwDetailcustomermaterialoutboundServiceImpl implements IAwDetailcustomermaterialoutboundService 
{
    @Autowired
    private AwDetailcustomermaterialoutboundMapper awDetailcustomermaterialoutboundMapper;

    /**
     * 查询客供材料出库详细
     * 
     * @param id 客供材料出库详细主键
     * @return 客供材料出库详细
     */
    @Override
    public AwDetailcustomermaterialoutbound selectAwDetailcustomermaterialoutboundById(Long id)
    {
        return awDetailcustomermaterialoutboundMapper.selectAwDetailcustomermaterialoutboundById(id);
    }

    /**
     * 查询客供材料出库详细列表
     * 
     * @param awDetailcustomermaterialoutbound 客供材料出库详细
     * @return 客供材料出库详细
     */
    @Override
    public List<AwDetailcustomermaterialoutbound> selectAwDetailcustomermaterialoutboundList(AwDetailcustomermaterialoutbound awDetailcustomermaterialoutbound)
    {
        return awDetailcustomermaterialoutboundMapper.selectAwDetailcustomermaterialoutboundList(awDetailcustomermaterialoutbound);
    }

    /**
     * 新增客供材料出库详细
     * 
     * @param awDetailcustomermaterialoutbound 客供材料出库详细
     * @return 结果
     */
    @Override
    public int insertAwDetailcustomermaterialoutbound(AwDetailcustomermaterialoutbound awDetailcustomermaterialoutbound)
    {
        return awDetailcustomermaterialoutboundMapper.insertAwDetailcustomermaterialoutbound(awDetailcustomermaterialoutbound);
    }

    /**
     * 修改客供材料出库详细
     * 
     * @param awDetailcustomermaterialoutbound 客供材料出库详细
     * @return 结果
     */
    @Override
    public int updateAwDetailcustomermaterialoutbound(AwDetailcustomermaterialoutbound awDetailcustomermaterialoutbound)
    {
        return awDetailcustomermaterialoutboundMapper.updateAwDetailcustomermaterialoutbound(awDetailcustomermaterialoutbound);
    }

    /**
     * 批量删除客供材料出库详细
     * 
     * @param ids 需要删除的客供材料出库详细主键
     * @return 结果
     */
    @Override
    public int deleteAwDetailcustomermaterialoutboundByIds(Long[] ids)
    {
        return awDetailcustomermaterialoutboundMapper.deleteAwDetailcustomermaterialoutboundByIds(ids);
    }

    /**
     * 删除客供材料出库详细信息
     * 
     * @param id 客供材料出库详细主键
     * @return 结果
     */
    @Override
    public int deleteAwDetailcustomermaterialoutboundById(Long id)
    {
        return awDetailcustomermaterialoutboundMapper.deleteAwDetailcustomermaterialoutboundById(id);
    }
}
