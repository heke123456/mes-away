package com.awise.storage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 材料入库详细对象 aw_matlwarehousingdet
 * 
 * @author awise
 * @date 2023-10-25
 */
public class AwMatlwarehousingdet extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 入库单编号 */
    @Excel(name = "入库单编号")
    private String warehouseEntryID;

    /** 申购材料编号 */
    @Excel(name = "申购材料编号")
    private String materialSubscription;

    /** 材料信息编号 */
    @Excel(name = "材料信息编号")
    private String materialID;



    /** 材料价格 */
    @Excel(name = "材料价格")
    private String materialPrice;



    /** 材料名称 */
    @Excel(name = "材料名称")
    private String name;

    /** 类别名称 */
    private String typeName;

    /** 规格类型 */
    private String specificationsType;

    /** 规格型号 */
    @Excel(name = "规格型号")
    private String specificationModel;

    /** 材料密度 */
    private String materialDensity;

    /** 发票信息编号 */
    @Excel(name = "发票信息编号")
    private String receiptInvoiceID;

    /** 发票类型 */
    private String invoiceType;

    /** 发票税率 */
    private String invoiceTaxRate;

    /** 不含税采购单价 */
    private Long purchaseUnitPriceExcludingTax;

    /** 含税采购单价 */
    private Long purchaseUnitPriceIncludingTax;

    /** 入库数量 */
    private Long receiptQuantity;

    /** 附样 */
    private String sampleURL;

    /** 备注 */
    private String notes;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setWarehouseEntryID(String warehouseEntryID) 
    {
        this.warehouseEntryID = warehouseEntryID;
    }

    public String getWarehouseEntryID() 
    {
        return warehouseEntryID;
    }
    public void setMaterialSubscription(String materialSubscription) 
    {
        this.materialSubscription = materialSubscription;
    }

    public String getMaterialSubscription() 
    {
        return materialSubscription;
    }
    public void setMaterialID(String materialID) 
    {
        this.materialID = materialID;
    }

    public String getMaterialID() 
    {
        return materialID;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setTypeName(String typeName) 
    {
        this.typeName = typeName;
    }

    public String getTypeName() 
    {
        return typeName;
    }
    public void setSpecificationsType(String specificationsType) 
    {
        this.specificationsType = specificationsType;
    }

    public String getSpecificationsType() 
    {
        return specificationsType;
    }
    public void setSpecificationModel(String specificationModel) 
    {
        this.specificationModel = specificationModel;
    }

    public String getSpecificationModel() 
    {
        return specificationModel;
    }
    public void setMaterialDensity(String materialDensity) 
    {
        this.materialDensity = materialDensity;
    }

    public String getMaterialDensity() 
    {
        return materialDensity;
    }
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
    public void setReceiptQuantity(Long receiptQuantity) 
    {
        this.receiptQuantity = receiptQuantity;
    }

    public Long getReceiptQuantity() 
    {
        return receiptQuantity;
    }
    public void setSampleURL(String sampleURL) 
    {
        this.sampleURL = sampleURL;
    }

    public String getSampleURL() 
    {
        return sampleURL;
    }
    public void setNotes(String notes) 
    {
        this.notes = notes;
    }

    public String getNotes() 
    {
        return notes;
    }

    public String getMaterialPrice() {
        return materialPrice;
    }

    public void setMaterialPrice(String materialPrice) {
        this.materialPrice = materialPrice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("warehouseEntryID", getWarehouseEntryID())
            .append("materialSubscription", getMaterialSubscription())
            .append("materialID", getMaterialID())
            .append("materialPrice", getMaterialPrice())
            .append("name", getName())
            .append("typeName", getTypeName())
            .append("specificationsType", getSpecificationsType())
            .append("specificationModel", getSpecificationModel())
            .append("materialDensity", getMaterialDensity())
            .append("receiptInvoiceID", getReceiptInvoiceID())
            .append("invoiceType", getInvoiceType())
            .append("invoiceTaxRate", getInvoiceTaxRate())
            .append("purchaseUnitPriceExcludingTax", getPurchaseUnitPriceExcludingTax())
            .append("purchaseUnitPriceIncludingTax", getPurchaseUnitPriceIncludingTax())
            .append("receiptQuantity", getReceiptQuantity())
            .append("sampleURL", getSampleURL())
            .append("notes", getNotes())
            .toString();
    }
}
