package com.awise.storage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 计量单位对象 aw_units
 * 
 * @author ruoyi
 * @date 2023-07-27
 */
public class AwUnits extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 计量单位id */
    @Excel(name = "计量单位id")
    private Long id;

    /** 计量单位 */
    @Excel(name = "计量单位")
    private String unit;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("unit", getUnit())
            .toString();
    }
}
