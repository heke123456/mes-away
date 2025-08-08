package com.awise.order.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.away.common.annotation.Excel;
import com.away.common.core.domain.BaseEntity;

/**
 * 申购材料详细对象 aw_detailmaterialsubscription
 * 
 * @author awise
 * @date 2023-10-17
 */
public class AwDetailmaterialsubscription extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 申购材料编号 */
    @Excel(name = "申购材料编号")
    private String materialSubscription;

    /** 申购单编号 */
    @Excel(name = "申购单编号")
    private String subscribeID;

    /** 任务编号 */
    @Excel(name = "任务编号")
    private Long productionTasksID;

    /** 材料信息编号 */
    private String materialID;

    /** 材料名称 */
    @Excel(name = "材料名称")
    private String name;



    /** 材料价格 */
    @Excel(name = "材料价格")
    private String materialPrice;

    /** 类别名称 */
    @Excel(name = "类别名称")
    private String typeName;

    /** 规格类型 */
    private String specificationsType;

    /** 规格型号 */
    @Excel(name = "规格型号")
    private String specificationModel;

    /** 材料密度 */
    private String materialDensity;

    /** 工艺编号 */
    @Excel(name = "工艺编号")
    private String processingTechnologyID;

    /** 申购数量 */
    @Excel(name = "申购数量")
    private Long subscriptionQuantity;

    /** 需用日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "需用日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date requiredDate;

    /** 附样 */
    private String sampleURL;

    /** 备注 */
    private String note;

    public void setMaterialSubscription(String materialSubscription) 
    {
        this.materialSubscription = materialSubscription;
    }

    public String getMaterialSubscription() 
    {
        return materialSubscription;
    }
    public void setSubscribeID(String subscribeID) 
    {
        this.subscribeID = subscribeID;
    }

    public String getSubscribeID() 
    {
        return subscribeID;
    }
    public void setProductionTasksID(Long productionTasksID) 
    {
        this.productionTasksID = productionTasksID;
    }

    public Long getProductionTasksID() 
    {
        return productionTasksID;
    }
    public void setMaterialID(String materialID) 
    {
        this.materialID = materialID;
    }

    public String getMaterialID() 
    {
        return materialID;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setTypeName(String typeName) 
    {
        this.typeName = typeName;
    }

    public String getTypeName() 
    {
        return typeName;
    }
    public void setSpecificationsType(String specificationsType) 
    {
        this.specificationsType = specificationsType;
    }

    public String getSpecificationsType() 
    {
        return specificationsType;
    }
    public void setSpecificationModel(String specificationModel) 
    {
        this.specificationModel = specificationModel;
    }

    public String getSpecificationModel() 
    {
        return specificationModel;
    }
    public void setMaterialDensity(String materialDensity) 
    {
        this.materialDensity = materialDensity;
    }

    public String getMaterialDensity() 
    {
        return materialDensity;
    }
    public void setProcessingTechnologyID(String processingTechnologyID) 
    {
        this.processingTechnologyID = processingTechnologyID;
    }

    public String getProcessingTechnologyID() 
    {
        return processingTechnologyID;
    }
    public void setSubscriptionQuantity(Long subscriptionQuantity) 
    {
        this.subscriptionQuantity = subscriptionQuantity;
    }

    public Long getSubscriptionQuantity() 
    {
        return subscriptionQuantity;
    }
    public void setRequiredDate(Date requiredDate) 
    {
        this.requiredDate = requiredDate;
    }

    public Date getRequiredDate() 
    {
        return requiredDate;
    }
    public void setSampleURL(String sampleURL) 
    {
        this.sampleURL = sampleURL;
    }

    public String getSampleURL() 
    {
        return sampleURL;
    }
    public void setNote(String note) 
    {
        this.note = note;
    }

    public String getNote() 
    {
        return note;
    }


    public String getMaterialPrice() {
        return materialPrice;
    }

    public void setMaterialPrice(String materialPrice) {
        this.materialPrice = materialPrice;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("materialSubscription", getMaterialSubscription())
            .append("subscribeID", getSubscribeID())
            .append("productionTasksID", getProductionTasksID())
            .append("materialID", getMaterialID())
            .append("name", getName())
            .append("materialPrice", getMaterialPrice())
            .append("typeName", getTypeName())
            .append("specificationsType", getSpecificationsType())
            .append("specificationModel", getSpecificationModel())
            .append("materialDensity", getMaterialDensity())
            .append("processingTechnologyID", getProcessingTechnologyID())
            .append("subscriptionQuantity", getSubscriptionQuantity())
            .append("requiredDate", getRequiredDate())
            .append("sampleURL", getSampleURL())
            .append("note", getNote())
            .toString();
    }
}
