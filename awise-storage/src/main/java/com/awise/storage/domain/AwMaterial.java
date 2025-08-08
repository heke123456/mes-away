package com.awise.storage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

import java.util.Objects;

/**
 * 材料基本信息对象 aw_material
 * 
 * @author awise
 * @date 2023-08-02
 */
public class AwMaterial extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 材料编号 */
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

    /** 材料密度#校验大于0，用于工艺下料后自动计算重量。规格类型确定了重量计算公式。材料计数单位都以kg计，材料密度单位为kg/mm^3，材料尺寸单位为mm# */
    @Excel(name = "材料密度#校验大于0，用于工艺下料后自动计算重量。规格类型确定了重量计算公式。材料计数单位都以kg计，材料密度单位为kg/mm^3，材料尺寸单位为mm#")
    private String materialDensity;

    /** 备注信息 */
    @Excel(name = "价格")
    private String notes;

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
            .append("name", getName())
            .append("typeID", getTypeID())
            .append("specificationsID", getSpecificationsID())
            .append("materialDensity", getMaterialDensity())
            .append("notes", getNotes())
            .toString();
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AwMaterial other = (AwMaterial) obj;
        return
                Objects.equals(this.notes, other.notes) &&
                Objects.equals(this.name, other.name);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
