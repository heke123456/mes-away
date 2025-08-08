package com.awise.finance.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 发票信息对象 aw_invoice
 * 
 * @author awise
 * @date 2023-08-03
 */
public class AwInvoice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 发票编号 */
    private String id;

    /** 开票类型 */
    @Excel(name = "开票类型")
    private String invoiceType;

    /** 开票日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开票日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date invoiceCreateTime;

    /** 开票数量 */
    @Excel(name = "开票数量")
    private String invoiceNumer;

    /** 税率 */
    @Excel(name = "税率")
    private String taxRate;

    /** 税费 */
    @Excel(name = "税费")
    private String taxation;

    /** 销售单价(不含税) */
    @Excel(name = "销售单价(不含税)")
    private String salesUnitPriceExcludingTax;

    /** 销售单价(含税) */
    @Excel(name = "销售单价(含税)")
    private String salesUnitPriceIncludingTax;

    /** 销售金额(不含税) */
    @Excel(name = "销售金额(不含税)")
    private String consumptionAmountExcludingTax;

    /** 销售金额(含税) */
    @Excel(name = "销售金额(含税)")
    private String consumptionAmountIncludingTax;

    /** 对账日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "对账日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date reconciliationDate;

    /** 客户对账人员 */
    @Excel(name = "客户对账人员")
    private String customerReconciliationPersonnel;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setInvoiceType(String invoiceType) 
    {
        this.invoiceType = invoiceType;
    }

    public String getInvoiceType() 
    {
        return invoiceType;
    }
    public void setInvoiceCreateTime(Date invoiceCreateTime) 
    {
        this.invoiceCreateTime = invoiceCreateTime;
    }

    public Date getInvoiceCreateTime() 
    {
        return invoiceCreateTime;
    }
    public void setInvoiceNumer(String invoiceNumer) 
    {
        this.invoiceNumer = invoiceNumer;
    }

    public String getInvoiceNumer() 
    {
        return invoiceNumer;
    }
    public void setTaxRate(String taxRate) 
    {
        this.taxRate = taxRate;
    }

    public String getTaxRate() 
    {
        return taxRate;
    }
    public void setTaxation(String taxation) 
    {
        this.taxation = taxation;
    }

    public String getTaxation() 
    {
        return taxation;
    }
    public void setSalesUnitPriceExcludingTax(String salesUnitPriceExcludingTax) 
    {
        this.salesUnitPriceExcludingTax = salesUnitPriceExcludingTax;
    }

    public String getSalesUnitPriceExcludingTax() 
    {
        return salesUnitPriceExcludingTax;
    }
    public void setSalesUnitPriceIncludingTax(String salesUnitPriceIncludingTax) 
    {
        this.salesUnitPriceIncludingTax = salesUnitPriceIncludingTax;
    }

    public String getSalesUnitPriceIncludingTax() 
    {
        return salesUnitPriceIncludingTax;
    }
    public void setConsumptionAmountExcludingTax(String consumptionAmountExcludingTax) 
    {
        this.consumptionAmountExcludingTax = consumptionAmountExcludingTax;
    }

    public String getConsumptionAmountExcludingTax() 
    {
        return consumptionAmountExcludingTax;
    }
    public void setConsumptionAmountIncludingTax(String consumptionAmountIncludingTax) 
    {
        this.consumptionAmountIncludingTax = consumptionAmountIncludingTax;
    }

    public String getConsumptionAmountIncludingTax() 
    {
        return consumptionAmountIncludingTax;
    }
    public void setReconciliationDate(Date reconciliationDate) 
    {
        this.reconciliationDate = reconciliationDate;
    }

    public Date getReconciliationDate() 
    {
        return reconciliationDate;
    }
    public void setCustomerReconciliationPersonnel(String customerReconciliationPersonnel) 
    {
        this.customerReconciliationPersonnel = customerReconciliationPersonnel;
    }

    public String getCustomerReconciliationPersonnel() 
    {
        return customerReconciliationPersonnel;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("invoiceType", getInvoiceType())
            .append("invoiceCreateTime", getInvoiceCreateTime())
            .append("invoiceNumer", getInvoiceNumer())
            .append("taxRate", getTaxRate())
            .append("taxation", getTaxation())
            .append("salesUnitPriceExcludingTax", getSalesUnitPriceExcludingTax())
            .append("salesUnitPriceIncludingTax", getSalesUnitPriceIncludingTax())
            .append("consumptionAmountExcludingTax", getConsumptionAmountExcludingTax())
            .append("consumptionAmountIncludingTax", getConsumptionAmountIncludingTax())
            .append("reconciliationDate", getReconciliationDate())
            .append("customerReconciliationPersonnel", getCustomerReconciliationPersonnel())
            .toString();
    }
}
