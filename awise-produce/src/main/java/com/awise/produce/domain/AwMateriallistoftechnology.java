package com.awise.produce.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 需求材料对象 aw_MaterialListOfTechnology
 * 
 * @author awise
 * @date 2023-10-15
 */
public class AwMateriallistoftechnology extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @Excel(name = "id")
    private Long id;

    /** 材料基础信息编号 */
    private String materialID;

    /** 工艺编号 */
    private String processingTechnologyID;

    /** 材料名称 */
    @Excel(name = "材料名称")
    private String name;

    @Excel(name = "材料价格")
    private String materialPrice;

    /** 材料密度 */
    @Excel(name = "材料密度")
    private String materialDensity;

    /** 类别名称 */
    @Excel(name = "类别名称")
    private String typeName;

    /** 规格类型 */
    private String specificationsType;

    /** 规格型号 */
    @Excel(name = "规格型号")
    private String specificationModel;

    /** 下料尺寸 */
    @Excel(name = "下料尺寸")
    private String cuttingSize;

    /** 可制件数 */
    @Excel(name = "可制件数")
    private String numberProducibleParts;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMaterialID(String materialID) 
    {
        this.materialID = materialID;
    }

    public String getMaterialID() 
    {
        return materialID;
    }
    public void setProcessingTechnologyID(String processingTechnologyID) 
    {
        this.processingTechnologyID = processingTechnologyID;
    }

    public String getProcessingTechnologyID() 
    {
        return processingTechnologyID;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
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
    public void setCuttingSize(String cuttingSize)
    {
        this.cuttingSize = cuttingSize;
    }

    public String getCuttingSize()
    {
        return cuttingSize;
    }
    public void setNumberProducibleParts(String numberProducibleParts) 
    {
        this.numberProducibleParts = numberProducibleParts;
    }

    public String getNumberProducibleParts() 
    {
        return numberProducibleParts;
    }

    public String getMaterialPrice() {
        return materialPrice;
    }

    public void setMaterialPrice(String materialPrice) {
        this.materialPrice = materialPrice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("materialID", getMaterialID())
            .append("processingTechnologyID", getProcessingTechnologyID())
            .append("name", getName())
            .append("materialPrice", getMaterialPrice())
            .append("materialDensity", getMaterialDensity())
            .append("typeName", getTypeName())
            .append("specificationsType", getSpecificationsType())
            .append("specificationModel", getSpecificationModel())
            .append("cuttingSize", getCuttingSize())
            .append("numberProducibleParts", getNumberProducibleParts())
            .toString();
    }
}
