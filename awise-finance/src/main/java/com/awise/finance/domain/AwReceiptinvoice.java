package com.awise.finance.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 入库发票信息对象 aw_receiptinvoice
 * 
 * @author ruoyi
 * @date 2023-10-14
 */
public class AwReceiptinvoice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 入库发票编号 */
    private String receiptInvoiceID;

    /** 发票类型 */
    @Excel(name = "发票类型")
    private String invoiceType;

    /** 发票税率 */
    @Excel(name = "发票税率")
    private String invoiceTaxRate;

    /** 不含税采购单价 */
    @Excel(name = "不含税采购单价")
    private Long purchaseUnitPriceExcludingTax;

    /** 含税采购单价 */
    @Excel(name = "含税采购单价")
    private Long purchaseUnitPriceIncludingTax;

    public void setReceiptInvoiceID(String receiptInvoiceID) 
    {
        this.receiptInvoiceID = receiptInvoiceID;
    }

    public String getReceiptInvoiceID() 
    {
        return receiptInvoiceID;
    }
    public void setInvoiceType(String invoiceType) 
    {
        this.invoiceType = invoiceType;
    }

    public String getInvoiceType() 
    {
        return invoiceType;
    }
    public void setInvoiceTaxRate(String invoiceTaxRate) 
    {
        this.invoiceTaxRate = invoiceTaxRate;
    }

    public String getInvoiceTaxRate() 
    {
        return invoiceTaxRate;
    }
    public void setPurchaseUnitPriceExcludingTax(Long purchaseUnitPriceExcludingTax) 
    {
        this.purchaseUnitPriceExcludingTax = purchaseUnitPriceExcludingTax;
    }

    public Long getPurchaseUnitPriceExcludingTax() 
    {
        return purchaseUnitPriceExcludingTax;
    }
    public void setPurchaseUnitPriceIncludingTax(Long purchaseUnitPriceIncludingTax) 
    {
        this.purchaseUnitPriceIncludingTax = purchaseUnitPriceIncludingTax;
    }

    public Long getPurchaseUnitPriceIncludingTax() 
    {
        return purchaseUnitPriceIncludingTax;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("receiptInvoiceID", getReceiptInvoiceID())
            .append("invoiceType", getInvoiceType())
            .append("invoiceTaxRate", getInvoiceTaxRate())
            .append("purchaseUnitPriceExcludingTax", getPurchaseUnitPriceExcludingTax())
            .append("purchaseUnitPriceIncludingTax", getPurchaseUnitPriceIncludingTax())
            .toString();
    }
}
