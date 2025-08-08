package com.awise.produce.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 生产任务单对象 aw_productiontasklist
 * 
 * @author awise
 * @date 2023-09-27
 */
public class AwProductiontasklist extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 生产任务单编号 */
    private Long id;

    /** 简称 */
    @Excel(name = "简称")
    private String referred;

    /** 制单人 */
    @Excel(name = "制单人")
    private String founder;

    /** 备注信息 */
    @Excel(name = "备注信息")
    private String notes;

    /** 状态 */
    @Excel(name = "状态",dictType="aw_produce_form_status")
    private String status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setReferred(String referred) 
    {
        this.referred = referred;
    }

    public String getReferred() 
    {
        return referred;
    }
    public void setFounder(String founder) 
    {
        this.founder = founder;
    }

    public String getFounder() 
    {
        return founder;
    }
    public void setNotes(String notes) 
    {
        this.notes = notes;
    }

    public String getNotes() 
    {
        return notes;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("referred", getReferred())
            .append("founder", getFounder())
            .append("createTime", getCreateTime())
            .append("notes", getNotes())
            .append("status", getStatus())
            .toString();
    }
}
