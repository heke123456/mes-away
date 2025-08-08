package com.awise.quality.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 成品出货检验对象 aw_shippinginspection
 * 
 * @author awise
 * @date 2023-10-16
 */
public class AwShippinginspection extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private String id;

    /** 产品图号 */
    @Excel(name = "产品图号")
    private String productID;

    /** 客户编号 */
    @Excel(name = "客户编号")
    private String contractID;

    /** 出货数量 */
    @Excel(name = "出货数量")
    private Long shipmentQuantity;

    /** 检测数量 */
    @Excel(name = "检测数量")
    private Long detectionQuantity;

    /** 合格数量 */
    @Excel(name = "合格数量")
    private Long qualifiedQuantity;

    /** 不合格数量 */
    @Excel(name = "不合格数量")
    private Long unqualifiedQuantity;

    /** 检测日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "检测日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date testDate;

    /** 检测结果 */
    @Excel(name = "检测结果",dictType = "aw_quality_shippinginspection_status")
    private String testResult;

    /** 检测人员 */
    @Excel(name = "检测人员")
    private String testingPersonnel;

    /** 备注 */
    @Excel(name = "备注")
    private String notes;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setProductID(String productID) 
    {
        this.productID = productID;
    }

    public String getProductID() 
    {
        return productID;
    }
    public void setContractID(String contractID) 
    {
        this.contractID = contractID;
    }

    public String getContractID() 
    {
        return contractID;
    }
    public void setShipmentQuantity(Long shipmentQuantity) 
    {
        this.shipmentQuantity = shipmentQuantity;
    }

    public Long getShipmentQuantity() 
    {
        return shipmentQuantity;
    }
    public void setDetectionQuantity(Long detectionQuantity) 
    {
        this.detectionQuantity = detectionQuantity;
    }

    public Long getDetectionQuantity() 
    {
        return detectionQuantity;
    }
    public void setQualifiedQuantity(Long qualifiedQuantity) 
    {
        this.qualifiedQuantity = qualifiedQuantity;
    }

    public Long getQualifiedQuantity() 
    {
        return qualifiedQuantity;
    }
    public void setUnqualifiedQuantity(Long unqualifiedQuantity) 
    {
        this.unqualifiedQuantity = unqualifiedQuantity;
    }

    public Long getUnqualifiedQuantity() 
    {
        return unqualifiedQuantity;
    }
    public void setTestDate(Date testDate) 
    {
        this.testDate = testDate;
    }

    public Date getTestDate() 
    {
        return testDate;
    }
    public void setTestResult(String testResult) 
    {
        this.testResult = testResult;
    }

    public String getTestResult() 
    {
        return testResult;
    }
    public void setTestingPersonnel(String testingPersonnel) 
    {
        this.testingPersonnel = testingPersonnel;
    }

    public String getTestingPersonnel() 
    {
        return testingPersonnel;
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
            .append("productID", getProductID())
            .append("contractID", getContractID())
            .append("shipmentQuantity", getShipmentQuantity())
            .append("detectionQuantity", getDetectionQuantity())
            .append("qualifiedQuantity", getQualifiedQuantity())
            .append("unqualifiedQuantity", getUnqualifiedQuantity())
            .append("testDate", getTestDate())
            .append("testResult", getTestResult())
            .append("testingPersonnel", getTestingPersonnel())
            .append("notes", getNotes())
            .toString();
    }
}
