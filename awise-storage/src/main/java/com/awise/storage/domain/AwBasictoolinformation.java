package com.awise.storage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * BasicToolInformation对象 aw_BasicToolInformation
 * 
 * @author awise
 * @date 2023-12-06
 */
public class AwBasictoolinformation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 刀具编号 */
    private String id;

    /** 刀具名称 */
    @Excel(name = "刀具名称")
    private String name;


    @Excel(name = "刀具价格")
    private String toolPrice;

    /** 刀具分类 */
    @Excel(name = "刀具分类")
    private Long typeID;

    /** 刀具规格 */
    @Excel(name = "刀具规格")
    private Long specificationsID;

    /** 计量单位id */
    @Excel(name = "计量单位id")
    private Long unitID;

    /** 备注信息 */


    /** 类别名称 */
    @Excel(name = "类别名称")
    private String typeName;

    /** 计量单位 */
    @Excel(name = "计量单位")
    private String uint;

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
    public void setUnitID(Long unitID) 
    {
        this.unitID = unitID;
    }

    public Long getUnitID() 
    {
        return unitID;
    }

    public void setTypeName(String typeName) 
    {
        this.typeName = typeName;
    }

    public String getTypeName() 
    {
        return typeName;
    }
    public void setUint(String uint) 
    {
        this.uint = uint;
    }

    public String getUint() 
    {
        return uint;
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

    public String getToolPrice() {
        return toolPrice;
    }

    public void setToolPrice(String toolPrice) {
        this.toolPrice = toolPrice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("toolPrice", getToolPrice())
            .append("typeID", getTypeID())
            .append("specificationsID", getSpecificationsID())
            .append("unitID", getUnitID())
            .append("typeName", getTypeName())
            .append("uint", getUint())
            .append("specificationsType", getSpecificationsType())
            .append("specificationModel", getSpecificationModel())
            .toString();
    }
}
