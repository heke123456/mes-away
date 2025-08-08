package com.awise.storage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 客供入库详细对象 aw_detailcsmtdmtlsstinw
 * 
 * @author awise
 * @date 2023-12-26
 */
public class AwDetailcsmtdmtlsstinw extends BaseEntity
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

    /** 材料名称 */
    @Excel(name = "材料名称")
    private String materialName;

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
    @Excel(name = "资料附件")
    private String dataAttachment;

    /** 入库数量 */
    @Excel(name = "入库数量")
    private Long receiptQuantity;

    /** 生产任务单编号 */
    @Excel(name = "生产任务单编号")
    private Long productionTasksFormID;

    /** 任务编号 */
    @Excel(name = "任务编号")
    private Long productionTasksID;

    /** 客户信息 */
    private String customerID;

    /** 实体姓名 */
    @Excel(name = "实体姓名")
    private String customername;

    /** 产品信息 */
    private String productID;

    /** 产品名称 */
    private String productName;

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
    public void setMaterialName(String materialName) 
    {
        this.materialName = materialName;
    }

    public String getMaterialName() 
    {
        return materialName;
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
    public void setProductionTasksFormID(Long productionTasksFormID) 
    {
        this.productionTasksFormID = productionTasksFormID;
    }

    public Long getProductionTasksFormID() 
    {
        return productionTasksFormID;
    }
    public void setProductionTasksID(Long productionTasksID) 
    {
        this.productionTasksID = productionTasksID;
    }

    public Long getProductionTasksID() 
    {
        return productionTasksID;
    }
    public void setCustomerID(String customerID) 
    {
        this.customerID = customerID;
    }

    public String getCustomerID() 
    {
        return customerID;
    }
    public void setCustomername(String customername) 
    {
        this.customername = customername;
    }

    public String getCustomername() 
    {
        return customername;
    }
    public void setProductID(String productID) 
    {
        this.productID = productID;
    }

    public String getProductID() 
    {
        return productID;
    }
    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public String getProductName() 
    {
        return productName;
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
            .append("materialName", getMaterialName())
            .append("mthd", getMthd())
            .append("furnaceBatchNumber", getFurnaceBatchNumber())
            .append("dataType", getDataType())
            .append("dataAttachment", getDataAttachment())
            .append("receiptQuantity", getReceiptQuantity())
            .append("productionTasksFormID", getProductionTasksFormID())
            .append("productionTasksID", getProductionTasksID())
            .append("customerID", getCustomerID())
            .append("customername", getCustomername())
            .append("productID", getProductID())
            .append("productName", getProductName())
            .append("sampleURL", getSampleURL())
            .append("notes", getNotes())
            .toString();
    }
}
