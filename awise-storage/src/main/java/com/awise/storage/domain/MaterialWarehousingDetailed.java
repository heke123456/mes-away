package com.awise.storage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 材料入库详细对象 materialWarehousingDetailed
 * 
 * @author awise
 * @date 2023-10-19
 */
public class MaterialWarehousingDetailed extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 入库单编号 */
    @Excel(name = "入库单编号")
    private String warehouseEntryID;

    /** id */
    @Excel(name = "id")
    private Long localmaterialwarehousingID;

    /** 申购数量 */
    @Excel(name = "申购数量")
    private Long subscriptionQuantity;

    /** 材料名称 */
    @Excel(name = "材料名称")
    private String name;

    /** 类别名称 */
    @Excel(name = "类别名称")
    private String typeName;

    /** 规格类型 */
    @Excel(name = "规格类型")
    private String specificationsType;

    /** 规格型号 */
    @Excel(name = "规格型号")
    private String specificationModel;

    /** 材料密度#校验大于0，用于工艺下料后自动计算重量。规格类型确定了重量计算公式。材料计数单位都以kg计，材料密度单位为kg/mm^3，材料尺寸单位为mm# */
    private String materialDensity;

    /** 发票税率 */
    @Excel(name = "发票税率")
    private String invoiceTaxRate;

    /** 发票类型 */
    @Excel(name = "发票类型")
    private String invoiceType;

    /** 不含税采购单价 */
    @Excel(name = "不含税采购单价")
    private Long purchaseUnitPriceExcludingTax;

    /** 含税采购单价 */
    @Excel(name = "含税采购单价")
    private Long purchaseUnitPriceIncludingTax;

    /** 申购单编号 */
    @Excel(name = "申购单编号")
    private String subscribeID;

    /** 附样 */
    private String sampleURL;

    public void setWarehouseEntryID(String warehouseEntryID) 
    {
        this.warehouseEntryID = warehouseEntryID;
    }

    public String getWarehouseEntryID() 
    {
        return warehouseEntryID;
    }
    public void setLocalmaterialwarehousingID(Long localmaterialwarehousingID) 
    {
        this.localmaterialwarehousingID = localmaterialwarehousingID;
    }

    public Long getLocalmaterialwarehousingID() 
    {
        return localmaterialwarehousingID;
    }
    public void setSubscriptionQuantity(Long subscriptionQuantity) 
    {
        this.subscriptionQuantity = subscriptionQuantity;
    }

    public Long getSubscriptionQuantity() 
    {
        return subscriptionQuantity;
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
    public void setInvoiceTaxRate(String invoiceTaxRate) 
    {
        this.invoiceTaxRate = invoiceTaxRate;
    }

    public String getInvoiceTaxRate() 
    {
        return invoiceTaxRate;
    }
    public void setInvoiceType(String invoiceType) 
    {
        this.invoiceType = invoiceType;
    }

    public String getInvoiceType() 
    {
        return invoiceType;
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
    public void setSubscribeID(String subscribeID) 
    {
        this.subscribeID = subscribeID;
    }

    public String getSubscribeID() 
    {
        return subscribeID;
    }
    public void setSampleURL(String sampleURL) 
    {
        this.sampleURL = sampleURL;
    }

    public String getSampleURL() 
    {
        return sampleURL;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("warehouseEntryID", getWarehouseEntryID())
            .append("localmaterialwarehousingID", getLocalmaterialwarehousingID())
            .append("subscriptionQuantity", getSubscriptionQuantity())
            .append("name", getName())
            .append("typeName", getTypeName())
            .append("specificationsType", getSpecificationsType())
            .append("specificationModel", getSpecificationModel())
            .append("materialDensity", getMaterialDensity())
            .append("invoiceTaxRate", getInvoiceTaxRate())
            .append("invoiceType", getInvoiceType())
            .append("purchaseUnitPriceExcludingTax", getPurchaseUnitPriceExcludingTax())
            .append("purchaseUnitPriceIncludingTax", getPurchaseUnitPriceIncludingTax())
            .append("subscribeID", getSubscribeID())
            .append("sampleURL", getSampleURL())
            .toString();
    }
}
