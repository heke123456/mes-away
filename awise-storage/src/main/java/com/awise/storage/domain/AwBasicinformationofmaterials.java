package com.awise.storage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 材料信息详细单对象 aw_basicinformationofmaterials
 * 
 * @author awise
 * @date 2023-10-15
 */
public class AwBasicinformationofmaterials extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 材料编号 */
    @Excel(name = "材料编号")
    private String id;

    /** 材料名称 */
    @Excel(name = "材料名称")
    private String name;

    /** 材料分类 */
    @Excel(name = "材料分类")
    private Long typeID;

    /** 规格类型 */
    @Excel(name = "规格类型")
    private Long specificationsID;

    /** 材料密度 */
    @Excel(name = "材料密度")
    private String materialDensity;

    /** 备注信息 */
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

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
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

    public String getMaterialPrice() {
        return materialPrice;
    }

    public void setMaterialPrice(String materialPrice) {
        this.materialPrice = materialPrice;
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
            .append("name", getName())
            .append("typeID", getTypeID())
            .append("specificationsID", getSpecificationsID())
            .append("materialDensity", getMaterialDensity())
            .append("notes", getMaterialPrice())
            .append("typeName", getTypeName())
            .append("specificationsType", getSpecificationsType())
            .append("specificationModel", getSpecificationModel())
            .toString();
    }
}
