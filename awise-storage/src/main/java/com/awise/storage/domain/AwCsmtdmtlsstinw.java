package com.awise.storage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 客供材料入库对象 aw_csmtdmtlsstinw
 * 
 * @author awise
 * @date 2023-12-26
 */
public class AwCsmtdmtlsstinw extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 入库单编号 */
    @Excel(name = "入库单编号")
    private String warehouseEntryID;

    /** 材料信息编号 */
    @Excel(name = "材料信息编号")
    private String materialID;

    /** 化验号 */
    @Excel(name = "化验号")
    private String mthd;

    /** 炉批号 */
    @Excel(name = "炉批号")
    private String furnaceBatchNumber;

    /** 资料类型 */
    @Excel(name = "资料类型")
    private String dataType;

    /** 资料附件 */
    private String dataAttachment;

    /** 入库数量 */
    @Excel(name = "入库数量")
    private Long receiptQuantity;

    /** 任务编号 */
    @Excel(name = "任务编号")
    private Long productionTasksID;

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
    public void setMaterialID(String materialID) 
    {
        this.materialID = materialID;
    }

    public String getMaterialID() 
    {
        return materialID;
    }
    public void setMthd(String mthd) 
    {
        this.mthd = mthd;
    }

    public String getMthd() 
    {
        return mthd;
    }
    public void setFurnaceBatchNumber(String furnaceBatchNumber) 
    {
        this.furnaceBatchNumber = furnaceBatchNumber;
    }

    public String getFurnaceBatchNumber() 
    {
        return furnaceBatchNumber;
    }
    public void setDataType(String dataType) 
    {
        this.dataType = dataType;
    }

    public String getDataType() 
    {
        return dataType;
    }
    public void setDataAttachment(String dataAttachment) 
    {
        this.dataAttachment = dataAttachment;
    }

    public String getDataAttachment() 
    {
        return dataAttachment;
    }
    public void setReceiptQuantity(Long receiptQuantity) 
    {
        this.receiptQuantity = receiptQuantity;
    }

    public Long getReceiptQuantity() 
    {
        return receiptQuantity;
    }
    public void setProductionTasksID(Long productionTasksID) 
    {
        this.productionTasksID = productionTasksID;
    }

    public Long getProductionTasksID() 
    {
        return productionTasksID;
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
            .append("materialID", getMaterialID())
            .append("mthd", getMthd())
            .append("furnaceBatchNumber", getFurnaceBatchNumber())
            .append("dataType", getDataType())
            .append("dataAttachment", getDataAttachment())
            .append("receiptQuantity", getReceiptQuantity())
            .append("productionTasksID", getProductionTasksID())
            .append("sampleURL", getSampleURL())
            .append("notes", getNotes())
            .toString();
    }
}
