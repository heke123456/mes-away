package com.awise.produce.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 产品入库详单对象 aw_detailproductwarehousing
 * 
 * @author awise
 * @date 2023-10-24
 */
public class AwDetailproductwarehousing extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 产品入库单编号 */
    @Excel(name = "产品入库单编号")
    private String warehouseEntryID;

    /** 产品图号 */
    @Excel(name = "产品图号")
    private String productID;

    /** 入库数量 */
    @Excel(name = "入库数量")
    private Long receiptQuantity;

    /** 成品检验编号 */
    @Excel(name = "成品检验编号")
    private String FinishedProductInspectionID;

    /** 检测结果 */
    @Excel(name = "检测结果")
    private String testResult;

    /** 备注 */
    private String notes;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setWarehouseEntryID(String warehouseEntryID) 
    {
        this.warehouseEntryID = warehouseEntryID;
    }

    public String getWarehouseEntryID() 
    {
        return warehouseEntryID;
    }
    public void setProductID(String productID) 
    {
        this.productID = productID;
    }

    public String getProductID() 
    {
        return productID;
    }
    public void setReceiptQuantity(Long receiptQuantity) 
    {
        this.receiptQuantity = receiptQuantity;
    }

    public Long getReceiptQuantity() 
    {
        return receiptQuantity;
    }
    public void setFinishedProductInspectionID(String FinishedProductInspectionID) 
    {
        this.FinishedProductInspectionID = FinishedProductInspectionID;
    }

    public String getFinishedProductInspectionID() 
    {
        return FinishedProductInspectionID;
    }
    public void setTestResult(String testResult) 
    {
        this.testResult = testResult;
    }

    public String getTestResult() 
    {
        return testResult;
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
            .append("warehouseEntryID", getWarehouseEntryID())
            .append("productID", getProductID())
            .append("receiptQuantity", getReceiptQuantity())
            .append("FinishedProductInspectionID", getFinishedProductInspectionID())
            .append("testResult", getTestResult())
            .append("notes", getNotes())
            .toString();
    }
}
