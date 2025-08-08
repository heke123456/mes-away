package com.awise.finance.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.finance.mapper.AwReceiptinvoiceMapper;
import com.awise.finance.domain.AwReceiptinvoice;
import com.awise.finance.service.IAwReceiptinvoiceService;

/**
 * 入库发票信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-10-14
 */
@Service
public class AwReceiptinvoiceServiceImpl implements IAwReceiptinvoiceService 
{
    @Autowired
    private AwReceiptinvoiceMapper awReceiptinvoiceMapper;

    /**
     * 查询入库发票信息
     * 
     * @param receiptInvoiceID 入库发票信息主键
     * @return 入库发票信息
     */
    @Override
    public AwReceiptinvoice selectAwReceiptinvoiceByReceiptInvoiceID(String receiptInvoiceID)
    {
        return awReceiptinvoiceMapper.selectAwReceiptinvoiceByReceiptInvoiceID(receiptInvoiceID);
    }

    /**
     * 查询入库发票信息列表
     * 
     * @param awReceiptinvoice 入库发票信息
     * @return 入库发票信息
     */
    @Override
    public List<AwReceiptinvoice> selectAwReceiptinvoiceList(AwReceiptinvoice awReceiptinvoice)
    {
        return awReceiptinvoiceMapper.selectAwReceiptinvoiceList(awReceiptinvoice);
    }

    /**
     * 新增入库发票信息
     * 
     * @param awReceiptinvoice 入库发票信息
     * @return 结果
     */
    @Override
    public int insertAwReceiptinvoice(AwReceiptinvoice awReceiptinvoice)
    {
        return awReceiptinvoiceMapper.insertAwReceiptinvoice(awReceiptinvoice);
    }

    /**
     * 修改入库发票信息
     * 
     * @param awReceiptinvoice 入库发票信息
     * @return 结果
     */
    @Override
    public int updateAwReceiptinvoice(AwReceiptinvoice awReceiptinvoice)
    {
        return awReceiptinvoiceMapper.updateAwReceiptinvoice(awReceiptinvoice);
    }

    /**
     * 批量删除入库发票信息
     * 
     * @param receiptInvoiceIDs 需要删除的入库发票信息主键
     * @return 结果
     */
    @Override
    public int deleteAwReceiptinvoiceByReceiptInvoiceIDs(String[] receiptInvoiceIDs)
    {
        return awReceiptinvoiceMapper.deleteAwReceiptinvoiceByReceiptInvoiceIDs(receiptInvoiceIDs);
    }

    /**
     * 删除入库发票信息信息
     * 
     * @param receiptInvoiceID 入库发票信息主键
     * @return 结果
     */
    @Override
    public int deleteAwReceiptinvoiceByReceiptInvoiceID(String receiptInvoiceID)
    {
        return awReceiptinvoiceMapper.deleteAwReceiptinvoiceByReceiptInvoiceID(receiptInvoiceID);
    }
}
