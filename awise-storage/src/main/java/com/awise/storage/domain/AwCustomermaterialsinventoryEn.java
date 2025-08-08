package com.awise.storage.domain;

import com.away.common.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class AwCustomermaterialsinventoryEn {

    private static final long serialVersionUID = 1L;

    /** 材料库存id */
    private Long id;

    @Excel(name = "材料ID")
    private String materialID;

    /** 材料基本信息id */
    @Excel(name = "材料名称")
    private String name;

    @Excel(name = "材料价格")
    private String notes;

    /** 材料库存数量 */
    @Excel(name = "材料库存数量")
    private Long number;

    /** 材料库存重量 */
    @Excel(name = "材料库存重量")
    private Long weight;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getMaterialID() {
        return materialID;
    }

    public void setMaterialID(String materialID) {
        this.materialID = materialID;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("notes", getNotes())
                .append("materialID", getMaterialID())
                .append("number", getNumber())
                .append("weight", getWeight())
                .toString();
    }
}
