package com.awise.quality.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 过程检验对象 aw_processinspection
 * 
 * @author awise
 * @date 2023-09-27
 */
public class AwProcessinspection extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 质检名称 */
    @Excel(name = "质检名称")
    private String nameOfQualityInspection;

    /** 质检类别 */
    @Excel(name = "质检类别",dictType = "aw_qualityinspectioncategory_dict")
    private String qualityInspectionCategory;

    /** 任务编号 */
    @Excel(name = "任务编号")
    private Long productionTasksID;

    /** 工序编号 */
    @Excel(name = "工序编号")
    private Long processingprocessID;

    /** 检测数量 */
    @Excel(name = "检测数量")
    private Long detectionQuantity;

    /** 合格数量 */
    @Excel(name = "合格数量")
    private Long qualifiedQuantity;

    /** 不合格数量 */
    @Excel(name = "不合格数量")
    private Long unqualifiedQuantity;

    /** 返修数量 */
    @Excel(name = "返修数量")
    private Long numberOfRepairs;

    /** 报废数量 */
    @Excel(name = "报废数量")
    private Long scrappedQuantity;

    /** 检测日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "检测日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date testDate;

    /** 检测结果 */
    @Excel(name = "检测结果",dictType = "aw_quality_processinspection_status")
    private String testResult;

    /** 检测人员 */
    @Excel(name = "检测人员")
    private String testingPersonnel;

    /** 加工人员 */
    @Excel(name = "检测人员")
    private String processingPersonnel;

    /** 备注 */
    @Excel(name = "备注")
    private String note;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setNameOfQualityInspection(String nameOfQualityInspection) 
    {
        this.nameOfQualityInspection = nameOfQualityInspection;
    }

    public String getNameOfQualityInspection() 
    {
        return nameOfQualityInspection;
    }
    public void setQualityInspectionCategory(String qualityInspectionCategory) 
    {
        this.qualityInspectionCategory = qualityInspectionCategory;
    }

    public String getQualityInspectionCategory() 
    {
        return qualityInspectionCategory;
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
    public void setNumberOfRepairs(Long numberOfRepairs) 
    {
        this.numberOfRepairs = numberOfRepairs;
    }

    public Long getNumberOfRepairs() 
    {
        return numberOfRepairs;
    }
    public void setScrappedQuantity(Long scrappedQuantity) 
    {
        this.scrappedQuantity = scrappedQuantity;
    }

    public Long getScrappedQuantity() 
    {
        return scrappedQuantity;
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
    public void setNote(String note) 
    {
        this.note = note;
    }

    public String getNote() 
    {
        return note;
    }


    public String getProcessingPersonnel() {
        return processingPersonnel;
    }

    public void setProcessingPersonnel(String processingPersonnel) {
        this.processingPersonnel = processingPersonnel;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("nameOfQualityInspection", getNameOfQualityInspection())
            .append("qualityInspectionCategory", getQualityInspectionCategory())
            .append("productionTasksID", getProductionTasksID())
            .append("processingprocessID", getProcessingprocessID())
            .append("detectionQuantity", getDetectionQuantity())
            .append("qualifiedQuantity", getQualifiedQuantity())
            .append("unqualifiedQuantity", getUnqualifiedQuantity())
            .append("numberOfRepairs", getNumberOfRepairs())
            .append("scrappedQuantity", getScrappedQuantity())
            .append("testDate", getTestDate())
            .append("testResult", getTestResult())
            .append("testingPersonnel", getTestingPersonnel())
            .append("processingPersonnel", getProcessingPersonnel())
            .append("note", getNote())
            .toString();
    }
}
