package com.awise.storage.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 刀具出库单对象 aw_ToolOutboundOrder
 * 
 * @author awise
 * @date 2023-12-08
 */
public class AwTooloutboundorder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 出库单编号 */
    @Excel(name = "出库单编号")
    private String deliveryNoteID;

    /** 出库日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出库日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deliveryDate;

    /** 制单人 */
    @Excel(name = "制单人")
    private String creator;

    /** 发料人 */
    @Excel(name = "发料人")
    private String issuedBy;

    /** 领料人 */
    @Excel(name = "领料人")
    private String materialReceiver;

    /** 审批人 */
    @Excel(name = "审批人")
    private String approver;

    /** 备注 */
    @Excel(name = "备注")
    private String notes;

    /** 状态 */
    @Excel(name = "状态" ,dictType = "aw_storage_outboundorder_status" )
    private String status;

    public void setDeliveryNoteID(String deliveryNoteID) 
    {
        this.deliveryNoteID = deliveryNoteID;
    }

    public String getDeliveryNoteID() 
    {
        return deliveryNoteID;
    }
    public void setDeliveryDate(Date deliveryDate) 
    {
        this.deliveryDate = deliveryDate;
    }

    public Date getDeliveryDate() 
    {
        return deliveryDate;
    }
    public void setCreator(String creator) 
    {
        this.creator = creator;
    }

    public String getCreator() 
    {
        return creator;
    }
    public void setIssuedBy(String issuedBy) 
    {
        this.issuedBy = issuedBy;
    }

    public String getIssuedBy() 
    {
        return issuedBy;
    }
    public void setMaterialReceiver(String materialReceiver) 
    {
        this.materialReceiver = materialReceiver;
    }

    public String getMaterialReceiver() 
    {
        return materialReceiver;
    }
    public void setApprover(String approver) 
    {
        this.approver = approver;
    }

    public String getApprover() 
    {
        return approver;
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
            .append("deliveryNoteID", getDeliveryNoteID())
            .append("deliveryDate", getDeliveryDate())
            .append("creator", getCreator())
            .append("issuedBy", getIssuedBy())
            .append("materialReceiver", getMaterialReceiver())
            .append("approver", getApprover())
            .append("notes", getNotes())
            .append("status", getStatus())
            .toString();
    }
}
