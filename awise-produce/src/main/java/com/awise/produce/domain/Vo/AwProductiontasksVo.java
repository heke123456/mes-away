package com.awise.produce.domain.Vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 生产任务对象 aw_productiontasks
 * 
 * @author awise
 * @date 2023-09-27
 */
public class AwProductiontasksVo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 任务编号 */
    private Long id;

    /** 生产任务单编号 */
    @Excel(name = "生产任务单编号")
    private Long productionTasksFormID;

    /** 生产任务序号 */
    @Excel(name = "生产任务序号")
    private Long serialNum;

    /** 工艺编号 */
    @Excel(name = "工艺编号")
    private String processingTechnologyID;

    /** 销售订单编号 */
    @Excel(name = "销售订单编号")
    private String saleOrderID;

    /** 外协 */
    @Excel(name = "外协",dictType ="aw_produce_outsourcing" )
    private String outsourced;

    /** 备注 */
    @Excel(name = "备注")
    private String notes;

    /** 任务状态 */
    @Excel(name = "任务状态",dictType = "aw_produce_status")
    private String status;

    @Excel(name = "订单批次号")
     private  String lotNumber;
    @Excel(name = "产品编号")
    private  String productID;


    @Excel(name = "客户姓名")
    private  String customername;


    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setProductionTasksFormID(Long productionTasksFormID) 
    {
        this.productionTasksFormID = productionTasksFormID;
    }

    public Long getProductionTasksFormID() 
    {
        return productionTasksFormID;
    }
    public void setSerialNum(Long serialNum) 
    {
        this.serialNum = serialNum;
    }

    public Long getSerialNum() 
    {
        return serialNum;
    }
    public void setProcessingTechnologyID(String processingTechnologyID) 
    {
        this.processingTechnologyID = processingTechnologyID;
    }

    public String getProcessingTechnologyID() 
    {
        return processingTechnologyID;
    }
    public void setSaleOrderID(String saleOrderID) 
    {
        this.saleOrderID = saleOrderID;
    }

    public String getSaleOrderID() 
    {
        return saleOrderID;
    }
    public void setOutsourced(String outsourced) 
    {
        this.outsourced = outsourced;
    }

    public String getOutsourced() 
    {
        return outsourced;
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


    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("productionTasksFormID", getProductionTasksFormID())
            .append("serialNum", getSerialNum())
            .append("processingTechnologyID", getProcessingTechnologyID())
            .append("saleOrderID", getSaleOrderID())
            .append("outsourced", getOutsourced())
            .append("notes", getNotes())
            .append("status", getStatus())
            .toString();
    }
}
