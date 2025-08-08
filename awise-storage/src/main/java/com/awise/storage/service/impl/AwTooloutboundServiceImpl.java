package com.awise.storage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.storage.mapper.AwTooloutboundMapper;
import com.awise.storage.domain.AwTooloutbound;
import com.awise.storage.service.IAwTooloutboundService;

/**
 * 刀具出库Service业务层处理
 * 
 * @author awise
 * @date 2023-12-08
 */
@Service
public class AwTooloutboundServiceImpl implements IAwTooloutboundService 
{
    @Autowired
    private AwTooloutboundMapper awTooloutboundMapper;

    /**
     * 查询刀具出库
     * 
     * @param id 刀具出库主键
     * @return 刀具出库
     */
    @Override
    public AwTooloutbound selectAwTooloutboundById(Long id)
    {
        return awTooloutboundMapper.selectAwTooloutboundById(id);
    }

    /**
     * 查询刀具出库列表
     * 
     * @param awTooloutbound 刀具出库
     * @return 刀具出库
     */
    @Override
    public List<AwTooloutbound> selectAwTooloutboundList(AwTooloutbound awTooloutbound)
    {
        return awTooloutboundMapper.selectAwTooloutboundList(awTooloutbound);
    }

    /**
     * 新增刀具出库
     * 
     * @param awTooloutbound 刀具出库
     * @return 结果
     */
    @Override
    public int insertAwTooloutbound(AwTooloutbound awTooloutbound)
    {
        return awTooloutboundMapper.insertAwTooloutbound(awTooloutbound);
    }

    /**
     * 修改刀具出库
     * 
     * @param awTooloutbound 刀具出库
     * @return 结果
     */
    @Override
    public int updateAwTooloutbound(AwTooloutbound awTooloutbound)
    {
        return awTooloutboundMapper.updateAwTooloutbound(awTooloutbound);
    }

    /**
     * 批量删除刀具出库
     * 
     * @param ids 需要删除的刀具出库主键
     * @return 结果
     */
    @Override
    public int deleteAwTooloutboundByIds(Long[] ids)
    {
        return awTooloutboundMapper.deleteAwTooloutboundByIds(ids);
    }

    /**
     * 删除刀具出库信息
     * 
     * @param id 刀具出库主键
     * @return 结果
     */
    @Override
    public int deleteAwTooloutboundById(Long id)
    {
        return awTooloutboundMapper.deleteAwTooloutboundById(id);
    }
}
