package com.awise.storage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 本地材料入库对象 aw_localmaterialwarehousing
 * 
 * @author ruoyi
 * @date 2023-10-14
 */
public class AwLocalmaterialwarehousing extends BaseEntity
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

    /** 发票信息编号 */
    @Excel(name = "发票信息编号")
    private String receiptInvoiceID;

    /** 材料基础信息编号 */
    @Excel(name = "材料基础信息编号")
    private String materialID;

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
    public void setReceiptInvoiceID(String receiptInvoiceID) 
    {
        this.receiptInvoiceID = receiptInvoiceID;
    }

    public String getReceiptInvoiceID() 
    {
        return receiptInvoiceID;
    }
    public void setMaterialID(String materialID) 
    {
        this.materialID = materialID;
    }

    public String getMaterialID() 
    {
        return materialID;
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
            .append("warehouseEntryID", getWarehouseEntryID())
            .append("materialSubscription", getMaterialSubscription())
            .append("receiptInvoiceID", getReceiptInvoiceID())
            .append("materialID", getMaterialID())
            .append("receiptQuantity", getReceiptQuantity())
            .append("sampleURL", getSampleURL())
            .append("notes", getNotes())
            .toString();
    }
}
