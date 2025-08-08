package com.awise.storage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 客供实时库存对象 aw_CsmtInvtDetls
 * 
 * @author awise
 * @date 2023-12-27
 */
public class AwCsmtinvtdetls extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 材料库存id */
    private Long id;

    /** 销售订单编号 */
    @Excel(name = "销售订单编号")
    private String saleorderID;

    /** 材料基本信息id */
    @Excel(name = "材料基本信息id")
    private String materialID;

    /** 材料库存数量 */
    @Excel(name = "材料库存数量")
    private Long number;

    /** 材料库存重量 */
    @Excel(name = "材料库存重量")
    private Long weight;

    /** 材料名称 */
    @Excel(name = "材料名称")
    private String materianame;

    /** 类别名称 */
    @Excel(name = "类别名称")
    private String typeName;

    /** 规格类型 */
    @Excel(name = "规格类型")
    private String specificationsType;

    /** 规格型号 */
    @Excel(name = "规格型号")
    private String specificationModel;

    /** 材料密度 */
    @Excel(name = "材料密度")
    private String materialDensity;

    /** 备注信息 */
    private String notes;

    /** 实体姓名 */
    @Excel(name = "实体姓名")
    private String customname;

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
    public void setNumber(Long number) 
    {
        this.number = number;
    }

    public Long getNumber() 
    {
        return number;
    }
    public void setWeight(Long weight) 
    {
        this.weight = weight;
    }

    public Long getWeight() 
    {
        return weight;
    }
    public void setMaterianame(String materianame) 
    {
        this.materianame = materianame;
    }

    public String getMaterianame() 
    {
        return materianame;
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
    public void setCustomname(String customname) 
    {
        this.customname = customname;
    }

    public String getCustomname() 
    {
        return customname;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("saleorderID", getSaleorderID())
            .append("materialID", getMaterialID())
            .append("number", getNumber())
            .append("weight", getWeight())
            .append("materianame", getMaterianame())
            .append("typeName", getTypeName())
            .append("specificationsType", getSpecificationsType())
            .append("specificationModel", getSpecificationModel())
            .append("materialDensity", getMaterialDensity())
            .append("notes", getNotes())
            .append("customname", getCustomname())
            .toString();
    }
}
