package com.awise.storage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 客供材料实时库存对象 aw_CustomerMaterialsInventory
 * 
 * @author awise
 * @date 2024-04-22
 */
public class AwCustomermaterialsinventory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 材料库存id */
    private Long id;

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
            .append("materialID", getMaterialID())
            .append("number", getNumber())
            .append("weight", getWeight())
            .toString();
    }
}
