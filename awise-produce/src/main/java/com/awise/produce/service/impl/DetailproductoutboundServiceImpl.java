package com.awise.produce.service.impl;

import com.awise.produce.domain.Detailproductoutbound;
import com.awise.produce.mapper.DetailproductoutboundMapper;
import com.awise.produce.service.IDetailproductoutboundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 产品出库详单Service业务层处理
 * 
 * @author awise
 * @date 2023-10-16
 */
@Service
public class DetailproductoutboundServiceImpl implements IDetailproductoutboundService 
{
    @Autowired
    private DetailproductoutboundMapper detailproductoutboundMapper;

    /**
     * 查询产品出库详单
     * 
     * @param id 产品出库详单主键
     * @return 产品出库详单
     */
    @Override
    public Detailproductoutbound selectDetailproductoutboundById(Long id)
    {
        return detailproductoutboundMapper.selectDetailproductoutboundById(id);
    }

    /**
     * 查询产品出库详单列表
     * 
     * @param detailproductoutbound 产品出库详单
     * @return 产品出库详单
     */
    @Override
    public List<Detailproductoutbound> selectDetailproductoutboundList(Detailproductoutbound detailproductoutbound)
    {
        return detailproductoutboundMapper.selectDetailproductoutboundList(detailproductoutbound);
    }

    /**
     * 新增产品出库详单
     * 
     * @param detailproductoutbound 产品出库详单
     * @return 结果
     */
    @Override
    public int insertDetailproductoutbound(Detailproductoutbound detailproductoutbound)
    {
        return detailproductoutboundMapper.insertDetailproductoutbound(detailproductoutbound);
    }

    /**
     * 修改产品出库详单
     * 
     * @param detailproductoutbound 产品出库详单
     * @return 结果
     */
    @Override
    public int updateDetailproductoutbound(Detailproductoutbound detailproductoutbound)
    {
        return detailproductoutboundMapper.updateDetailproductoutbound(detailproductoutbound);
    }

    /**
     * 批量删除产品出库详单
     * 
     * @param ids 需要删除的产品出库详单主键
     * @return 结果
     */
    @Override
    public int deleteDetailproductoutboundByIds(Long[] ids)
    {
        return detailproductoutboundMapper.deleteDetailproductoutboundByIds(ids);
    }

    /**
     * 删除产品出库详单信息
     * 
     * @param id 产品出库详单主键
     * @return 结果
     */
    @Override
    public int deleteDetailproductoutboundById(Long id)
    {
        return detailproductoutboundMapper.deleteDetailproductoutboundById(id);
    }
}
