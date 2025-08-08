package com.awise.storage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 客供材料出库详细对象 aw_DetailCustomerMaterialOutbound
 * 
 * @author awise
 * @date 2024-04-23
 */
public class AwDetailcustomermaterialoutbound extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 出库单编号 */
    @Excel(name = "出库单编号")
    private String deliveryNoteID;

    /** 材料基础信息编号 */
    @Excel(name = "材料基础信息编号")
    private String materialID;

    /** 任务编号 */
    @Excel(name = "任务编号")
    private Long productionTasksID;

    /** 工艺编号 */
    @Excel(name = "工艺编号")
    private String processingTechnologyID;

    /** 出库数量 */
    @Excel(name = "出库数量")
    private Long outboundQuantity;

    /** 备注 */
    @Excel(name = "备注")
    private String notes;

    /** 生产任务单编号 */
    @Excel(name = "生产任务单编号")
    private Long productionTasksFormID;

    /** 材料名称 */
    @Excel(name = "材料名称")
    private String name;

    /** 备注信息 */
    @Excel(name = "材料价格")
    private String materialPrice;

    /** 材料密度#校验大于0，用于工艺下料后自动计算重量。规格类型确定了重量计算公式。材料计数单位都以kg计，材料密度单位为kg/mm^3，材料尺寸单位为mm# */
    @Excel(name = "材料密度#校验大于0")
    private String materialDensity;

    /** 类别名称 */
    @Excel(name = "类别名称")
    private String typeName;

    /** 规格类型 */
    @Excel(name = "规格类型")
    private String specificationsType;

    /** 规格型号 */
    @Excel(name = "规格型号")
    private String specificationModel;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDeliveryNoteID(String deliveryNoteID) 
    {
        this.deliveryNoteID = deliveryNoteID;
    }

    public String getDeliveryNoteID() 
    {
        return deliveryNoteID;
    }
    public void setMaterialID(String materialID) 
    {
        this.materialID = materialID;
    }

    public String getMaterialID() 
    {
        return materialID;
    }
    public void setProductionTasksID(Long productionTasksID) 
    {
        this.productionTasksID = productionTasksID;
    }

    public Long getProductionTasksID() 
    {
        return productionTasksID;
    }
    public void setProcessingTechnologyID(String processingTechnologyID) 
    {
        this.processingTechnologyID = processingTechnologyID;
    }

    public String getProcessingTechnologyID() 
    {
        return processingTechnologyID;
    }
    public void setOutboundQuantity(Long outboundQuantity) 
    {
        this.outboundQuantity = outboundQuantity;
    }

    public Long getOutboundQuantity() 
    {
        return outboundQuantity;
    }
    public void setNotes(String notes) 
    {
        this.notes = notes;
    }

    public String getNotes() 
    {
        return notes;
    }
    public void setProductionTasksFormID(Long productionTasksFormID) 
    {
        this.productionTasksFormID = productionTasksFormID;
    }

    public Long getProductionTasksFormID() 
    {
        return productionTasksFormID;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setMaterialPrice(String materialPrice) 
    {
        this.materialPrice = materialPrice;
    }

    public String getMaterialPrice() 
    {
        return materialPrice;
    }
    public void setMaterialDensity(String materialDensity) 
    {
        this.materialDensity = materialDensity;
    }

    public String getMaterialDensity() 
    {
        return materialDensity;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deliveryNoteID", getDeliveryNoteID())
            .append("materialID", getMaterialID())
            .append("productionTasksID", getProductionTasksID())
            .append("processingTechnologyID", getProcessingTechnologyID())
            .append("outboundQuantity", getOutboundQuantity())
            .append("notes", getNotes())
            .append("productionTasksFormID", getProductionTasksFormID())
            .append("name", getName())
            .append("materialPrice", getMaterialPrice())
            .append("materialDensity", getMaterialDensity())
            .append("typeName", getTypeName())
            .append("specificationsType", getSpecificationsType())
            .append("specificationModel", getSpecificationModel())
            .toString();
    }
}
