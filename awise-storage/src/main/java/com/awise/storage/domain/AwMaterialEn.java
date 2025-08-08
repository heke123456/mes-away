package com.awise.storage.domain;

import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 材料基本信息对象 aw_material
 * 
 * @author awise
 * @date 2023-08-02
 */
public class AwMaterialEn extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 材料编号 */
    private String id;

    /** 材料名称 */
    @Excel(name = "材料名称")
    private String name;

    /** 材料分类 */
    @Excel(name = "材料分类")
    private String type;

    /** 规格类型 */
    @Excel(name = "规格类型")
    private String specification;

    /** 规格型号 */
    @Excel(name = "规格型号")
    private String specificationModel;

    /** 材料密度 */
    @Excel(name = "材料密度")
    private String materialDensity;

    /** 备注信息 */
    @Excel(name = "材料价格")
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

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getSpecificationModel() {
        return specificationModel;
    }

    public void setSpecificationModel(String specificationModel) {
        this.specificationModel = specificationModel;
    }

    public String getMaterialDensity() {
        return materialDensity;
    }

    public void setMaterialDensity(String materialDensity) {
        this.materialDensity = materialDensity;
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
            .append("type", getType())
            .append("specification", getSpecification())
            .append("specificationModel", getSpecificationModel())
            .append("materialDensity", getMaterialDensity())
            .append("notes", getNotes())
            .toString();
    }
}
