package com.awise.storage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 客供材料实时库存对象 aw_customersuppliedmaterials
 * 
 * @author awise
 * @date 2023-12-27
 */
public class AwCustomersuppliedmaterials extends BaseEntity
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("saleorderID", getSaleorderID())
            .append("materialID", getMaterialID())
            .append("number", getNumber())
            .append("weight", getWeight())
            .toString();
    }
}
