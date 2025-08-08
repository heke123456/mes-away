package com.awise.produce.service;

import com.awise.produce.domain.Detailproductoutbound;

import java.util.List;

/**
 * 产品出库详单Service接口
 * 
 * @author awise
 * @date 2023-10-16
 */
public interface IDetailproductoutboundService 
{
    /**
     * 查询产品出库详单
     * 
     * @param id 产品出库详单主键
     * @return 产品出库详单
     */
    public Detailproductoutbound selectDetailproductoutboundById(Long id);

    /**
     * 查询产品出库详单列表
     * 
     * @param detailproductoutbound 产品出库详单
     * @return 产品出库详单集合
     */
    public List<Detailproductoutbound> selectDetailproductoutboundList(Detailproductoutbound detailproductoutbound);

    /**
     * 新增产品出库详单
     * 
     * @param detailproductoutbound 产品出库详单
     * @return 结果
     */
    public int insertDetailproductoutbound(Detailproductoutbound detailproductoutbound);

    /**
     * 修改产品出库详单
     * 
     * @param detailproductoutbound 产品出库详单
     * @return 结果
     */
    public int updateDetailproductoutbound(Detailproductoutbound detailproductoutbound);

    /**
     * 批量删除产品出库详单
     * 
     * @param ids 需要删除的产品出库详单主键集合
     * @return 结果
     */
    public int deleteDetailproductoutboundByIds(Long[] ids);

    /**
     * 删除产品出库详单信息
     * 
     * @param id 产品出库详单主键
     * @return 结果
     */
    public int deleteDetailproductoutboundById(Long id);
}
