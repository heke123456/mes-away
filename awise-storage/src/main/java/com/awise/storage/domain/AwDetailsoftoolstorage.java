package com.awise.storage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * DetailsOfToolStorage对象 aw_DetailsOfToolStorage
 * 
 * @author awise
 * @date 2023-12-06
 */
public class AwDetailsoftoolstorage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 刀具入库id */
    @Excel(name = "刀具入库id")
    private Long id;

    /** 入库单编号 */
    @Excel(name = "入库单编号")
    private String warehouseEntryID;

    /** 发票信息编号 */
    @Excel(name = "发票信息编号")
    private String receiptInvoiceID;

    /** 刀具基本信息 */
    @Excel(name = "刀具基本信息")
    private String toolInformationID;

    /** 入库数量 */
    @Excel(name = "入库数量")
    private Long receiptQuantity;

    /** 备注 */
    @Excel(name = "备注")
    private String notes;

    /** 发票税率 */


    /** 刀具名称 */
    @Excel(name = "刀具名称")
    private String name;


    /** 刀具价格 */
    @Excel(name = "刀具价格")
    private String toolPrice;

//    厂商

    @Excel(name = "厂商")
    private String manufacturers;

    /** 类别名称 */
    @Excel(name = "类别名称")
    private String typeName;

    /** 规格类型 */
    @Excel(name = "规格类型")
    private String specificationsType;
    /** 规格型号 */
    @Excel(name = "规格型号")
    private String specificationModel;

    /** 计量单位 */
    @Excel(name = "计量单位")
    private String uint;


    public String getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(String manufacturers) {
        this.manufacturers = manufacturers;
    }

    public String getToolPrice() {
        return toolPrice;
    }

    public void setToolPrice(String toolPrice) {
        this.toolPrice = toolPrice;
    }

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
    public void setReceiptInvoiceID(String receiptInvoiceID) 
    {
        this.receiptInvoiceID = receiptInvoiceID;
    }

    public String getReceiptInvoiceID() 
    {
        return receiptInvoiceID;
    }
    public void setToolInformationID(String toolInformationID) 
    {
        this.toolInformationID = toolInformationID;
    }

    public String getToolInformationID() 
    {
        return toolInformationID;
    }
    public void setReceiptQuantity(Long receiptQuantity) 
    {
        this.receiptQuantity = receiptQuantity;
    }

    public Long getReceiptQuantity() 
    {
        return receiptQuantity;
    }
    public void setNotes(String notes) 
    {
        this.notes = notes;
    }

    public String getNotes() 
    {
        return notes;
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
    public void setUint(String uint) 
    {
        this.uint = uint;
    }

    public String getUint() 
    {
        return uint;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("warehouseEntryID", getWarehouseEntryID())
            .append("receiptInvoiceID", getReceiptInvoiceID())
            .append("toolInformationID", getToolInformationID())
            .append("receiptQuantity", getReceiptQuantity())
            .append("notes", getNotes())
            .append("manufacturers", getManufacturers())
            .append("name", getName())
            .append("toolPrice", getToolPrice())
            .append("typeName", getTypeName())
            .append("specificationsType", getSpecificationsType())
            .append("specificationModel", getSpecificationModel())
            .append("uint", getUint())
            .toString();
    }
}
