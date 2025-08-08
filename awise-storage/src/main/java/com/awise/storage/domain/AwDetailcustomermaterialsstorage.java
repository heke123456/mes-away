package com.awise.storage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 客供材料入库详细对象 aw_DetailCustomerMaterialsStorage
 * 
 * @author awise
 * @date 2024-04-21
 */
public class AwDetailcustomermaterialsstorage extends BaseEntity
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
    private String receiptQuantity;

    /** 附样 */
    @Excel(name = "附样")
    private String sampleURL;

    /** 备注 */
    @Excel(name = "备注")
    private String notes;

    /** 材料名称 */
    @Excel(name = "材料名称")
    private String materialName;

    /** 材料分类 */
    @Excel(name = "材料分类")
    private Long typeID;

    /** 规格类型 */
    @Excel(name = "规格类型")
    private Long specificationsID;

    /** 材料密度 */
    @Excel(name = "材料密度")
    private String materialDensity;

    /** 材料价格 */
    @Excel(name = "材料价格")
    private String materialPrice;

    /** 类别名称 */
    @Excel(name = "类别名称")
    private String typeName;

    /** 规格类型 */
    @Excel(name = "规格类型")
    private String specificationsType;

    /** 规格型号 */
    @Excel(name = "规格型号")
    private String specificationModel;

    /** 实体姓名 */
    @Excel(name = "实体姓名")
    private String partnerName;

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
    public void setReceiptQuantity(String receiptQuantity) 
    {
        this.receiptQuantity = receiptQuantity;
    }

    public String getReceiptQuantity() 
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
    public void setMaterialName(String materialName) 
    {
        this.materialName = materialName;
    }

    public String getMaterialName() 
    {
        return materialName;
    }
    public void setTypeID(Long typeID) 
    {
        this.typeID = typeID;
    }

    public Long getTypeID() 
    {
        return typeID;
    }
    public void setSpecificationsID(Long specificationsID) 
    {
        this.specificationsID = specificationsID;
    }

    public Long getSpecificationsID() 
    {
        return specificationsID;
    }
    public void setMaterialDensity(String materialDensity) 
    {
        this.materialDensity = materialDensity;
    }

    public String getMaterialDensity() 
    {
        return materialDensity;
    }
    public void setMaterialPrice(String materialPrice) 
    {
        this.materialPrice = materialPrice;
    }

    public String getMaterialPrice() 
    {
        return materialPrice;
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
    public void setPartnerName(String partnerName) 
    {
        this.partnerName = partnerName;
    }

    public String getPartnerName() 
    {
        return partnerName;
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
            .append("materialName", getMaterialName())
            .append("typeID", getTypeID())
            .append("specificationsID", getSpecificationsID())
            .append("materialDensity", getMaterialDensity())
            .append("materialPrice", getMaterialPrice())
            .append("typeName", getTypeName())
            .append("specificationsType", getSpecificationsType())
            .append("specificationModel", getSpecificationModel())
            .append("partnerName", getPartnerName())
            .toString();
    }
}
