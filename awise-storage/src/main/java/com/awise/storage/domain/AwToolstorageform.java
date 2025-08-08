package com.awise.storage.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 刀具入库单对象 aw_toolStorageform
 * 
 * @author awise
 * @date 2023-12-06
 */
public class AwToolstorageform extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 入库单编号 */
    @Excel(name = "入库单编号")
    private String warehouseEntryID;

    /** 入库日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入库日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date warehousingDate;

    /** 制单人 */
    @Excel(name = "制单人")
    private String creator;

    /** 库房员 */
    @Excel(name = "库房员")
    private String warehouseKeeper;

    /** 经办人 */
    @Excel(name = "经办人")
    private String operator;

    /** 备注 */
    @Excel(name = "备注")
    private String notes;

    /** 状态 */
    @Excel(name = "状态" ,dictType = "aw_storage_warehousing_status")
    private String status;

    public void setWarehouseEntryID(String warehouseEntryID) 
    {
        this.warehouseEntryID = warehouseEntryID;
    }

    public String getWarehouseEntryID() 
    {
        return warehouseEntryID;
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
    public void setOperator(String operator) 
    {
        this.operator = operator;
    }

    public String getOperator() 
    {
        return operator;
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
            .append("warehouseEntryID", getWarehouseEntryID())
            .append("warehousingDate", getWarehousingDate())
            .append("creator", getCreator())
            .append("warehouseKeeper", getWarehouseKeeper())
            .append("operator", getOperator())
            .append("notes", getNotes())
            .append("status", getStatus())
            .toString();
    }
}
