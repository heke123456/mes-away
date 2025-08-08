package com.awise.finance.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.awise.finance.mapper.AwInvoiceMapper;
import com.awise.finance.domain.AwInvoice;
import com.awise.finance.service.IAwInvoiceService;

/**
 * 发票信息Service业务层处理
 * 
 * @author awise
 * @date 2023-08-03
 */
@Service
public class AwInvoiceServiceImpl implements IAwInvoiceService 
{
    @Autowired
    private AwInvoiceMapper awInvoiceMapper;

    /**
     * 查询发票信息
     * 
     * @param id 发票信息主键
     * @return 发票信息
     */
    @Override
    public AwInvoice selectAwInvoiceById(String id)
    {
        return awInvoiceMapper.selectAwInvoiceById(id);
    }

    /**
     * 查询发票信息列表
     * 
     * @param awInvoice 发票信息
     * @return 发票信息
     */
    @Override
    public List<AwInvoice> selectAwInvoiceList(AwInvoice awInvoice)
    {
        return awInvoiceMapper.selectAwInvoiceList(awInvoice);
    }

    /**
     * 新增发票信息
     * 
     * @param awInvoice 发票信息
     * @return 结果
     */
    @Override
    public int insertAwInvoice(AwInvoice awInvoice)
    {
        return awInvoiceMapper.insertAwInvoice(awInvoice);
    }

    /**
     * 修改发票信息
     * 
     * @param awInvoice 发票信息
     * @return 结果
     */
    @Override
    public int updateAwInvoice(AwInvoice awInvoice)
    {
        return awInvoiceMapper.updateAwInvoice(awInvoice);
    }

    /**
     * 批量删除发票信息
     * 
     * @param ids 需要删除的发票信息主键
     * @return 结果
     */
    @Override
    public int deleteAwInvoiceByIds(String[] ids)
    {
        return awInvoiceMapper.deleteAwInvoiceByIds(ids);
    }

    /**
     * 删除发票信息信息
     * 
     * @param id 发票信息主键
     * @return 结果
     */
    @Override
    public int deleteAwInvoiceById(String id)
    {
        return awInvoiceMapper.deleteAwInvoiceById(id);
    }
}
