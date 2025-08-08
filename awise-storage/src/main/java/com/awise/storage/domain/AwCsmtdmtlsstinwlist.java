package com.awise.storage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 客供材料入库单对象 aw_CsmtdmtlsstinwList
 * 
 * @author awise
 * @date 2023-12-21
 */
public class AwCsmtdmtlsstinwlist extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 入库单编号 */
    @Excel(name = "入库单编号")
    private String warehouseEntryID;


    public void setWarehouseEntryID(String warehouseEntryID) 
    {
        this.warehouseEntryID = warehouseEntryID;
    }

    public String getWarehouseEntryID() 
    {
        return warehouseEntryID;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("warehouseEntryID", getWarehouseEntryID())
            .toString();
    }
}
