package com.awise.produce.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 产品入库对象 aw_productstorage
 * 
 * @author awise
 * @date 2023-10-16
 */
public class AwProductstorage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 产品入库单编号 */
    @Excel(name = "产品入库单编号")
    private String warehouseEntryID;

    /** 产品图号 */
    @Excel(name = "产品图号")
    private String productID;

    /** 成品检验编号 */
    @Excel(name = "成品检验编号")
    private String FinishedProductInspectionID;

    /** 入库数量 */
    @Excel(name = "入库数量")
    private Long receiptQuantity;

    /** 备注 */
    @Excel(name = "备注")
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
    public void setProductID(String productID) 
    {
        this.productID = productID;
    }

    public String getProductID() 
    {
        return productID;
    }
    public void setFinishedProductInspectionID(String FinishedProductInspectionID) 
    {
        this.FinishedProductInspectionID = FinishedProductInspectionID;
    }

    public String getFinishedProductInspectionID() 
    {
        return FinishedProductInspectionID;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("warehouseEntryID", getWarehouseEntryID())
            .append("productID", getProductID())
            .append("FinishedProductInspectionID", getFinishedProductInspectionID())
            .append("receiptQuantity", getReceiptQuantity())
            .append("notes", getNotes())
            .toString();
    }
}
