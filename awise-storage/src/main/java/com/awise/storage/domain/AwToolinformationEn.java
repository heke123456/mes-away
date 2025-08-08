package com.awise.storage.domain;

import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 刀具信息对象 aw_toolinformation
 * 
 * @author awise
 * @date 2023-07-27
 */
public class AwToolinformationEn extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 刀具编号 */
    private String id;

    /** 刀具名称 */
    @Excel(name = "刀具名称")
    private String name;

    /** 刀具分类 */
    @Excel(name = "刀具分类")
    private String type;

    /** 刀具规格号 */
    @Excel(name = "刀具规格号")
    private String specificationModel;

    /** 刀具规格id */
    @Excel(name = "刀具规格")
    private String specification;

    /** 计量单位id */
    @Excel(name = "计量单位")
    private String unit;

    /** 备注信息 */
    @Excel(name = "备注信息")
    private String notes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSpecificationModel() {
        return specificationModel;
    }

    public void setSpecificationModel(String specificationModel) {
        this.specificationModel = specificationModel;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("specification", getSpecification())
                .append("specificationModel", getSpecificationModel())
                .append("unit", getUnit())
                .append("notes", getNotes())
                .toString();
    }

}
