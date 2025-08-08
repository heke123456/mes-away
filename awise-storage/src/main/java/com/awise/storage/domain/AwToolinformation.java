package com.awise.storage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

import javax.tools.Tool;
import java.util.List;
import java.util.Objects;

/**
 * 刀具信息对象 aw_toolinformation
 * 
 * @author awise
 * @date 2023-07-27
 */
public class AwToolinformation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 刀具编号 */
    private String id;

    /** 刀具名称 */
    @Excel(name = "刀具名称")
    private String name;

    /** 刀具分类 */
    @Excel(name = "刀具分类")
    private Long typeID;

    /** 刀具规格 */
    @Excel(name = "刀具规格")
    private Long specificationsID;

    /** 计量单位id */
    @Excel(name = "计量单位id")
    private Long unitID;

    /** 价格 */
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
    public void setUnitID(Long unitID) 
    {
        this.unitID = unitID;
    }

    public Long getUnitID() 
    {
        return unitID;
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
            .append("unitID", getUnitID())
            .append("notes", getNotes())
            .toString();
    }
    private List<AwSpecifications> aw_specifications;
    private List<AwSpecifications> awSpecifications;
    private List<AwUnits> awUnits;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        AwToolinformation other = (AwToolinformation) obj;
        return Objects.equals(name, other.name) &&
                Objects.equals(notes, other.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, notes);
    }
}
