package com.awise.finance.service;

import java.util.List;
import com.awise.finance.domain.AwReceiptinvoice;

/**
 * 入库发票信息Service接口
 * 
 * @author ruoyi
 * @date 2023-10-14
 */
public interface IAwReceiptinvoiceService 
{
    /**
     * 查询入库发票信息
     * 
     * @param receiptInvoiceID 入库发票信息主键
     * @return 入库发票信息
     */
    public AwReceiptinvoice selectAwReceiptinvoiceByReceiptInvoiceID(String receiptInvoiceID);

    /**
     * 查询入库发票信息列表
     * 
     * @param awReceiptinvoice 入库发票信息
     * @return 入库发票信息集合
     */
    public List<AwReceiptinvoice> selectAwReceiptinvoiceList(AwReceiptinvoice awReceiptinvoice);

    /**
     * 新增入库发票信息
     * 
     * @param awReceiptinvoice 入库发票信息
     * @return 结果
     */
    public int insertAwReceiptinvoice(AwReceiptinvoice awReceiptinvoice);

    /**
     * 修改入库发票信息
     * 
     * @param awReceiptinvoice 入库发票信息
     * @return 结果
     */
    public int updateAwReceiptinvoice(AwReceiptinvoice awReceiptinvoice);

    /**
     * 批量删除入库发票信息
     * 
     * @param receiptInvoiceIDs 需要删除的入库发票信息主键集合
     * @return 结果
     */
    public int deleteAwReceiptinvoiceByReceiptInvoiceIDs(String[] receiptInvoiceIDs);

    /**
     * 删除入库发票信息信息
     * 
     * @param receiptInvoiceID 入库发票信息主键
     * @return 结果
     */
    public int deleteAwReceiptinvoiceByReceiptInvoiceID(String receiptInvoiceID);
}
