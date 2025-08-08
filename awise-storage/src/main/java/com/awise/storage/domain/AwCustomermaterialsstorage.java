package com.awise.storage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 客供入库对象 aw_CustomerMaterialsStorage
 * 
 * @author awise
 * @date 2024-04-21
 */
public class AwCustomermaterialsstorage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private String saleorderID;

    /** 材料基础信息编号 */
    @Excel(name = "材料基础信息编号")
    private String materialID;

    /** 入库单编号 */
    @Excel(name = "入库单编号")
    private String warehouseEntryID;

    /** 入库数量 */
    @Excel(name = "入库数量")
    private Long receiptQuantity;

    /** 附样 */
    @Excel(name = "附样")
    private String sampleURL;

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
    public void setSaleorderID(String saleorderID) 
    {
        this.saleorderID = saleorderID;
    }

    public String getSaleorderID() 
    {
        return saleorderID;
    }
    public void setMaterialID(String materialID) 
    {
        this.materialID = materialID;
    }

    public String getMaterialID() 
    {
        return materialID;
    }
    public void setWarehouseEntryID(String warehouseEntryID) 
    {
        this.warehouseEntryID = warehouseEntryID;
    }

    public String getWarehouseEntryID() 
    {
        return warehouseEntryID;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("saleorderID", getSaleorderID())
            .append("materialID", getMaterialID())
            .append("warehouseEntryID", getWarehouseEntryID())
            .append("receiptQuantity", getReceiptQuantity())
            .append("sampleURL", getSampleURL())
            .append("notes", getNotes())
            .toString();
    }
}
