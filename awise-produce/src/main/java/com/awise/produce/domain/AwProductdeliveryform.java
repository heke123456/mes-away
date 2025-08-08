package com.awise.produce.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 产品出库单对象 aw_productdeliveryform
 * 
 * @author awise
 * @date 2023-10-14
 */
public class AwProductdeliveryform extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 出库单编号 */
    @Excel(name = "出库单编号")
    private String deliveryNoteID;

    /** 出库日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出库日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date warehousingDate;

    /** 制单人 */
    @Excel(name = "制单人")
    private String creator;

    /** 库管员 */
    @Excel(name = "库管员")
    private String warehouseKeeper;

    /** 备注 */
    @Excel(name = "备注")
    private String notes;

    /** 状态 */
    @Excel(name = "状态",dictType = "aw_produce_productdeliveryform_status")
    private String status;

    public void setDeliveryNoteID(String deliveryNoteID) 
    {
        this.deliveryNoteID = deliveryNoteID;
    }

    public String getDeliveryNoteID() 
    {
        return deliveryNoteID;
    }
    public void setWarehousingDate(Date warehousingDate) 
    {
        this.warehousingDate = warehousingDate;
    }

    public Date getWarehousingDate() 
    {
        return warehousingDate;
    }
    public void setCreator(String creator) 
    {
        this.creator = creator;
    }

    public String getCreator() 
    {
        return creator;
    }
    public void setWarehouseKeeper(String warehouseKeeper) 
    {
        this.warehouseKeeper = warehouseKeeper;
    }

    public String getWarehouseKeeper() 
    {
        return warehouseKeeper;
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
            .append("warehousingDate", getWarehousingDate())
            .append("creator", getCreator())
            .append("warehouseKeeper", getWarehouseKeeper())
            .append("notes", getNotes())
            .append("status", getStatus())
            .toString();
    }
}
