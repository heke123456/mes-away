package com.awise.produce.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.produce.mapper.AwProductoutboundMapper;
import com.awise.produce.domain.AwProductoutbound;
import com.awise.produce.service.IAwProductoutboundService;

/**
 * 产品出库Service业务层处理
 * 
 * @author awise
 * @date 2023-10-16
 */
@Service
public class AwProductoutboundServiceImpl implements IAwProductoutboundService 
{
    @Autowired
    private AwProductoutboundMapper awProductoutboundMapper;

    /**
     * 查询产品出库
     * 
     * @param id 产品出库主键
     * @return 产品出库
     */
    @Override
    public AwProductoutbound selectAwProductoutboundById(Long id)
    {
        return awProductoutboundMapper.selectAwProductoutboundById(id);
    }

    /**
     * 查询产品出库列表
     * 
     * @param awProductoutbound 产品出库
     * @return 产品出库
     */
    @Override
    public List<AwProductoutbound> selectAwProductoutboundList(AwProductoutbound awProductoutbound)
    {
        return awProductoutboundMapper.selectAwProductoutboundList(awProductoutbound);
    }

    /**
     * 新增产品出库
     * 
     * @param awProductoutbound 产品出库
     * @return 结果
     */
    @Override
    public int insertAwProductoutbound(AwProductoutbound awProductoutbound)
    {
        return awProductoutboundMapper.insertAwProductoutbound(awProductoutbound);
    }

    /**
     * 修改产品出库
     * 
     * @param awProductoutbound 产品出库
     * @return 结果
     */
    @Override
    public int updateAwProductoutbound(AwProductoutbound awProductoutbound)
    {
        return awProductoutboundMapper.updateAwProductoutbound(awProductoutbound);
    }

    /**
     * 批量删除产品出库
     * 
     * @param ids 需要删除的产品出库主键
     * @return 结果
     */
    @Override
    public int deleteAwProductoutboundByIds(Long[] ids)
    {
        return awProductoutboundMapper.deleteAwProductoutboundByIds(ids);
    }

    /**
     * 删除产品出库信息
     * 
     * @param id 产品出库主键
     * @return 结果
     */
    @Override
    public int deleteAwProductoutboundById(Long id)
    {
        return awProductoutboundMapper.deleteAwProductoutboundById(id);
    }
}
