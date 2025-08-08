package com.awise.produce.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 工时统计详细对象 aw_detailproductmanhour
 * 
 * @author awise
 * @date 2024-04-14
 */
public class AwDetailproductmanhour extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 工时id */
    private Long id;

    /** 订单id */
    @Excel(name = "订单id")
    private String saleorderID;

    /** 生产任务id */
    @Excel(name = "生产任务id")
    private Long productiontasksID;

    /** 加工工序 */
    @Excel(name = "加工工序")
    private Long processingprocess;

    /** 工时名字 */
    @Excel(name = "工时名字")
    private String manhourName;

    /** 班别 */
    @Excel(name = "班别")
    private String workClass;

    /** 机台号 */
    @Excel(name = "机台号")
    private String PlatformNumber;

    /** 合格数量 */
    @Excel(name = "合格数量")
    private Long qualifiedQuantity;

    /** 报废数量 */
    @Excel(name = "报废数量")
    private Long scrapQuantity;

    /** 批次号 */
    @Excel(name = "批次号")
    private String lotNumber;

    /** 工时时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "工时时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date manhoursTime;

    /** 制定者名字 */
    @Excel(name = "制定者名字")
    private String formulateName1;


    /** 操作者 */
    @Excel(name = "操作者")
    private String handlers1;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date beginTime1;

    /** 最后时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最后时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime1;

    /** 实际时间 */
    @Excel(name = "实际时间")
    private String actualTime1;

    /** 制定者名字 */
    @Excel(name = "制定者名字")
    private String formulateName2;


    /** 操作者 */
    @Excel(name = "操作者")
    private String handlers2;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date beginTime2;

    /** 最后时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最后时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime2;

    /** 实际时间 */
    @Excel(name = "实际时间")
    private String actualTime2;

    /** 需求数量#要求大于0# */
    @Excel(name = "需求数量")
    private Long number;

    /** 工序名称 */
    @Excel(name = "工序名称")
    private String name;

    /** 准备工时 */
    @Excel(name = "准备工时")
    private String preparationHours;

    /** 单件工时 */
    @Excel(name = "单件工时")
    private String taktTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSaleorderID(String saleorderID) 
    {
        this.saleorderID = saleorderID;
    }

    public String getSaleorderID() 
    {
        return saleorderID;
    }
    public void setProductiontasksID(Long productiontasksID) 
    {
        this.productiontasksID = productiontasksID;
    }

    public Long getProductiontasksID() 
    {
        return productiontasksID;
    }
    public void setProcessingprocess(Long processingprocess) 
    {
        this.processingprocess = processingprocess;
    }

    public Long getProcessingprocess() 
    {
        return processingprocess;
    }
    public void setManhourName(String manhourName) 
    {
        this.manhourName = manhourName;
    }

    public String getManhourName() 
    {
        return manhourName;
    }
    public void setWorkClass(String workClass) 
    {
        this.workClass = workClass;
    }

    public String getWorkClass() 
    {
        return workClass;
    }
    public void setPlatformNumber(String PlatformNumber) 
    {
        this.PlatformNumber = PlatformNumber;
    }

    public String getPlatformNumber() 
    {
        return PlatformNumber;
    }

    public void setQualifiedQuantity(Long qualifiedQuantity) 
    {
        this.qualifiedQuantity = qualifiedQuantity;
    }

    public Long getQualifiedQuantity() 
    {
        return qualifiedQuantity;
    }
    public void setScrapQuantity(Long scrapQuantity) 
    {
        this.scrapQuantity = scrapQuantity;
    }

    public Long getScrapQuantity() 
    {
        return scrapQuantity;
    }
    public void setLotNumber(String lotNumber)
    {
        this.lotNumber = lotNumber;
    }

    public String getLotNumber()
    {
        return lotNumber;
    }
    public void setManhoursTime(Date manhoursTime) 
    {
        this.manhoursTime = manhoursTime;
    }

    public Date getManhoursTime() 
    {
        return manhoursTime;
    }
    public void setFormulateName1(String formulateName1) 
    {
        this.formulateName1 = formulateName1;
    }

    public String getFormulateName1() 
    {
        return formulateName1;
    }


    public void setHandlers1(String handlers1) 
    {
        this.handlers1 = handlers1;
    }

    public String getHandlers1() 
    {
        return handlers1;
    }
    public void setBeginTime1(Date beginTime1) 
    {
        this.beginTime1 = beginTime1;
    }

    public Date getBeginTime1() 
    {
        return beginTime1;
    }
    public void setEndTime1(Date endTime1) 
    {
        this.endTime1 = endTime1;
    }

    public Date getEndTime1() 
    {
        return endTime1;
    }
    public void setActualTime1(String actualTime1) 
    {
        this.actualTime1 = actualTime1;
    }

    public String getActualTime1() 
    {
        return actualTime1;
    }
    public void setFormulateName2(String formulateName2) 
    {
        this.formulateName2 = formulateName2;
    }

    public String getFormulateName2() 
    {
        return formulateName2;
    }


    public void setHandlers2(String handlers2) 
    {
        this.handlers2 = handlers2;
    }

    public String getHandlers2() 
    {
        return handlers2;
    }
    public void setBeginTime2(Date beginTime2) 
    {
        this.beginTime2 = beginTime2;
    }

    public Date getBeginTime2() 
    {
        return beginTime2;
    }
    public void setEndTime2(Date endTime2) 
    {
        this.endTime2 = endTime2;
    }

    public Date getEndTime2() 
    {
        return endTime2;
    }
    public void setActualTime2(String actualTime2) 
    {
        this.actualTime2 = actualTime2;
    }

    public String getActualTime2() 
    {
        return actualTime2;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("saleorderID", getSaleorderID())
            .append("productiontasksID", getProductiontasksID())
            .append("processingprocess", getProcessingprocess())
            .append("manhourName", getManhourName())
            .append("workClass", getWorkClass())
            .append("PlatformNumber", getPlatformNumber())
            .append("qualifiedQuantity", getQualifiedQuantity())
            .append("scrapQuantity", getScrapQuantity())
            .append("lotNumber", getLotNumber())
            .append("manhoursTime", getManhoursTime())
            .append("formulateName1", getFormulateName1())
            .append("handlers1", getHandlers1())
            .append("beginTime1", getBeginTime1())
            .append("endTime1", getEndTime1())
            .append("actualTime1", getActualTime1())
            .append("formulateName2", getFormulateName2())
            .append("handlers2", getHandlers2())
            .append("beginTime2", getBeginTime2())
            .append("endTime2", getEndTime2())
            .append("actualTime2", getActualTime2())
            .append("number", getNumber())
            .append("name", getName())
            .append("preparationHours", getPreparationHours())
            .append("taktTime", getTaktTime())
            .toString();
    }
}
