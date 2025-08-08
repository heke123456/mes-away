package com.awise.storage.domain.Vo;

import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;
import com.awise.storage.domain.AwMatlwarehousingdet;
import com.awise.storage.domain.MaterialWarehousingDetailed;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.List;

/**
 * 入库单对象 aw_warehousing
 * 
 * @author ruoyi
 * @date 2023-10-14
 */
public class AwWarehousingVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 入库单编号 */

    @Excel(name = "入库单编号",needMerge = true)
    private String warehouseEntryID;

    /** 入库日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")

    @Excel(name = "入库日期", width = 30, dateFormat = "yyyy-MM-dd",needMerge = true)
    private Date warehousingDate;

    /** 制单人 */
    @Excel(name = "制单人",needMerge = true)
    private String creator;

    /** 验收人 */
    @Excel(name = "验收人",needMerge = true)
    private String acceptedBy;

    /** 库管员 */
    @Excel(name = "库管员",needMerge = true)
    private String warehouseKeeper;

    /** 经办人 */
    @Excel(name = "经办人",needMerge = true)
    private String operator;

    /** 备注 */
    @Excel(name = "备注",needMerge = true)
    private String notes;

    /** 状态 */
    @Excel(name = "状态" ,dictType="aw_storage_warehousing_status",needMerge = true)
    private String status;

    @Excel(name = "材料入库列表")
    private List<AwMatlwarehousingdet> awMatlwarehousingdetList;

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
    public void setAcceptedBy(String acceptedBy) 
    {
        this.acceptedBy = acceptedBy;
    }

    public String getAcceptedBy() 
    {
        return acceptedBy;
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

    public List<AwMatlwarehousingdet> getAwMatlwarehousingdetList() {
        return awMatlwarehousingdetList;
    }

    public void setAwMatlwarehousingdetList(List<AwMatlwarehousingdet> awMatlwarehousingdetList) {
        this.awMatlwarehousingdetList = awMatlwarehousingdetList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("warehouseEntryID", getWarehouseEntryID())
            .append("warehousingDate", getWarehousingDate())
            .append("creator", getCreator())
            .append("acceptedBy", getAcceptedBy())
            .append("warehouseKeeper", getWarehouseKeeper())
            .append("operator", getOperator())
            .append("notes", getNotes())
            .append("status", getStatus())
            .toString();
    }
}
