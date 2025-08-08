package com.awise.produce.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 生产工艺工序详细对象 aw_detprodproc
 * 
 * @author awise
 * @date 2023-11-02
 */
public class AwDetprodproc extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 生产任务单编号 */
    @Excel(name = "生产任务单编号")
    private Long productionTasksFormID;

    /** 任务编号 */
    @Excel(name = "任务编号")
    private Long productionTasksID;

    /** 工艺编号 */
    @Excel(name = "工艺编号")
    private String processingTechnologyID;

    /** 工序编号 */
    @Excel(name = "工序编号")
    private Long processingprocessID;

    /** 工序序号 */
    @Excel(name = "工序序号")
    private Long number;

    /** 工序名称 */
    @Excel(name = "工序名称")
    private String name;

    /** 工序内容 */
    @Excel(name = "工序内容")
    private String content;

    /** 工序简图URL */
    @Excel(name = "工序简图URL")
    private String diagramURL;

    /** 所用工装 */
    @Excel(name = "所用工装")
    private String usedTooling;

    /** 准备工时 */
    @Excel(name = "准备工时")
    private String preparationHours;

    /** 单件工时 */
    @Excel(name = "单件工时")
    private String taktTime;

    /** 工时成本 */
    @Excel(name = "工时成本")
    private String laborCost;

    /** 工序外协 */
    @Excel(name = "工序外协")
    private String outsourcing;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

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
    public void setProcessingTechnologyID(String processingTechnologyID) 
    {
        this.processingTechnologyID = processingTechnologyID;
    }

    public String getProcessingTechnologyID() 
    {
        return processingTechnologyID;
    }
    public void setProcessingprocessID(Long processingprocessID) 
    {
        this.processingprocessID = processingprocessID;
    }

    public Long getProcessingprocessID() 
    {
        return processingprocessID;
    }
    public void setNumber(Long number) 
    {
        this.number = number;
    }

    public Long getNumber() 
    {
        return number;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setDiagramURL(String diagramURL) 
    {
        this.diagramURL = diagramURL;
    }

    public String getDiagramURL() 
    {
        return diagramURL;
    }
    public void setUsedTooling(String usedTooling) 
    {
        this.usedTooling = usedTooling;
    }

    public String getUsedTooling() 
    {
        return usedTooling;
    }
    public void setPreparationHours(String preparationHours) 
    {
        this.preparationHours = preparationHours;
    }

    public String getPreparationHours() 
    {
        return preparationHours;
    }
    public void setTaktTime(String taktTime) 
    {
        this.taktTime = taktTime;
    }

    public String getTaktTime() 
    {
        return taktTime;
    }
    public void setLaborCost(String laborCost) 
    {
        this.laborCost = laborCost;
    }

    public String getLaborCost() 
    {
        return laborCost;
    }
    public void setOutsourcing(String outsourcing) 
    {
        this.outsourcing = outsourcing;
    }

    public String getOutsourcing() 
    {
        return outsourcing;
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
            .append("productionTasksFormID", getProductionTasksFormID())
            .append("productionTasksID", getProductionTasksID())
            .append("processingTechnologyID", getProcessingTechnologyID())
            .append("processingprocessID", getProcessingprocessID())
            .append("number", getNumber())
            .append("name", getName())
            .append("content", getContent())
            .append("diagramURL", getDiagramURL())
            .append("usedTooling", getUsedTooling())
            .append("preparationHours", getPreparationHours())
            .append("taktTime", getTaktTime())
            .append("laborCost", getLaborCost())
            .append("outsourcing", getOutsourcing())
            .append("status", getStatus())
            .toString();
    }
}
