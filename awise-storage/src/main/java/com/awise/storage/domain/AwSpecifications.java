package com.awise.storage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 规格类型对象 aw_specifications
 * 
 * @author awise
 * @date 2023-08-01
 */
public class AwSpecifications extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 规格类型id */
    private Long id;

    /** 规格类型 */
    @Excel(name = "规格类型")
    private String type;

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
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
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
            .append("type", getType())
            .append("specificationModel", getSpecificationModel())
            .toString();
    }
}
