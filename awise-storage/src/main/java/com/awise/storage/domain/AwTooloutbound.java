package com.awise.storage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 刀具出库对象 aw_ToolOutbound
 * 
 * @author awise
 * @date 2023-12-08
 */
public class AwTooloutbound extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 刀具出库id */
    private Long id;

    /** 出库单编号 */
    @Excel(name = "出库单编号")
    private String deliveryNoteID;

    /** 刀具基本信息编号 */
    @Excel(name = "刀具基本信息编号")
    private String toolInformationID;

    /** 出库数量 */
    @Excel(name = "出库数量")
    private Long outboundQuantity;

    /** 新旧类型 */
    @Excel(name = "新旧类型")
    private String newAndOldTypes;

    /** 领用用途 */
    @Excel(name = "领用用途")
    private String materialRequisition;

    /** 备注 */
    @Excel(name = "备注")
    private String notes;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDeliveryNoteID(String deliveryNoteID) 
    {
        this.deliveryNoteID = deliveryNoteID;
    }

    public String getDeliveryNoteID() 
    {
        return deliveryNoteID;
    }
    public void setToolInformationID(String toolInformationID) 
    {
        this.toolInformationID = toolInformationID;
    }

    public String getToolInformationID() 
    {
        return toolInformationID;
    }
    public void setOutboundQuantity(Long outboundQuantity) 
    {
        this.outboundQuantity = outboundQuantity;
    }

    public Long getOutboundQuantity() 
    {
        return outboundQuantity;
    }
    public void setNewAndOldTypes(String newAndOldTypes) 
    {
        this.newAndOldTypes = newAndOldTypes;
    }

    public String getNewAndOldTypes() 
    {
        return newAndOldTypes;
    }
    public void setMaterialRequisition(String materialRequisition) 
    {
        this.materialRequisition = materialRequisition;
    }

    public String getMaterialRequisition() 
    {
        return materialRequisition;
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
            .append("deliveryNoteID", getDeliveryNoteID())
            .append("toolInformationID", getToolInformationID())
            .append("outboundQuantity", getOutboundQuantity())
            .append("newAndOldTypes", getNewAndOldTypes())
            .append("materialRequisition", getMaterialRequisition())
            .append("notes", getNotes())
            .toString();
    }
}
