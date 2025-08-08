package com.awise.order.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 外协对象 aw_outsourcingorder
 * 
 * @author awise
 * @date 2023-10-15
 */
public class AwOutsourcingorder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 外协单编号 */
    @Excel(name = "外协单编号")
    private String outsourcingOrderID;

    /** 任务单编号 */
    @Excel(name = "任务单编号")
    private Long productionTasksFormID;

    /** 任务编号 */
    @Excel(name = "任务编号")
    private Long productionTasksID;

    /** 工序编号 */
    @Excel(name = "工序编号")
    private Long processingprocessID;

    /** 委外类型 */
    @Excel(name = "委外类型",dictType = "aw_order_outsourcingorder_type")
    private String outsourcingType;

    /** 下单时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "下单时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date orderTime;

    /** 备注 */
    @Excel(name = "备注")
    private String notes;

    public void setOutsourcingOrderID(String outsourcingOrderID) 
    {
        this.outsourcingOrderID = outsourcingOrderID;
    }

    public String getOutsourcingOrderID() 
    {
        return outsourcingOrderID;
    }
    public void setProductionTasksFormID(Long productionTasksFormID) 
    {
        this.productionTasksFormID = productionTasksFormID;
    }

    public Long getProductionTasksFormID() 
    {
        return productionTasksFormID;
    }
    public void setProductionTasksID(Long productionTasksID) 
    {
        this.productionTasksID = productionTasksID;
    }

    public Long getProductionTasksID() 
    {
        return productionTasksID;
    }
    public void setProcessingprocessID(Long processingprocessID) 
    {
        this.processingprocessID = processingprocessID;
    }

    public Long getProcessingprocessID() 
    {
        return processingprocessID;
    }
    public void setOutsourcingType(String outsourcingType) 
    {
        this.outsourcingType = outsourcingType;
    }

    public String getOutsourcingType() 
    {
        return outsourcingType;
    }
    public void setOrderTime(Date orderTime) 
    {
        this.orderTime = orderTime;
    }

    public Date getOrderTime() 
    {
        return orderTime;
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
            .append("outsourcingOrderID", getOutsourcingOrderID())
            .append("productionTasksFormID", getProductionTasksFormID())
            .append("productionTasksID", getProductionTasksID())
            .append("processingprocessID", getProcessingprocessID())
            .append("outsourcingType", getOutsourcingType())
            .append("orderTime", getOrderTime())
            .append("notes", getNotes())
            .toString();
    }
}
