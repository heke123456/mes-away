package com.awise.storage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 材料分类对象 aw_materialclassification
 * 
 * @author awise
 * @date 2023-08-02
 */
public class AwMaterialclassification extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 类别编号 */
    private Long id;

    /** 类别名称 */
    @Excel(name = "类别名称")
    private String name;

    /** 备注信息 */
    @Excel(name = "备注信息")
    private String notes;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
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
            .append("notes", getNotes())
            .toString();
    }
}
