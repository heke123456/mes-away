package com.awise.finance.service;

import java.util.List;
import com.awise.finance.domain.AwInvoice;

/**
 * 发票信息Service接口
 * 
 * @author awise
 * @date 2023-08-03
 */
public interface IAwInvoiceService 
{
    /**
     * 查询发票信息
     * 
     * @param id 发票信息主键
     * @return 发票信息
     */
    public AwInvoice selectAwInvoiceById(String id);

    /**
     * 查询发票信息列表
     * 
     * @param awInvoice 发票信息
     * @return 发票信息集合
     */
    public List<AwInvoice> selectAwInvoiceList(AwInvoice awInvoice);

    /**
     * 新增发票信息
     * 
     * @param awInvoice 发票信息
     * @return 结果
     */
    public int insertAwInvoice(AwInvoice awInvoice);

    /**
     * 修改发票信息
     * 
     * @param awInvoice 发票信息
     * @return 结果
     */
    public int updateAwInvoice(AwInvoice awInvoice);

    /**
     * 批量删除发票信息
     * 
     * @param ids 需要删除的发票信息主键集合
     * @return 结果
     */
    public int deleteAwInvoiceByIds(String[] ids);

    /**
     * 删除发票信息信息
     * 
     * @param id 发票信息主键
     * @return 结果
     */
    public int deleteAwInvoiceById(String id);
}
