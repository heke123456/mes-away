package com.awise.storage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 刀具库存对象 aw_LocalTool
 * 
 * @author awise
 * @date 2023-12-21
 */
public class AwLocaltool extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 库存id */
    private Long id;

    /** 刀具id */
    @Excel(name = "刀具id")
    private String toolInformationID;

    /** 数量 */
    @Excel(name = "数量")
    private Long number;

    /** 重量 */
    @Excel(name = "重量")
    private Long weight;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setToolInformationID(String toolInformationID) 
    {
        this.toolInformationID = toolInformationID;
    }

    public String getToolInformationID() 
    {
        return toolInformationID;
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
            .append("toolInformationID", getToolInformationID())
            .append("number", getNumber())
            .append("weight", getWeight())
            .toString();
    }
}
