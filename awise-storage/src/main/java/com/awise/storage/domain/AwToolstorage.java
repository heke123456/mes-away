package com.awise.storage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 刀具入库对象 aw_toolStorage
 * 
 * @author awise
 * @date 2023-12-06
 */
public class AwToolstorage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 刀具入库id */
    private String id;

    /** 入库单编号 */
    @Excel(name = "入库单编号")
    private String warehouseEntryID;

    /** 发票信息编号 */
    @Excel(name = "发票信息编号")
    private String receiptInvoiceID;


    //厂商

    @Excel(name = "厂商")

    private  String manufacturers;

    /** 刀具基本信息 */
    @Excel(name = "刀具基本信息")
    private String toolInformationID;

    /** 入库数量 */
    @Excel(name = "入库数量")
    private Long receiptQuantity;

    /** 备注 */
    @Excel(name = "备注")
    private String notes;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
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


    public String getManufacturers() {
        return manufacturers;
    }

    public void setManufacturers(String manufacturers) {
        this.manufacturers = manufacturers;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("warehouseEntryID", getWarehouseEntryID())
            .append("receiptInvoiceID", getReceiptInvoiceID())
            .append("toolInformationID", getToolInformationID())
                .append("manufacturers",getManufacturers())
            .append("receiptQuantity", getReceiptQuantity())
            .append("notes", getNotes())
            .toString();
    }
}
